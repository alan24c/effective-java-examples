// Generic singleton factory method - Pages 131-132
package org.effectivejava.examples.chapter05.item27;

public class GenericSingletonFactory {
	// Generic singleton factory pattern
	/*
	    范型单例工厂
	    使用 Object 实例化 T, 范型信息(具体的子类信息)被擦除,无状态了(变成基类 Object 了)
	    不可变(范型信息被擦除成了 Objec)同时又适用很多类型的对象(只有 Object 类了)
	 */
	private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};

	// IDENTITY_FUNCTION is stateless and its type parameter is
	// unbounded so it's safe to share one instance across all types.
	/*
		IDENTITY_FUNCTION 被向上转为 interface UnaryFunction<T>

		这与 List<Long> 与 List<Interge> 不能相互强制转换不矛盾,这两个是从 List<E> 接口的不同实现类,这里是向上转化为基类
	 */
	@SuppressWarnings("unchecked")
	public static <T> UnaryFunction<T> identityFunction() {
		return (UnaryFunction<T>) IDENTITY_FUNCTION;
	}

	// Sample program to exercise generic singleton
	public static void main(String[] args) {
		String[] strings = { "jute", "hemp", "nylon" };
		UnaryFunction<String> sameString = identityFunction();
		for (String s : strings)
			System.out.println(sameString.apply(s));

		Number[] numbers = { 1, 2.0, 3L };
		UnaryFunction<Number> sameNumber = identityFunction();
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));
	}
}