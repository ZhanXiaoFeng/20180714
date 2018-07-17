package com.zrf.ex.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Calculator extends RecursiveTask<Integer> {
	/**
	 * �ݹ�����ִ�У���ͣ�ķָ�����
	 */
	private static final long serialVersionUID = 1L;
	private static final int cont = 100;
	private int start;
	private int end;

	public Calculator(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Calculator [start=" + start + ", end=" + end + "]";
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if ((start - end) < cont) {
			for (int i = start; i < end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			Calculator left = new Calculator(start, middle);
			Calculator right = new Calculator(middle + 1, end);
			// .fork()�ڵ�ǰ�����������еĳ����첽ִ�д�����
			left.fork();
			right.fork();
			// .join()��������ɺ�(isDone()��������ture)���ؼ�����
			sum = left.join() + right.join();
		}
		return sum;
	}

}
