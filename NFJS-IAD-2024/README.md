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
Also note, that the Spring AI RAG example is (for some reason) still not
working. I decided it best to get the code checked in rather than delay while
figuring out why it isn't working. I have compared that project with another
similar project that is known to work and cannot see the difference.

The core of the problem is that (for some reason) the catalog/schema is not
being initialized on startup. I debugged into the initialization logic in both
the working and non-working example. In the working example, an exception is
thrown when the catalog is not found and that exception is handled by returning
null, which ultimately results in the collection being created. But in the
non-working code, that exception is (for reasons still unclear) not being handled
or possibly a different exception is being thrown.

I'll figure it out. But as I said, I want to check the code in for you to see.
And, of course, if anyone else figures it out, that'd be great, too.
