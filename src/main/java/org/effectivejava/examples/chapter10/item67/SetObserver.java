// Set obeserver callback interface - Page 266
package org.effectivejava.examples.chapter10.item67;

// Set 的回调接口(当元素添加到被观察的集合 ObservableSet 后的回调动作)
public interface SetObserver<E> {
	// Invoked when an element is added to the observable set
	void added(ObservableSet<E> set, E element);
}
