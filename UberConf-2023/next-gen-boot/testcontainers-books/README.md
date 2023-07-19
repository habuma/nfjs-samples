# Testcontainers Books

I struggled a bit with getting the Testcontainers stuff to work right with Spring Data JDBC and PostgreSQL. I'm convinced it *should* work, but I was having trouble finding the right incantation to make it work. So...

I reworked the example to use Spring Data JPA with PostgreSQL. This is probably how I should've done it in the first place, because *at least* I could count on Hibernate to produce the correct DDL for the schema, which is what I think I was struggling with doing correctly with JDBC.

Other than that, this example contains all of the work we did with regard to the Books API up through the Testcontainers and Docker Compose section.

The Library API (which we used to demonstrate various HTTP clients) will be in a separate subdirectory.
