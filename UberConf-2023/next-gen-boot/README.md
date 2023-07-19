# Next Generation Spring Boot Workshop

This directory contains the code written during the Next-Generation Spring Boot workshop at UberConf 2023 on July 18th, 2023.

At this time, the directories are:

 - `testcontainers-books` : The Books API from much of the workshop, including some of the work done in the first 3 sections of the workshop, but primarily focused on showing how to test and run a Spring Boot app and test with a PostgreSQL DB in a container. This was reworked into JPA because of struggles with making it work with Spring Data JDBC.
 - `rsocket-examples` : Example code of an RSocket "server" and "client" used primarily to demonstrate how to create declarative RSocket clients in Spring 6.

I still owe you the following examples:

- The Library API, demonstrating how to use Spring 6.1.0's `RestClient` as well as how to create declarative HTTP clients with Spring 6.
- Both the Books and Library APIs with monitoring and tracing.

I will get those examples in here as soon as I have opportunity. I just want to tidy them up a bit and make sure that they are working before pushing them into GitHub.
