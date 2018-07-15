package com.zrf.ex.javabase.test;

import org.junit.Test;
import com.zrf.ex.javabase.UseMyFunction;
import com.zrf.ex.javabase.UseSayable;

public class TestUseMyFunction {
	@Test
	public void test1() {
		UseMyFunction umf = new UseMyFunction();
		umf.go((str) -> {
			System.out.println(str);
		}, "С��С��С��");
	}

	@Test
	public void testSayable() {
		UseSayable us = new UseSayable();
		us.go((s) -> System.out.println(s));
		System.out.println("*************************");
		us.go(System.out::println);
		/*
		 * ��Ϊgo����Ҫ��ʹ��һ������ʽ�ӿڣ��������Ϊ��Ҫ��ִ��һ����������������������봫�ݽ���һ��String ����
		 * System.out::printlnʹ��һ�������println�������ҵķ���Ҳ��ֻ��һ��������String���͵�
		 */
	}

	@Test
	public void testCalculatable() {
		/*
		 * Calculator calculator=new Calculator(); Calculatable cal=(int i)->{
		 * return calculator.sum(i); };
		 * 
		 * UseCal uc=new UseCal(); System.out.println(uc.getResult(cal, 10));
		 */

		UseCal uc = new UseCal();
		Calculator cal = new Calculator();
		long l = uc.getResult(cal::sum, 10);
		System.out.println(l);
		System.out.println("********************");
		System.out.println(uc.getResult(Calculator::addHundred, 9));
	}
}

class UseCal {
	public long getResult(Calculatable c, int i) {
		return c.cal(i);
	}
}

interface Calculatable {
	long cal(int i);
}

class Calculator {
	public long sum(int end) {
		long result = 0;

		for (int i = 1; i <= end; i++) {
			result += i;
		}
		return result;
	}

	// ʹ�õݹ麯������׳�
	public long multiply(int end) {
		long result = 1;
		if (end == 1) {
			result = 1;
		} else {
			result = end * multiply(end - 1);
		}
		return result;
	}

	public static long addHundred(int i) {
		return i + 100;
	}
}