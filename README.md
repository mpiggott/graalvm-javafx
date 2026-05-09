# Sample Attempt to Produce a Native Binary with GraalVM with JavaFX

Note, this may not be a minimal configuration and may included redundant or irrelevant settings.

When running a binary I recommend using `-Dprism.verbose=true` which turns on debug logging.


## Mac

While this compiles, and starts the JavaFX pipeline:

```
% target/graal.sample -Dprism.verbose=true
Starting on thread: 3
May 10, 2026 9:48:39 AM com.sun.javafx.application.PlatformImpl startup
WARNING: Unsupported JavaFX configuration: classes were loaded from 'unnamed module @3adfca94'
Prism pipeline init order: es2 mtl sw 
Using Double Precision Marlin Rasterizer
Using dirty region optimizations
Not using texture mask for primitives
Not forcing power of 2 sizes for textures
Using hardware CLAMP_TO_ZERO mode
Opting in for HiDPI pixel scaling
Not forcing UploadingPainter
Prism pipeline name = com.sun.prism.es2.ES2Pipeline
Loading ES2 native library ... prism_es2
	succeeded.
GLFactory using com.sun.prism.es2.MacGLFactory
(X) Got class = class com.sun.prism.es2.ES2Pipeline
Initialized prism pipeline: com.sun.prism.es2.ES2Pipeline
```

no window appears.

My undertanding is that is caused by the fact that MacOS requires the UI to be on the first thread.
