Spring AI Example
===

This is the simple Spring AI example from Craig's session at the Greater Wisconsin
Software Symposium on May 17th, 2024.

## Running the Example

After the session concluded, I made a few changes to the code to make it more fun and
perhaps easier to run. 

The biggest change I made was to extract the joke example into its own controller so
that the joke example and the question example can coexist in the application.

Another important change I made (albeit insignificant in terms of lines of code changed)
was to replace the OpenAI API with Ollama's API and the use of the Llama3 model. You'll
need to install Ollama (https://ollama.com/) on your machine and, once installed, pull
the Llama3 model:

```shell
$ ollama pull llama3:latest
```

If you choose to use OpenAI instead, simply follow the instructions in the comments of
build.gradle and src/main/resources/application.properties.

Once you've settled on your model, you can run the app using Gradle like this:

```shell
$ ./gradlew bootRun
```

Then submit requests to the application using curl or HTTPie. For example, using
HTTPie:

```shell
$ http :8080/ask question="Why is the sky blue?"
...
$ http :8080/joke --pretty none subject="time travel"
```


