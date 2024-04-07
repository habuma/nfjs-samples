= Spring GraphQL

This is the code from Craig's Spring GraphQL session at Gateway Software Symposium
in St. Louis, MO, March 31, 2023.

If you have any questions, issues, or suggestions for improvement, please
create an issue in this repository and specifically reference this folder and/or
specific files herein.

There was a pending question on how to deal with GraphQL queries where the subselect
might include many fields. In other words, is there a way to do the equivalent of
"SELECT *" in a GraphQL query. My followup research has turned up nothing with
regard to this aside from a statement that this was purposefully left out of the
GraphQL Query spec.

That said, GraphQL does support something called "fragments" that might help a
little with this. "Fragments" was the concept that I couldn't recall during the
session and was thinking might help. Rather than explain Fragments in this README,
here's a link to the official documentation for your review:
https://graphql.org/learn/queries/#fragments

In fact, in that same document there are several more advanced techniques for
working with GraphQL that never would have fit within that one session at NFJS.
As you review that document, if you see any technique that you particularly like
and think would be good for me to add to my presentation, let me know at the email
given on my slides during the presentation or by creating an issue in this repository.

I also ran out of time before creating a GraphQL client. I anticipate finding time
soon to add such an example, but wanted to get what code I have available pushed
to GitHub as soon as possible. I'll follow up with a client example soon. There
is also a client example already in https://github.com/habuma/nfjs-samples/tree/main/NFJS-GraphQLWS-Jan2023/books-ql-client
if you are eager to see what it would look like.

## Followup on fragments...

I tinkered with the example a little and added one query to the schema:

~~~
booksByTitle(title: String): [Book]
~~~

Then, I was able to issue this query:

~~~
{
  booksByTitle(title: "Crafting with Cat Hair") {
      isbn
      title
		  author {
    		lastName
  		}
  }
}
~~~

Which, of course, gave me a single book in the reply:

~~~
{
  "data": {
    "booksByTitle": [
      {
        "isbn": "5544332211",
        "title": "Crafting with Cat Hair",
        "author": {
          "lastName": "Tsutaya"
        }
      }
    ]
  }
}
~~~

But then, I created an alias for the query and added a few more queries in the
same submission:

~~~
{
  catBooks: booksByTitle(title: "Crafting with Cat Hair") {
      isbn
      title
		  author {
    		lastName
  		}
  }
  dogBooks: booksByTitle(title: "Knitting with Dog Hair") {
      isbn
      title
		  author {
    		lastName
  		}
  }
  all: booksByTitle {
      isbn
      title
		  author {
    		lastName
  		}
  }
  allBooks {
      isbn
      title
		  author {
    		lastName
  		}
  }
}
~~~

Which resulted in this:

~~~
{
  "data": {
    "catBooks": [
      {
        "isbn": "5544332211",
        "title": "Crafting with Cat Hair",
        "author": {
          "lastName": "Tsutaya"
        }
      }
    ],
    "dogBooks": [
      {
        "isbn": "1122334455",
        "title": "Knitting with Dog Hair",
        "author": {
          "lastName": "Crolius"
        }
      }
    ],
    "all": [
      {
        "isbn": "1122334455",
        "title": "Knitting with Dog Hair",
        "author": {
          "lastName": "Crolius"
        }
      },
      {
        "isbn": "5544332211",
        "title": "Crafting with Cat Hair",
        "author": {
          "lastName": "Tsutaya"
        }
      }
    ],
    "allBooks": [
      {
        "isbn": "1122334455",
        "title": "Knitting with Dog Hair",
        "author": {
          "lastName": "Crolius"
        }
      },
      {
        "isbn": "5544332211",
        "title": "Crafting with Cat Hair",
        "author": {
          "lastName": "Tsutaya"
        }
      }
    ]
  }
}
~~~

Awesome! It's a kinda silly thing I'm asking for, but I essentially sent 4 queries
at once, three of which are aliased so that there's no name collision in the
response.

But what about all of those subselects on all of the queries? They're repeated
every time. To get rid of the repetition, let's create a fragment:

~~~
fragment bookFields on Book {
  isbn
  title
  author {
    lastName
  }
}

{
  catBooks: booksByTitle(title: "Crafting with Cat Hair") {
		...bookFields
  }
  dogBooks: booksByTitle(title: "Knitting with Dog Hair") {
		...bookFields
  }
  all: booksByTitle {
		...bookFields
  }
  allBooks {
		...bookFields
  }
}
~~~

So, while this doesn't exactly let me wildcard my subselects, it does help me
avoid duplication when I'm going to specify the same fields in the subselect
for many queries.
