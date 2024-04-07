# Best Boot Forward Workshop - March 2023

Here is the code written during the workshop. The only thing
changed afterward is that I added an additional observation
example in `BooksController` to demonstrate how to use AOP to
add observability to a method. Specifically, these changes
were made:

 * I added the AOP starter to pom.xml
 * I declared the `ObservedAspect` bean in `BooksApplication.java`
 * I added an `@Observed` annotation to the controllers' `bookByIsbn()` method.

After running the application and having made at least one request to the endpoint, you should be able to go to http://localhost:8080/actuator/metrics and see the metrics for the observations listed. Digging into http://localhost:8080/actuator/metrics/allBooks and http://localhost:8080/metrics/bookByIsbn endpoints will give you specific metrics for those observations. Adding ".active" to either of those metric endpoints should show any active threads handling requests for those endpoints.


## Running Prometheus

I also promised that I'd share my notes on how to tie this into Prometheus. Here they are (edited only slightly to be relevant to the books example):

- Add Micrometer Prometheus library:

~~~
<dependency>
  <groupId>io.micrometer</groupId>
  <artifactId>micrometer-registry-prometheus</artifactId>
  <scope>runtime</scope>
</dependency>
~~~

- Determine your machine's IP address (can't be localhost or 127.0.0.1 because it will be accessed from within a container)
- Create a prometheus.yml file:

~~~
global:
  scrape_interval:     15s
  evaluation_interval: 15s
scrape_configs:
  - job_name: 'spring boot scrape'
    metrics_path: '/actuator/prometheus'
    scrape_interval: 5s
    static_configs:
      - targets: ['<<YOUR IP ADDRESS>>:8080']
~~~

- Start Prometheus with Docker:

~~~
$ docker run \
    -p 9090:9090 \
    -v /path/to/prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus
~~~

- Hit the "/books" and/or "/books/{isbn}" endpoints at least once to get the metric entry in play.
- Open your browser to http://localhost:9090
- Search for the relevant metrics and click the "Execute" button.
