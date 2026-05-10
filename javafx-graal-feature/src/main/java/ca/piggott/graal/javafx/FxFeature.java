/*
 * Copyright (C) 2026 Matthew Piggott
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package ca.piggott.graal.javafx;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.Feature.BeforeAnalysisAccess;
import org.graalvm.nativeimage.hosted.Feature.DuringSetupAccess;
import org.graalvm.nativeimage.hosted.RuntimeJNIAccess;
import org.graalvm.nativeimage.hosted.RuntimeReflection;
import org.graalvm.nativeimage.hosted.RuntimeResourceAccess;

import com.oracle.svm.core.jdk.NativeLibrarySupport;

import javafx.application.Application;

public class FxFeature implements Feature {

	@Override
	public void beforeAnalysis(BeforeAnalysisAccess access) {
		if (isWin()) {
			registerLibraries(FxWin.LIBS);
			registerAccess(access, FxWin.JNI);
		}
		else if (isMac()) {
			registerLibraries(FxMac.LIBS);
			registerAccess(access, FxMac.JNI);
		}
		else {
			registerLibraries(FxUnix.LIBS);
			registerAccess(access, FxUnix.JNI);
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

	private static void registerAccess(BeforeAnalysisAccess access, List<String> classes) {
		Set<Class<?>> visited = new HashSet<>();
		for (String className : classes) {
			Class<?> clazz = access.findClassByName(className);
			if (clazz != null) {
				registerHierarchy(clazz, visited);
			}
		}
	}

	private static void registerHierarchy(Class<?> clazz, Set<Class<?>> visited) {
		if (clazz == null || clazz == Object.class || !visited.add(clazz)) {
			return;
		}

		RuntimeJNIAccess.register(clazz);
		RuntimeJNIAccess.register(clazz.getDeclaredConstructors());
		RuntimeJNIAccess.register(clazz.getDeclaredFields());
		RuntimeJNIAccess.register(clazz.getDeclaredMethods());
		RuntimeReflection.register(clazz);
		RuntimeReflection.register(clazz.getDeclaredConstructors());
		RuntimeReflection.register(clazz.getDeclaredFields());
		RuntimeReflection.register(clazz.getDeclaredMethods());

		registerHierarchy(clazz.getSuperclass(), visited);
		for (Class<?> intf : clazz.getInterfaces()) {
			registerHierarchy(intf, visited);
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
