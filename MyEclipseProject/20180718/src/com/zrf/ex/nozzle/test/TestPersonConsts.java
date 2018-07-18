package com.zrf.ex.nozzle.test;

import org.junit.Test;
import com.zrf.ex.nozzle.PersonConsts;
//��̬�����
import static java.lang.System.*;
import static com.zrf.ex.nozzle.PersonConsts.*;

public class TestPersonConsts {
	// ʹ�õ�Ԫ����
	@Test
	public void test() {
		// �������ֵǰ�����abc,
		PersonConsts pc = new PersonConsts() {
			@Override
			public String add(String contents) {
				return "abc," + contents;
			}
		};
		String add = pc.add("hello");
		out.println(add);// ��̬������ľ���ʹ��(������дSystem)

		// �ȼ���ǰ�������
		PersonConsts pc1 = s -> "abc," + s;
		out.println(pc1.add("hello"));

		// ���þ�̬����
		System.out.println(PersonConsts.NUMBER);
		// ��̬�����֮���ֱ��ʹ��NUMBER����
		System.out.println(NUMBER);
	}

	// ʹ��main()��������
	public static void main(String[] args) {
		// ��Hello֮ǰ����abc,
		PersonConsts pc = s -> "abc," + s;
		String add = pc.add("Hello");
		System.out.println(add);

		// ���þ�̬����
		System.out.println(PersonConsts.NUMBER);
		// ��̬�����֮���ֱ��ʹ��NUMBER����
		System.out.println(NUMBER);

		// ����Ĭ�Ϸ���
		String say = pc.say("Hello,XiaoNa!");
		System.out.println(say);
	}

	@Test
	public void test1() {
		// ���þ�̬����
		System.out.println(PersonConsts.NUMBER);
		// ��̬�����֮���ֱ��ʹ��NUMBER����
		out.println(NUMBER);
	}
}
