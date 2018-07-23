
/**
* @Title: testJob.java
* @Package com.zrf.ex.test
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��23��
* @version V1.0  
*/

package com.zrf.ex.test;

import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import com.zrf.ex.MyTestTools;

/**
 * @ClassName: testJob
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��7��23��
 */

public class TestJob {

	private MyTestTools mmt;

	@Before
	public void Init() {
		mmt = new MyTestTools();
	}

	@Test
	public void test() {
		Properties pro = mmt.getPro();
		Set<String> set = pro.stringPropertyNames();
		Pattern pattern1 = Pattern.compile("(.+)_\\((.*)\\)");
		Pattern pattern2 = Pattern.compile("\\((.*)\\)_(.+)\\((.*)\\)_\\((.*)\\)");
		set.forEach(name -> {
			Matcher matcher1 = pattern1.matcher(name);
			if (matcher1.find()) {
				System.out.print("��������:" + matcher1.group(1) + "\t���캯����������:" + matcher1.group(2));
			}
			String value = pro.getProperty(name);
			Matcher matcher2 = pattern2.matcher(value);
			if (matcher2.find()) {
				System.out.println("\t" + matcher2.group(1) + "\t" + matcher2.group(2) + "\t" + matcher2.group(3) + "\t"
						+ matcher2.group(4));
			}
		});
	}

	@Test
	public void testRun() {
		mmt.run();
	}
}
