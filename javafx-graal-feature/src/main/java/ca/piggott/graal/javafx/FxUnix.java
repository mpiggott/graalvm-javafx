/*
 * Copyright (C) 2026 Matthew Piggott
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package ca.piggott.graal.javafx;

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
			"com.sun.glass.ui.Screen",
			"com.sun.glass.ui.MenuBar",
			"com.sun.glass.ui.Menu",
			"com.sun.glass.ui.MenuItem",
			"com.sun.glass.ui.ClipboardAssistance",
			"com.sun.glass.ui.View$Capability",
			"com.sun.glass.ui.Cursor",
			"com.sun.glass.ui.Pixels",
			"com.sun.glass.ui.Size",
			"com.sun.glass.ui.Window$Level",
			"com.sun.glass.ui.Window$State",
			"com.sun.glass.ui.Window$EventHandler",
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
			"com.sun.glass.ui.gtk.GtkPlatformFactory",
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
			"com.sun.glass.ui.gtk.GtkScreen",
			"com.sun.glass.ui.gtk.GtkResourceFactory",
			"com.sun.glass.ui.CommonDialogs",
			"com.sun.glass.ui.CommonDialogs$FileChooserResult",
			"com.sun.glass.ui.CommonDialogs$DirectoryChooserResult",
			"com.sun.glass.ui.CommonDialogs$ExtensionFilter",
			"com.sun.glass.ui.CommonDialogs$Type",
			"com.sun.javafx.font.PrismFontFactory",
			"com.sun.javafx.font.PrismFontLoader",
			"com.sun.javafx.font.fontconfig.FCFontFactory",
			"com.sun.javafx.font.freetype.FTFactory",
			"com.sun.javafx.font.freetype.FT_Bitmap",
			"com.sun.javafx.font.freetype.FT_GlyphSlotRec",
			"com.sun.javafx.font.freetype.FT_Matrix",
			"com.sun.javafx.font.freetype.FT_Glyph_Metrics",
			"com.sun.javafx.font.freetype.OSFreetype",
			"com.sun.javafx.font.PGFont",
			"com.sun.javafx.font.LogicalFont",
			"com.sun.javafx.font.fontconfig.FontConfig",
			"com.sun.javafx.font.FontConfigManager",
			"com.sun.javafx.font.FontConfigManager$FcCompFont",
			"com.sun.javafx.font.FontConfigManager$FontConfigFont",
			"com.sun.javafx.font.freetype.FTFontFile",
			"com.sun.javafx.scene.text.TextFlowHelper",
			"com.sun.prism.es2.X11GLContext",
			"com.sun.prism.es2.X11GLDrawable",
			"com.sun.prism.es2.X11GLView",
			"com.sun.prism.es2.X11GLScreen",
			"javafx.scene.text.TextFlow"
	);

	static final List<String> PREREG = List.of("prism_sw", "prism_es2", "glassgtk3", "glass", "glass_monocle", "javafx_font", "javafx_font_freetype", "javafx_font_pango", "javafx_iio");
}
