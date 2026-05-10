/*
 * MIT License
 *
 * Copyright (c) 2026 Matthew Piggott

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
