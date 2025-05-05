Northern Virginia Software Symposium 2024
===
These are the examples from Craig's sessions at the Northern Virginia
Software Symposium 2024.

Note: These files represent the final state of the code from those sessions,
not necessarily any in-progress state that got us there.

If there's anything you wanted to see in these examples that I don't remember
promising to address, let me know and I'll try to get it in.

The Spring AI Example
---
I finally figured out what the problem was with the Spring AI RAG example. Put
simply, the Docker Compose dependency was in build.gradle as a `developmentOnly`
dependency, which means it wasn't available to start Chroma when the app is
running. I have no idea how that happened (possibly some quirk with the Spring
Boot Initializr). But I changed it to `runtimeOnly` and it works.

Along the way, I also tidied up the Docker Compose YAML, removed a syserr debug
line, and did a few other small tweaks. Once it's running, you can ask about
Carcassonne rules like this:

```
$ http :8080/ask question="How do you score monasteries?" -b
{
    "answer": "In the game of Carcassonne, monasteries are scored as follows:\n\n1. A monastery scores 9 points if it is completely surrounded by tiles, including the tile it is on.\n2. If it is not completely surrounded, it scores 1 point for each tile that is adjacent to it (including the tile it is on).\n\nTo summarize, ensure that you count all the surrounding tiles when calculating the score for the monastery."
}
```
