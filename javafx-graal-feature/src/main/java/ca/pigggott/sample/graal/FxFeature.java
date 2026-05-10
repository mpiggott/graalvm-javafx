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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.Feature.BeforeAnalysisAccess;
import org.graalvm.nativeimage.hosted.Feature.DuringSetupAccess;
import org.graalvm.nativeimage.hosted.RuntimeJNIAccess;
import org.graalvm.nativeimage.hosted.RuntimeResourceAccess;

import com.oracle.svm.core.jdk.NativeLibrarySupport;

import javafx.application.Application;

public class FxFeature implements Feature {

	@Override
	public void beforeAnalysis(BeforeAnalysisAccess access) {
		if (isWin()) {
			System.out.println("beforeAnalysis - win");
			registerLibraries(FxWin.LIBS);
			registerJni(access, FxWin.JNI);
		}
		else if (isMac()) {
			System.out.println("beforeAnalysis - mac");
			registerLibraries(FxMac.LIBS);
			registerJni(access, FxMac.JNI);
		}
		else {
			System.out.println("beforeAnalysis - other");
			registerLibraries(FxUnix.LIBS);
			registerJni(access, FxUnix.JNI);
		}
	}

	@Override
	public void duringSetup(DuringSetupAccess access) {
		if (isWin()) {
			FxWin.PREREG.forEach(NativeLibrarySupport.singleton()::preregisterUninitializedBuiltinLibrary);
		}
		else if (isMac()) {
			FxMac.PREREG.forEach(NativeLibrarySupport.singleton()::preregisterUninitializedBuiltinLibrary);
		} else {
			FxUnix.PREREG.forEach(NativeLibrarySupport.singleton()::preregisterUninitializedBuiltinLibrary);
		}

	}

	private static void registerJni(BeforeAnalysisAccess access, List<String> classes) {
		for (String className : classes) {
				Class<?> clazz = access.findClassByName(className);
				if (clazz != null) {
					RuntimeJNIAccess.register(clazz);
					RuntimeJNIAccess.register(clazz.getDeclaredConstructors());
					RuntimeJNIAccess.register(clazz.getDeclaredFields());
					RuntimeJNIAccess.register(clazz.getDeclaredMethods());
				}
		}
	}

	private static void registerLibraries(List<String> libraries) {
		Module module = Application.class.getModule();
		libraries.forEach(libraryName -> RuntimeResourceAccess.addResource(module, libraryName));
	}

	private static boolean isMac() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("mac");
	}

	private static boolean isWin() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("win");
	}
}
