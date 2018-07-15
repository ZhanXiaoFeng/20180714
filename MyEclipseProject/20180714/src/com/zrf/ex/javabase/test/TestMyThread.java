package com.zrf.ex.javabase.test;

import org.junit.Test;

import com.zrf.ex.javabase.MyThread;

public class TestMyThread {
	@Test
	public void testClassThread() {
		Thread thread = new Thread(new MyThread());
		/*
		 * ��̬������ͨ������ֱ�ӵ��ã�Ҳ����ͨ��ʵ��ֱ�ӵ��ã�����ִ�н����ȫһ��
		 * ��̬�������ڴ����ȫ����������һ����Щ���������ڴ�󣬱���ʱ��Ƚϳ�
		 */
		try {
			thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.start();
	}

	@Test
	public void TestThread2() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println("i=" + i);
				}
			}
		});
		thread.start();
	}

	@Test
	public void testThread3() {
		Runnable run = () -> System.out.println("hehe");
		new Thread(run).start();
	}
}
