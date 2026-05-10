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

final class FxUnix {
	static final List<String> LIBS = List.of(
			"libprism_common.so",
			"libjavafx_font.so",
			"libprism_es2.so",
			"libglass.so",
			"libjavafx_iio.so",
			"libglassgtk3.so",
			"libdecora_sse.so",
			"libjavafx_font_freetype.so",
			"libprism_sw.so",
			"libjavafx_font_pango.so");

	static final List<String> JNI = List.of(
			"com.sun.prism.es2.X11GLFactory",
			"com.sun.prism.es2.ES2Pipeline",
			"com.sun.prism.es2.ES2Context",
			"com.sun.glass.ui.gtk.GtkApplication",
			"com.sun.glass.ui.gtk.GtkWindow",
			"com.sun.glass.ui.gtk.GtkView",
			"com.sun.glass.ui.gtk.GtkCursor",
			"com.sun.glass.ui.gtk.GtkPixels",
			"com.sun.glass.ui.gtk.GtkTimer",
			"com.sun.glass.ui.gtk.GtkMenuBarDelegate",
			"com.sun.glass.ui.gtk.GtkMenuDelegate",
			"com.sun.glass.ui.gtk.GtkPlatformFactory",
			"com.sun.glass.ui.gtk.GtkCommonDialogs",
			"com.sun.glass.ui.gtk.GtkPasteboard",
			"com.sun.glass.ui.gtk.GtkAccessible",
			"com.sun.glass.ui.gtk.GtkClipboard"
	);

	static final List<String> PREREG = List.of("prism_sw", "prism_es2", "glassgtk3", "glass", "glass_monocle");;
}
