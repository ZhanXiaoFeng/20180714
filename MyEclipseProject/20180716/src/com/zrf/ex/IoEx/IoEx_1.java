package com.zrf.ex.IoEx;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

import org.junit.Test;

public class IoEx_1 {
	/*
	 * ������(�汾��) FileFilter����
	 */

	private FileFilter fnf;
	{
		fnf = name -> name.isDirectory() || name.getName().endsWith(".css");
	}

	public void testIO(File file, int i) {
		if (file.isFile()) {
			System.out.println(getTab(i - 1) + file.getName());
		} else if (file.isDirectory()) {
			System.out.println(getTab(i - 1) + file.getName());
			/**************��ʽһ**************/
			/*
			FileFilter fnf = new FileFilter() {

				@Override
				public boolean accept(File name) {
					return name.isDirectory() || name.getName().endsWith(".css");
				}
			};

			File[] listFiles = file.listFiles(fnf);
			for (File file2 : listFiles) {
				testIO(file2, i + 1);
			}
			*/
			/**************��ʽ��**************/
			//Arrays.asList(����);
			//Arrays.stream(file.listFiles(filter));������ת��Ϊstream
			Arrays.stream(file.listFiles(fnf)).forEach((file2)->testIO(file2, i+1));
		}
	}

	public String getTab(int Num) {
		String str = "";
		for (int i = 1; i < Num; i++) {
			str += "  ";
		}
		return str;
	}

	@Test
	public void testFile() {
		File file = new File("D:/GitProject");
		testIO(file, 1);
	}
}
