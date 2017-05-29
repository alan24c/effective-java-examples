// Generic static factory method - Pages 130-131
package org.effectivejava.examples.chapter05.item27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericStaticFactory {
	// Generic static factory method
	/*
	   范型方法的定义
	   注意：与范型接口: List<E> 或 UnaryFunction<T> 的区别
	 */
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	public static void main(String[] args) {
		// Parameterized type instance creation with static factory
		Map<String, List<String>> anagrams = newHashMap();
	}
}
