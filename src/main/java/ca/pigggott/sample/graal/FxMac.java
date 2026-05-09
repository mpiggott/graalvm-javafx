package ca.pigggott.sample.graal;

import java.util.List;

final class FxMac {

	static final List<String> LIBS = List.of(
			"libdecora_sse.dylib",
			"libglass.dylib",
			"libjavafx_font.dylib",
			"libjavafx_iio.dylib",
			"libprism_common.dylib",
			"libprism_es2.dylib",
			"libprism_mtl.dylib",
			"libprism_sw.dylib");

	static final List<String> JNI = List.of(
			"com.sun.prism.es2.MacGLFactory",
			"com.sun.prism.es2.ES2Pipeline",
			"com.sun.prism.es2.ES2Context",
			"com.sun.prism.mtl.MTLPipeline",
			"com.sun.prism.mtl.MTLContext",
			"com.sun.glass.ui.mac.MacApplication",
			"com.sun.glass.ui.mac.MacWindow",
			"com.sun.glass.ui.mac.MacView",
			"com.sun.glass.ui.mac.MacCursor",
			"com.sun.glass.ui.mac.MacPixels",
			"com.sun.glass.ui.mac.MacTimer",
			"com.sun.glass.ui.mac.MacMenuBarDelegate",
			"com.sun.glass.ui.mac.MacMenuDelegate",
			"com.sun.glass.ui.mac.MacCommonDialogs",
			"com.sun.glass.ui.mac.MacPasteboard",
			"com.sun.glass.ui.mac.MacAccessible",
			"com.sun.glass.ui.mac.MacClipboard"
	);

}
