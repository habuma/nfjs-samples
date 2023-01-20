# Putting Your Best Boot Forward - Austin Java User Group 10/4/2022

This directory includes the code written during the presentation given at the Austin Java User Group on October 4, 2022. The code from the presentation is in the "aus-books" directory.

During that presentation, I had trouble with the GraphQL query that was expected to return all books. Specifically, the error given was "Cannot map empty Criteria". In the moment, I was wrongly thinking that this was a GraphQL problem. In fact, it was an issue with how the JDBC implementation of `QueryByExampleExecutor` doesn't seem to like it when you create an example object where all properties are null.

Effectively, the underlying GraphQL code that is issuing a by-example query, something like the following:

```
Example<Book> example = Example.of(new Book(null, null, null, null));
Iterable<Book> all = repo.findAll(example);
```

The expectation is that if all properties are null, then a query by example should return every book; because all books will match. But, apparently the JDBC implementation (see the `org.springframework.data.jdbc.core.convert.QueryMapper` class' `getMappedObject()` method) explicitly throws an `IllegalArgumentException` in that case.

The reason that this has worked for me before is that in other instances of this presentation, I've relied on Spring Data JPA (not Spring Data JDBC). The JPA implementation has no problems with an example where every property is null.

So you might be asking "Why does the JDBC implementation not allow this?" Honestly, I do not know. I'm going to need to chat with some of the developers of that library to understand why that restriction exists and if there's any chance that they could remove it.

Notice, I've added a "byIsbn" query to the GraphQL schema. This works because the example object's `isbn` property will not be null.

To try this out yourself, run the application. The easiest way is to use the Spring Boot Maven plugin like this:

```
% ./mvnw spring-boot:run
```

Then issue queries via your favorite HTTP client. Using HTTPie, you can issue the "byIsbn" query like this:

```
% http :8080/graphql query='{byIsbn(isbn: "1122334455"){isbn title author}}'
```

This should return a single book matching the given ISBN. (Hint: Try it with "5544332211" as well).

You can also try the "books" query (although it won't work):

```
% http :8080/graphql query='{books{isbn title author}}'
```

For comparison, I've also included a similar project (in the "graph-books" directory) that is based on Spring Data JPA. If running that project, both queries should work fine.
