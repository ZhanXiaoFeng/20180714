package com.zrf.ex.javabase;

/*
 * ʹ��function�ӿ�
 */
@FunctionalInterface
public interface MyFunction {
	void say(String s);

	// public abstract void say(String s);
	default public void eat(String food) {
		System.out.println("�ԳԳ�" + food);
	}
}