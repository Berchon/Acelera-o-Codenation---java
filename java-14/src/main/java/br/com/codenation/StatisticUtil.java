package br.com.codenation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int)Arrays.stream(elements).average().getAsDouble();
	}

	public static int mode(int[] elements) {

		return Arrays
				.stream(elements)
				.boxed()
				.collect(
						Collectors.groupingBy(
							Function.identity(),
							Collectors.counting()
						)
				)
				.entrySet()
				.stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.get()
				.getKey()
				.intValue();
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int tamanho = elements.length;
		return (int) (
			(
				elements[(int) Math.floor(tamanho / 2.0 + 0.2)]
				+ elements[(int) Math.floor(tamanho / 2.0 - 0.2)]
			) / 2.0
		);
	}
}