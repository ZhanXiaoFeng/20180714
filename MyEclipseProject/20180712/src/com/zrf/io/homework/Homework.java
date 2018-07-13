package com.zrf.io.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

public class Homework {

	/*
	 * ���Բ�ѯ��־����
	 */
	@Test
	public void getUSB() throws IOException {
		// ��ȡ�ļ���ַ
		File file = new File("E:\\�����\\����ר��\\�������\\2018-07-12\\vmware.log");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str = null;
		int line = 1;
		while ((str = reader.readLine()) != null) {
			String ptrStr = "USB: Connecting device";// ������ʽƥ�����
			Pattern pattern = Pattern.compile(ptrStr);
			Matcher matcher = pattern.matcher(str);
			int index = 0;// ��������λ��
			while (index < str.length() && matcher.find(index)) {
				int iStart = matcher.start();// matcher��ʼλ��
				int iStop = matcher.end();// matcher����λ��
				// ���ʹ��ʱ��
				String useTime = str.substring(0, 29);
				// ����豸id
				String endStrId = str.substring(str.lastIndexOf("id:"), str.length());
				System.out.println(" line  " + line + "\t" + iStart + "\t" + iStop + "\t" + str.substring(iStart, iStop)
						+ "\t" + "ʹ��ʱ��:" + useTime + "\t" + "�豸" + endStrId);// ���ƥ�䵽��λ�ü�������
				index = iStop + 1;
			}
			line++;// �м�1
		}
		reader.close();
	}

	/*
	 * ����д�뵽�ļ���
	 */
	@Test
	public void getHrefIndex() throws IOException {
		URL url = new URL("http://www.sohu.com/");
		InputStream openStream = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(openStream));
		String str = null;
		int line = 1;
		while ((str = reader.readLine()) != null) {// ���ζ�ȡ��
			// ����������ʽƥ�����
			/********************* ����һ *********************/
			//String ptrStr1 = "<[Aa]\\s+(.*?\\s+)*?href\\s*=\\s*([\"']).+?\\2\\s*(\\s+.*?\\s*)*?>.+?</[Aa]>";
			/********************* ����� *********************/
			String ptrStr = "<a.*?href=[\"']?((https?://)?/?[^\"']+)[\"']?.*?>(.+)</a>";
			Pattern pattern = Pattern.compile(ptrStr);
			Matcher matcher = pattern.matcher(str);
			int index = 0;// ��������λ��
			while (index < str.length() && matcher.find(index)) {
				int iStart = matcher.start();// matcher��ʼλ��
				int iStop = matcher.end();// matcher����λ��
				String href = str.substring(iStart, iStop);// ��һ�λ�õ�����
				// System.out.println(href);
				// �Ե�һ�λ�ȡ�����ӽ��д���
				String ptrStr2 = "href=.*?>";
				Pattern pattern2 = Pattern.compile(ptrStr2);
				Matcher matcher2 = pattern2.matcher(matcher.group());
				while (matcher2.find()) {
					String href2 = matcher2.group().replaceAll("href=|>", "");
					String href3 = href2.substring(1, href2.indexOf("\"", 2));
					System.out.println("������ַ:" + href3);
					BufferedWriter out = null;
					try {
						// �ļ�д��
						out = new BufferedWriter(new OutputStreamWriter(
								new FileOutputStream("E:\\�����\\����ר��\\�������\\2018-07-12\\href1.txt", true), "UTF-8"));
						out.write(line + "\t" + "������ַ:" + href3 + "\r\n");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					// System.out.println(" line " + line + "\t" + iStart +
					// "\t"+ iStop + "\t" + href);// ���ƥ�䵽��λ�ü�������
					index = iStop + 1;
				}
			}
			line++;// �м�1
		}
	}
}
