// Unary function - page 131
package org.effectivejava.examples.chapter05.item27;

/*
	普通范型的接口定义
	非范型方法的定义

	eg：类似与 List<E> --> 范型类的定义
 */
public interface UnaryFunction<T> {
	T apply(T arg);
}
