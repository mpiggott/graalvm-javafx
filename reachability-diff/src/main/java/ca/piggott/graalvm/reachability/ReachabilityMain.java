package ca.piggott.graalvm.reachability;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReachabilityMain {

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("Provide both file paths to compare");
			System.exit(-1);
		}

		ReachabilityMetadata a = read(args[0]);
		ReachabilityMetadata b = read(args[1]);

		if (a.equals(b)) {
			System.out.println("They match!");
			System.exit(0);
		}

		if (!a.reflection.equals(b.reflection)) {
			compareReflections(a, b);
		}
		if (!a.resources.equals(b.resources)) {
			compareResources(a, b);
		}
	}

	private static void compareReflections(ReachabilityMetadata reachabilityA, ReachabilityMetadata reachabilityB) {
		System.out.println("Comparing reflections");
		Map<String, Reflection> a = reachabilityA.getReflectionByType();
		Map<String, Reflection> b = reachabilityB.getReflectionByType();

		a.values().stream()
				.filter(reflection -> b.containsKey(reflection.type))
				.filter(reflection -> !reflection.equals(b.get(reflection.type)))
				.forEach(reflection -> System.out.println("\tDifferent: " + reflection.type));
		a.keySet().stream()
				.filter(type -> !b.containsKey(type))
				.forEach(type -> System.out.println("\tMissing from B: " + type));

		String json = b.values().stream()
				.filter(reflection -> !a.containsKey(reflection.type))
				.sorted(Comparator.comparing(Reflection::type))
				.map(GSON::toJson)
				.map(str -> str.replace("\n", "\n    "))
				.collect(Collectors.joining(",\r\n    ", "    ", ","));
		if (json.length() > 0) {
			System.out.println("Missing from A: \n" + json);
		}
	}

	private static void compareResources(ReachabilityMetadata a, ReachabilityMetadata b) {
		System.out.println("Comparing resources");

	}

	private static ReachabilityMetadata read(String path) throws IOException {
		try (Reader reader = Files.newBufferedReader(Paths.get(path))) {
			return GSON.fromJson(reader, ReachabilityMetadata.class);
		}
	}

	private static record ReachabilityMetadata(List<Reflection> reflection, List<Map<String, String>> resources) {

		Map<String, Reflection> getReflectionByType() {
			return reflection.stream().collect(Collectors.toMap(Reflection::type, Function.identity()));
		}
	}

	private static record Reflection(String type, boolean jniAccessible, List<Map<String, Object>> fields, List<Map<String, Object>> methods) {
	}
}
