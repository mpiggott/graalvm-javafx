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

final class FxWin {

	static final List<String> JNI = List.of("com.sun.prism.d3d.D3DPipeline", "com.sun.prism.d3d.D3DContext", "com.sun.prism.sw.SWPipeline");

	static final List<String> PREREG = List.of("prism_sw", "glass", "glass_monocle", "javafx_font", "javafx_iio");

	static final List<String> LIBS = List.of("api-ms-win-core-console-l1-1-0.dll",
			"api-ms-win-core-console-l1-2-0.dll", "api-ms-win-core-datetime-l1-1-0.dll",
			"api-ms-win-core-debug-l1-1-0.dll", "api-ms-win-core-errorhandling-l1-1-0.dll",
			"api-ms-win-core-file-l1-1-0.dll", "api-ms-win-core-file-l1-2-0.dll", "api-ms-win-core-file-l2-1-0.dll",
			"api-ms-win-core-handle-l1-1-0.dll", "api-ms-win-core-heap-l1-1-0.dll",
			"api-ms-win-core-interlocked-l1-1-0.dll", "api-ms-win-core-libraryloader-l1-1-0.dll",
			"api-ms-win-core-localization-l1-2-0.dll", "api-ms-win-core-memory-l1-1-0.dll",
			"api-ms-win-core-namedpipe-l1-1-0.dll", "api-ms-win-core-processenvironment-l1-1-0.dll",
			"api-ms-win-core-processthreads-l1-1-0.dll", "api-ms-win-core-processthreads-l1-1-1.dll",
			"api-ms-win-core-profile-l1-1-0.dll", "api-ms-win-core-rtlsupport-l1-1-0.dll",
			"api-ms-win-core-string-l1-1-0.dll", "api-ms-win-core-synch-l1-1-0.dll", "api-ms-win-core-synch-l1-2-0.dll",
			"api-ms-win-core-sysinfo-l1-1-0.dll", "api-ms-win-core-timezone-l1-1-0.dll",
			"api-ms-win-core-util-l1-1-0.dll", "api-ms-win-crt-conio-l1-1-0.dll", "api-ms-win-crt-convert-l1-1-0.dll",
			"api-ms-win-crt-environment-l1-1-0.dll", "api-ms-win-crt-filesystem-l1-1-0.dll",
			"api-ms-win-crt-heap-l1-1-0.dll", "api-ms-win-crt-locale-l1-1-0.dll", "api-ms-win-crt-math-l1-1-0.dll",
			"api-ms-win-crt-multibyte-l1-1-0.dll", "api-ms-win-crt-private-l1-1-0.dll",
			"api-ms-win-crt-process-l1-1-0.dll", "api-ms-win-crt-runtime-l1-1-0.dll", "api-ms-win-crt-stdio-l1-1-0.dll",
			"api-ms-win-crt-string-l1-1-0.dll", "api-ms-win-crt-time-l1-1-0.dll", "api-ms-win-crt-utility-l1-1-0.dll",
			"decora_sse.dll", "glass.dll", "javafx_font.dll", "javafx_iio.dll", "msvcp140_1.dll", "msvcp140_2.dll",
			"msvcp140.dll", "prism_common.dll", "prism_d3d.dll", "prism_sw.dll", "ucrtbase.dll", "vcruntime140_1.dll",
			"vcruntime140.dll");

}
