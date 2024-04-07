Spring GraphQL Workshop - August 2023
===
Example project from the August 2023 GraphQL workshop.

## Post-Workshop Notes

### Using conditionals in fragments

During the workshop, I bravely attempted to demonstrate
the use of conditionals when using fragments...and failed
miserably. I've since figured out what I was doing wrong.

First, I had to include the `withAuthor` argument in the
`allBooks` query in the schema:

```graphql
allBooks(withAuthor: Boolean): [Book!]
```

Notice that I did not make `withAuthor` non-null. This
allows the query to be used without specifying the argument.

Then the query and fragment become the same as what I tried
during the workshop:

```graphql
fragment bookFields on Book {
    isbn
    title
    author @include(if: $withAuthor) {
      firstName
      lastName
    }   
}

query AllBooks($withAuthor: Boolean!) {
  allBooks(withAuthor: $withAuthor) {
    ...bookFields
  }
}
```

In GraphiQL, you can then specify the `withAuthor` argument
as a variable (under the "Variables" tab near the bottom):

```graphql
{
  "withAuthor": true
}
```

Note that although the `withAuthor` argument is not required,
if you are using the fragment in the query, you must specify it
because the fragment requires it to decide whether or not to
include author details.

### Issuing multiple queries in a single request

During the workshop, I mentioned that you can issue multiple
queries in a single request. I started to demonstrate it, but
got a little mixed up on how it works. Here's an example of
how to do it:

```graphql
query {
  allBooks {
    isbn
    title
  }
  allAuthors {
    firstName
    lastName
  }
}
```

This will return a response with two top-level keys, one for
each query:

```json
{
  "data": {
    "allBooks": [
      {
        "isbn": "1122334455",
        "title": "Knitting with Dog Hair"
      },
      {
        "isbn": "5544332211",
        "title": "Crafting with Cat Hair"
      }
    ],
    "allAuthors": [
      {
        "firstName": "Kendall",
        "lastName": "Crolius"
      },
      {
        "firstName": "Kaori",
        "lastName": "Tsutaya"
      }
    ]
  }
}
```

When using `HttpGraphQlClient` this is why you specify which
set of results you want by passing the query name to the
`.retrieve()` method. For example:

```java
Mono<List<Book>> entityList = qlClient.documentName("allBooksAndAllAuthors")
        .retrieve("allBooks")
        .toEntityList(Book.class);
```
