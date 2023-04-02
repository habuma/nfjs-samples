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
