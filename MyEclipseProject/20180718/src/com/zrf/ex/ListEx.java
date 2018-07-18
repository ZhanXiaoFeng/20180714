
/**
* @Title: ListEx.java
* @Package com.zrf.ex
* @Description:  list�����鼰�Ƚ�����ʹ��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

/**
 * @ClassName: ListEx
 * @Description: list�����鼰�Ƚ�����ʹ��
 * @author ZRF
 * @date 2018��7��18��
 */

public class ListEx {
	@Test
	public void testList() {
		// ������ʵ�֣�ArrayList,Vector,CopyOnWriteArrayList,Stack
		/*
		 * ���ʵ����Iterable for(String str:..){...} StringBufferͬ���Ŀɱ��ַ���
		 * StringBuilder�̲߳���ȫ�Ŀɱ��ַ���
		 */
		List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
		/*************** �汾һ *****************/
		/*
		 * Iterator<String> iterator = list.iterator(); while
		 * (iterator.hasNext()) { String string = (String) iterator.next();
		 * System.out.println(string); }
		 */
		/*************** �汾�� *****************/
		for (String str : list) {
			System.out.println(str);
		}
	}

	public void synchronizedMeth() {
		// ������
		synchronized (this) {
			System.out.println("aaaaa");
		}
		;
	}

	@Test
	public void testArrayList() {
		// ���ó�ʼ����Ϊ10
		ArrayList<String> list = new ArrayList<>(10);
		list.add("bb");
		list.add("cc");
		list.add("aa");
		list.add("dd");
		list.add("ff");
		list.add("gg");
		list.add("ee");
		list.add("h");
		list.add("j");
		list.add("a");
		list.add("ii");
		// һ�����ַ�ʽ����ȼ�
		// list.forEach((s) -> System.out.println(s));
		list.forEach(System.out::println);
		System.out.println("-----------------------------------");
		list.remove(10);// ɾ���±�Ϊ10��Ԫ��
		// ����String���е�equals��hashCode() ����true����ɾ��
		list.remove("gg");// ɾ��ָ���Ķ���
		list.forEach(System.out::println);

		// Comparator�������Ƚ���
		System.out.println("-----------------------------------");
		// ���ֵ�˳������
		list.sort((s1, s2) -> s1.compareTo(s2));
		list.forEach(System.out::println);

		// �Ȱ��ַ����ȱȽ��ٰ��ֵ�˳������
		System.out.println("-----------------------------------");
		list.sort(Comparator.comparing(s -> s.toString().length())
				.thenComparing((s1, s2) -> s1.toString().compareTo(s2.toString())));
		list.forEach(System.out::println);

		// �Ȱ��ַ����ȱȽ��ٰ��ֵ�˳������ ˳��ת
		System.out.println("-----------------------------------");
		list.sort(Comparator.comparing(s -> s.toString().length())
				.thenComparing((s1, s2) -> s1.toString().compareTo(s2.toString())).reversed());
		list.forEach(System.out::println);
	}
}
