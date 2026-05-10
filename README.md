# Sample Attempt to Produce a Native Binary with GraalVM with JavaFX

The project has two modules:

* `javafx-graal-feature` - contains a GraalVM native image feature which when added as a maven dependency should add the lower level libraries
* `javafx-sample` - a trivial javafx application

Note: this may not be a minimal configuration and may included redundant or irrelevant settings.

When running a binary consider using `-Dprism.verbose=true` which turns on debug logging.




## Mac

This starts without errors but no user interface appears. My understanding is that the issue here is that MacOS requires the UI thread to be
the first thread, and as visible by the `starting on thread` sysout line we can see it is on thread 3.

```
% javafx-sample\target\javafx-sample -Dprism.verbose=true
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

## Windows

Currently this does not start successfully, the failure point appears to be `fontFactory` is null.

I believe the failure point is `fontFactory` - https://github.com/openjdk/jfx/blob/master/modules/javafx.graphics/src/main/java/com/sun/javafx/font/PrismFontLoader.java#L210

```
javafx-sample\target\javafx-sample.exe -Dprism.verbose=true -Dglass.verbose=true
Starting on thread: 3
May 10, 2026 11:18:24 AM com.sun.javafx.application.PlatformImpl startup
WARNING: Unsupported JavaFX configuration: classes were loaded from 'unnamed module @7abfb6b8'
Prism pipeline init order: d3d sw
Using Double Precision Marlin Rasterizer
Using dirty region optimizations
Not using texture mask for primitives
Not forcing power of 2 sizes for textures
Using hardware CLAMP_TO_ZERO mode
Opting in for HiDPI pixel scaling
Not forcing UploadingPainter
Prism pipeline name = com.sun.prism.d3d.D3DPipeline
Loading D3D native library ...
        succeeded.
D3DPipelineManager: Created D3D9Ex device
Direct3D initialization succeeded
(X) Got class = class com.sun.prism.d3d.D3DPipeline
Initialized prism pipeline: com.sun.prism.d3d.D3DPipeline
Maximum supported texture size: 16384
Maximum texture size clamped to 4096
OS Information:
        Windows 8.0 build 9200
D3D Driver Information:
        NVIDIA GeForce RTX 5080
        \\.\DISPLAY1
        Driver nvldumdx.dll, version 32.0.15.9174
        Pixel Shader version 3.0
        Device : ven_10DE, dev_2C02, subsys_89E11043
        Max Multisamples supported: 4
 vsync: true vpipe: true
Exception in Application start method
QuantumRenderer: shutdown
Exception in thread "main" java.lang.RuntimeException: Exception in Application start method
        at com.sun.javafx.application.LauncherImpl.launchApplication1(LauncherImpl.java:899)
        at com.sun.javafx.application.LauncherImpl.lambda$launchApplication$0(LauncherImpl.java:202)
        at java.base@25.0.2/java.lang.Thread.runWith(Thread.java:1487)
        at java.base@25.0.2/java.lang.Thread.run(Thread.java:1474)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:832)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:808)
Caused by: java.lang.ExceptionInInitializerError
        at javafx.scene.Node.reapplyCss(Node.java:9967)
        at javafx.scene.Node.reapplyCSS(Node.java:9930)
        at javafx.scene.Node.invalidatedScenes(Node.java:1165)
        at javafx.scene.Node.setScenes(Node.java:1230)
        at javafx.scene.Parent.scenesChanged(Parent.java:837)
        at javafx.scene.Node.invalidatedScenes(Node.java:1163)
        at javafx.scene.Node.setScenes(Node.java:1230)
        at javafx.scene.Scene$8.invalidated(Scene.java:1308)
        at javafx.beans.property.ObjectPropertyBase.markInvalid(ObjectPropertyBase.java:112)
        at javafx.beans.property.ObjectPropertyBase.set(ObjectPropertyBase.java:147)
        at javafx.scene.Scene.setRoot(Scene.java:1259)
        at javafx.scene.Scene.<init>(Scene.java:365)
        at javafx.scene.Scene.<init>(Scene.java:245)
        at ca.pigggott.sample.graal.App.start(App.java:40)
        at com.sun.javafx.application.LauncherImpl.lambda$launchApplication1$4(LauncherImpl.java:845)
        at com.sun.javafx.application.PlatformImpl.lambda$runAndWait$0(PlatformImpl.java:449)
        at com.sun.javafx.application.PlatformImpl.lambda$runLater$0(PlatformImpl.java:424)
        at com.sun.glass.ui.InvokeLaterDispatcher$Future.run(InvokeLaterDispatcher.java:95)
        at com.sun.glass.ui.win.WinApplication._runLoop(Native Method)
        at com.sun.glass.ui.win.WinApplication.lambda$runLoop$0(WinApplication.java:173)
        ... 4 more
Caused by: java.lang.NullPointerException
        at com.sun.javafx.font.PrismFontLoader.loadFont(PrismFontLoader.java:210)
        at javafx.scene.text.Font.<init>(Font.java:345)
        at javafx.scene.text.Font.getDefault(Font.java:109)
        at javafx.scene.CssStyleHelper.<clinit>(CssStyleHelper.java:1671)
        ... 24 more
```

## Linux

??