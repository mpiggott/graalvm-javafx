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
			"com.sun.glass.ui.Application",
			"com.sun.glass.ui.View",
			"com.sun.glass.ui.Window",
			"com.sun.glass.ui.Cursor",
			"com.sun.glass.ui.Pixels",
			"com.sun.glass.ui.Timer",
			"com.sun.glass.ui.Screen",
			"com.sun.glass.ui.MenuBar",
			"com.sun.glass.ui.Menu",
			"com.sun.glass.ui.MenuItem",
			"com.sun.glass.ui.CommonDialogs",
			"com.sun.glass.ui.Clipboard",
			"com.sun.glass.ui.ClipboardAssistance",
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
			"com.sun.prism.GraphicsPipeline",
			"com.sun.prism.es2.X11GLFactory",
			"com.sun.prism.es2.ES2Pipeline",
			"com.sun.prism.es2.ES2Context",
			"com.sun.prism.es2.GLFactory",
			"com.sun.glass.ui.gtk.GtkApplication",
			"com.sun.glass.ui.gtk.GtkWindow",
			"com.sun.glass.ui.gtk.GtkView",
			"com.sun.glass.ui.gtk.GtkCursor",
			"com.sun.glass.ui.gtk.GtkPixels",
			"com.sun.glass.ui.gtk.GtkTimer",
			"com.sun.glass.ui.gtk.GtkMenuBarDelegate",
			"com.sun.glass.ui.gtk.GtkMenuDelegate",
			"com.sun.glass.ui.gtk.GtkCommonDialogs",
			"com.sun.glass.ui.gtk.GtkPasteboard",
			"com.sun.glass.ui.gtk.GtkAccessible",
			"com.sun.glass.ui.gtk.GtkClipboard",
			"com.sun.javafx.font.PrismFontFactory",
			"com.sun.javafx.font.PrismFontLoader",
			"com.sun.javafx.font.fontconfig.FCFontFactory",
			"com.sun.javafx.font.freetype.FTFactory",
			"com.sun.javafx.font.freetype.FT_Bitmap",
			"com.sun.javafx.font.freetype.FT_FaceRec",
			"com.sun.javafx.font.freetype.FT_GlyphSlotRec",
			"com.sun.javafx.font.freetype.FT_Size_Metrics",
			"com.sun.javafx.font.freetype.FT_SizeRec",
			"com.sun.javafx.font.freetype.FT_Vector",
			"com.sun.javafx.font.freetype.OSFreetype",
			"com.sun.javafx.font.PGFont",
			"com.sun.javafx.font.LogicalFont",
			"com.sun.javafx.font.fontconfig.FontConfig",
			"com.sun.javafx.font.FontConfigManager",
			"com.sun.javafx.font.FontConfigManager$FcCompFont",
			"com.sun.javafx.font.freetype.FTFontFile",
			"com.sun.prism.es2.X11GLContext"
	);

	static final List<String> PREREG = List.of("prism_sw", "prism_es2", "glassgtk3", "glass", "glass_monocle", "javafx_font", "javafx_font_freetype", "javafx_font_pango", "javafx_iio");;
}
