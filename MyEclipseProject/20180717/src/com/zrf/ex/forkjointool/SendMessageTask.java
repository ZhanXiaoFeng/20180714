package com.zrf.ex.forkjointool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/*
 * ForkJoinTool���ӳص�ʹ��
 * ������ʹ�ø�ָ���û����Ͷ���
 */
public class SendMessageTask extends RecursiveAction {
	private static final long serialVersionUID = -4499017958128251212L;
	// ÿ��"С����"ֻ���ֻ��10���û����Ͷ���
	private static final int THRESHOLD = 10;
	private int start;
	private int end;
	List<String> list = null;

	// ��start��end������
	public SendMessageTask(int start, int end, List<String> list) {
		this.start = start;
		this.end = end;
		this.list = list;
	}

	@Override
	protected void compute() {
		if (end - start < THRESHOLD) {
			String mobileno = "";
			for (int i = start; i < end; i++) {
				// �˴����ֻ������ۼӣ����ڷ��͸�������Ӫ��
				mobileno += list.get(i) + ",";
			}
			System.out.println("���ֻ�����==" + mobileno + "���û������ֻ�����");
		} else {
			// �����end��start֮��Ĳ����THRESHOLDʱ����Ҫ���͵�������10��
			// ��������ֽ������С����
			int middle = (start + end) / 2;
			SendMessageTask left = new SendMessageTask(start, middle, list);
			SendMessageTask right = new SendMessageTask(middle, end, list);
			// ����ִ��������С����
			left.fork();
			right.fork();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= 380; i++) {
			list.add("i------" + i);// ����˴�Ϊ�ֻ�����--��Ŀ�д����ݿ��л�ȡ
		}
		ForkJoinPool pool = new ForkJoinPool();
		// �ύ�ɷֽ��PrintTask����
		pool.submit(new SendMessageTask(0, list.size(), list));
		// �߳��������ȴ������������
		pool.awaitTermination(10, TimeUnit.SECONDS);
		// �ر��̳߳�
		pool.shutdown();
	}
}
