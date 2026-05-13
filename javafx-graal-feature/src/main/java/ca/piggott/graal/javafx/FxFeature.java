/*
 * Copyright (C) 2026 Matthew Piggott
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package ca.piggott.graal.javafx;

import java.util.List;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.Feature.BeforeAnalysisAccess;
import org.graalvm.nativeimage.hosted.Feature.DuringSetupAccess;
import org.graalvm.nativeimage.hosted.RuntimeResourceAccess;

import com.oracle.svm.core.jdk.NativeLibrarySupport;

import ca.piggott.graal.support.FeatureSupport;
import javafx.application.Application;

public class FxFeature
		extends FeatureSupport
		implements Feature
{
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
	private static void registerLibraries(List<String> libraries) {
		Module module = Application.class.getModule();
		libraries.forEach(libraryName -> RuntimeResourceAccess.addResource(module, libraryName));
	}
}
