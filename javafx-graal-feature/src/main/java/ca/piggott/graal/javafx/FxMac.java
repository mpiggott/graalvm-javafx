/*/*
 * Copyright (C) 2026 Matthew Piggott
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package ca.piggott.graal.javafx;

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

	static final List<String> PREREG = List.of("glass", "javafx_font", "javafx_iio", "prism_es2");

	static final List<String> JNI = List.of(
			"com.sun.glass.ui.Screen",
			"com.sun.glass.ui.MenuBar",
			"com.sun.glass.ui.Menu",
			"com.sun.glass.ui.MenuItem",
			"com.sun.glass.ui.ClipboardAssistance",
			"com.sun.glass.ui.View$Capability",
			"com.sun.glass.ui.Size",
			"com.sun.glass.events.KeyEvent",
			"com.sun.glass.events.MouseEvent",
			"com.sun.glass.events.WindowEvent",
			"com.sun.glass.events.TouchEvent",
			"com.sun.glass.events.SwipeGestureEvent",
			"com.sun.glass.events.ScrollGestureEvent",
			"com.sun.glass.events.PanGestureEvent",
			"com.sun.glass.events.RotateGestureEvent",
			"com.sun.glass.events.ZoomGestureEvent",
			"com.sun.javafx.tk.quantum.QuantumToolkit",
			"com.sun.glass.ui.mac.MacPlatformFactory",
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
			"com.sun.glass.ui.mac.MacClipboard",
			"com.sun.javafx.font.PrismFontFactory",
			"com.sun.javafx.font.PrismFontLoader",
			"com.sun.javafx.font.coretext.CTFactory",
			"com.sun.javafx.font.coretext.OSCoreText",
			"com.sun.javafx.font.PGFont",
			"com.sun.javafx.font.LogicalFont",
			"com.sun.javafx.font.coretext.CTFontFile"
	);
}
