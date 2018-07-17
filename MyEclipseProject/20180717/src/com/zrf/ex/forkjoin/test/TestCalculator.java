package com.zrf.ex.forkjoin.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.junit.Test;

import com.zrf.ex.forkjoin.Calculator;

public class TestCalculator {
	@Test
	public void test() {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTask<Integer> result = forkJoinPool.submit(new Calculator(0, 100000000));
		// ֱ������������������
		while (!result.isDone()) {
		}

		try {
			System.out.println(result.get());
			// catch (InterruptedException | ExecutionException e) ͬʱ�����쳣
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

}
