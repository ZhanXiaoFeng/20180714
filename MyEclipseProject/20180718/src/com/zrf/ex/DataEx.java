
/**
* @Title: DataEx.java
* @Package com.zrf.ex
* @Description: �ļ��ַ����ִ���ͳ��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;

/**
 * @ClassName: DataEx
 * @Description: �ļ��ַ����ִ���ͳ��
 * @author ZRF
 * @date 2018��7��18��
 */

public class DataEx {
	@Test
	public void test() throws IOException {
		// ��ȡ�ļ��������ַ�����ΪUTF-8
		List<String> lines = Files.readAllLines(Paths.get("C:", "Users", "Administrator", "Desktop", "DataEx.java"),
				Charset.forName("UTF-8"));// �õ�������
		int arr[] = new int[65536];// ��ʼ�����飬��a[0]=0,a[1]=0,...,a[65535]=0
		// ����ÿһ��
		lines.forEach((row) -> {
			for (char ch : row.toCharArray()) {// ����ÿһ���е�ÿ���ַ�
				arr[ch - 1] = arr[ch - 1] + 1;// ���ַ�����ͳ���ۼ�
			}
		});

		for (int i = 0; i < arr.length; i++) {
			char ch = (char) (i + 1); // �ҵ��±�i��������ַ�
			if (arr[i] > 0) {
				System.out.println(ch + "�ַ������ˣ�" + arr[i] + "��");
			}
		}
	}
}
