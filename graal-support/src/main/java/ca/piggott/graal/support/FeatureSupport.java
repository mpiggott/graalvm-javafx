/*
 * Copyright (C) 2026 Matthew Piggott
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package ca.piggott.graal.support;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.graalvm.nativeimage.hosted.Feature.BeforeAnalysisAccess;
import org.graalvm.nativeimage.hosted.RuntimeJNIAccess;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

public abstract class FeatureSupport {

	protected static void registerAccess(BeforeAnalysisAccess access, List<String> classes) {
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

	protected static boolean isMac() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("mac");
	}

	protected static boolean isWin() {
		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("win");
	}
}
