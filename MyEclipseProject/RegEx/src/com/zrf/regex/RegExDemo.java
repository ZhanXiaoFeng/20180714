package com.zrf.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExDemo {
	/*
	 * �����ַ���ƥ��
	 */
	@Test
	public void testReg() {
		String str = "abc";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher("a.c");
		System.out.println(matcher.matches() ? "ƥ��ɹ�" : "ƥ��ʧ��");
	}

	/*
	 * �����ַ�������
	 */
	@Test
	public void testFind() {
		Pattern pattern = Pattern.compile("a.c");// ƥ����
		String str = "I am abc,abc is the English words!";// ��������
		Matcher matcher = pattern.matcher(str);
		int index = 0;// ��������λ��
		while (index < str.length() && matcher.find(index)) {
			int iStart = matcher.start();// matcher��ʼλ��
			int iStop = matcher.end();// matcher����λ��
			System.out.println(iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop));// ���ƥ�䵽��λ�ü�������
			index = iStop + 1;
		}
	}

	/*
	 * ��������
	 */
	@Test
	public void testSpecialChar() {
		String str = "phone:12345678912";
		// ̰��ƥ��
		// Pattern pattern = Pattern.compile("(\\d)+");// ƥ����
		Pattern pattern = Pattern.compile("(\\d){1,}");// ƥ����
		// Pattern pattern = Pattern.compile("(\\d){3}");//ÿ��ƥ��3��
		Matcher matcher = pattern.matcher(str);
		int index = 0;// ��������λ��
		while (index < str.length() && matcher.find(index)) {
			int iStart = matcher.start();// matcher��ʼλ��
			int iStop = matcher.end();// matcher����λ��
			System.out.println(iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop));// ���ƥ�䵽��λ�ü�������
			index = iStop + 1;
		}
	}

	/*
	 * �绰�ң�+861013712222222 15λ �绰�ң�013712222222 12λ �绰�ң�13712345678 11λ ������ʽ
	 * (\\+8610\\d{11})|(0?\\d{11}) ë�� �� �� ������ʽ ë��?��|�� �Ұ����ǵ�����ë��
	 * 
	 */
	@Test
	public void testPhone() {
		/*
		 * String str1 = "�绰�ң�+861013712222222";//������ʽ(\\d){1,} String str2 =
		 * "�绰�ң�013712222222";//������ʽ(\\d){1,} String str3 =
		 * "13712345678";//������ʽ(\\d){1,}
		 */
		String str = "�绰�ң�+861013712222222";
		str = "�绰�ң�013712222222";
		str = "�绰�ң�13712222222";
		Pattern pattern = Pattern.compile("(\\+8610\\d{11})|(0?\\d{11})");
		Matcher matcher = pattern.matcher(str);
		int index = 0;// ��������λ��
		while (index < str.length() && matcher.find(index)) {
			int iStart = matcher.start();// matcher��ʼλ��
			int iStop = matcher.end();// matcher����λ��
			System.out.println(iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop));// ���ƥ�䵽��λ�ü�������
			index = iStop + 1;
		}
	}

	/*
	 * ����������ʽ��
	 */
	@Test
	public void testGroup() {
		String str = "123456�Ŷ���abcde";
		String patStr = "((\\d+)(��.��)([a-zA-Z]+))";
		Pattern pattern = Pattern.compile(patStr);
		Matcher matcher = pattern.matcher(str);
		int groupCount = matcher.groupCount();
		System.out.println(groupCount);
		matcher.find();
		for (int i = 0; i < groupCount; i++) {
			System.out.println(matcher.group(i));
		}
	}

}
