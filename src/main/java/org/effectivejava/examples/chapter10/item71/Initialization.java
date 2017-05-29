// Initialization styles - Pages 282-284
package org.effectivejava.examples.chapter10.item71;

public class Initialization {

	// Normal initialization of an instance field - Page 282

	/*
		JMM 保证 final 变量被外部引用时,已经被正确初始化了
	*/
	private final FieldType field1 = computeFieldValue();

	// Lazy initialization of instance field - synchronized accessor - Page 282

	 /*
		没有 final 值修饰的变量的初始化需要额外的同步
	 */
	private FieldType field2;

	synchronized FieldType getField2() {
		if (field2 == null)
			field2 = computeFieldValue();
		return field2;
	}

	// Lazy initialization holder class idiom for static fields - Page 283
	private static class FieldHolder {
		static final FieldType field = computeFieldValue();
	}

	// 静态方法获取一个实例,JVM 保证多线程 Class (FieldHolder) 的初始化,只会被一个线程初始化
	static FieldType getField3() {
		return FieldHolder.field;
	}

	// Double-check idiom for lazy initialization of instance fields - Page 283

	/*
		volatile 修饰符保证可见性
		同步代码块减小
		添加中间变量 result,可能只读取了一次 volatile 变量,稍微提升了性能
	*/
	private volatile FieldType field4;

	FieldType getField4() {
		FieldType result = field4;
		if (result == null) { // First check (no locking)
			synchronized (this) {
				result = field4;
				if (result == null) // Second check (with locking)
					field4 = result = computeFieldValue();
			}
		}
		return result;
	}

	// Single-check idiom - can cause repeated initialization! - Page 284
	private volatile FieldType field5;

	private FieldType getField5() {
		FieldType result = field5;
		if (result == null)
			field5 = result = computeFieldValue();
		return result;
	}

	private static FieldType computeFieldValue() {
		return new FieldType();
	}
}

class FieldType {
}
