package com.zrf.ex.nozzle;

/*
 * ����PersonConsts()�ӿ�
 */
public interface PersonConsts {
	int NUMBER = 2;// ����һ������
	// �ȼ���public static final int NUMBER=2;

	String add(String contents);
	// �ȼ���public abstract String add(String contents);

	/*
	 * java8+ �³��ֵ�Ĭ�Ϸ���
	 */
	default String say(String contents) {
		return contents;
	}
}
