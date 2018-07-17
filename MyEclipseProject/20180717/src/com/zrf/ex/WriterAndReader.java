package com.zrf.ex;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WriterAndReader {
	// ���̷߳���
	// ע�⣺��Ԫ����ֻ�ܳ������޴�ֵ��Ӧʹ��main()����
	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
		Random random = new Random();
		// ����д�߳�
		new Thread(() -> {
			while (true) {
				int i = random.nextInt(101);
				try {
					bq.put(i);
					System.out.println("����ֵ��" + i);
					Thread.sleep(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		// �������߳�
		new Thread(() -> {
			while (true) {
				try {
					int i = bq.take();
					System.out.println("ȡ��ֵ��" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}