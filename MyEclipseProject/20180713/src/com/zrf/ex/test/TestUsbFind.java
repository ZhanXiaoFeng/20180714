package com.zrf.ex.test;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.zrf.ex.UsbFind;

public class TestUsbFind {

	private UsbFind usbFind;

	/*
	 * �����ʼ��
	 */
	@Before
	public void init() {
		usbFind = new UsbFind();
	}

	/*
	 * ���Զ������˺������
	 */
	@Test
	public void testUsbFind() {
		List<String> allLines = this.usbFind
				.getAllLines(Paths.get("E:", "�����", "����ר��", "�������", "2018-07-12", "vmware.log"));
		List<String> fillter = this.usbFind.fillter(allLines);
		fillter.forEach((f) -> System.out.println(f));
	}

	/*
	 * ���԰��ַ�����ΪLocalDateTime
	 */
	@Test
	public void testDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ta = dtf.parse("2018-05-24T10:54:07.299+08:00", LocalDateTime::from);
		LocalDateTime ldt = LocalDateTime.from(ta);
		String sss = ldt.getYear() + "��" + ldt.getMonthValue() + "��" + ldt.getDayOfMonth() + "��" + ldt.getHour() + "ʱ"
				+ ldt.getMinute() + "��" + ldt.getSecond() + "��";
		System.out.println(sss);
	}
	
	/*
	 * ����oneRow()
	 */
	@Test
	public void testOneRow() throws IOException{
		Object[] oneRow = this.usbFind.oneRow(Paths.get("E:", "�����", "����ר��", "�������", "2018-07-12", "vmware.log"));
		for (Object object : oneRow) {
			System.out.println(object);
		}
	}
}
