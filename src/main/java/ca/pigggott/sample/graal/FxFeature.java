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
		}
	}

	@Override
	public void duringSetup(DuringSetupAccess access) {
		if (isWin()) {

		}
		else if (isMac()) {
			List.of("glass", "javafx_font", "javafx_iio", "prism_es2")
					.forEach(NativeLibrarySupport.singleton()::preregisterUninitializedBuiltinLibrary);
		} else {
			NativeLibrarySupport.singleton().preregisterUninitializedBuiltinLibrary("prism_sw");
			NativeLibrarySupport.singleton().preregisterUninitializedBuiltinLibrary("prism_es2");
			NativeLibrarySupport.singleton().preregisterUninitializedBuiltinLibrary("glassgtk3");
			NativeLibrarySupport.singleton().preregisterUninitializedBuiltinLibrary("glass");
			NativeLibrarySupport.singleton().preregisterUninitializedBuiltinLibrary("glass_monocle");
		}

	}

	private static void registerJni(BeforeAnalysisAccess access, List<String> classes) {
		for (String className : classes) {
				Class<?> clazz = access.findClassByName(className);
				if (clazz != null) {
					RuntimeJNIAccess.register(clazz);
					RuntimeJNIAccess.register(clazz.getDeclaredConstructors());
					RuntimeJNIAccess.register(clazz.getDeclaredFields());
					for (Method method : clazz.getDeclaredMethods()) {
						if (Modifier.isNative(method.getModifiers())) {
							RuntimeJNIAccess.register(method);
						}
					}
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
