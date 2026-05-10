# Sample Attempt to Produce a Native Binary with GraalVM with JavaFX

The project has two modules:

* `javafx-graal-feature` - contains a GraalVM native image feature which when added as a maven dependency should add the lower level libraries
* `javafx-sample` - a trivial javafx application

You should provide reachability metadata for the `javafx.*` classes you use. Consider opening a PR for `com.sun` etc.

Note: this may not be a minimal configuration and may included redundant or irrelevant settings.

When running a binary consider using `-Dprism.verbose=true` which turns on debug logging.

## Windows

Starts successfully

## Linux

Starts successfully

## Mac

Currently does not build. Fixing will still not create a successful application as Mac requires the UI be on the first thread.