
/**
* @Title: Properties.java
* @Package com.zrf.ex.bean.test
* @Description: properties�����ļ��Ķ�ȡ�洢
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.junit.Test;

/**
 * @ClassName: Properties
 * @Description: properties�����ļ��Ķ�ȡ�洢
 * @author ZRF
 * @date 2018��7��19��
 */

public class TestProperties {
	//�����ļ� C:\Program Files\Java\jre1.8.0_172\lib\accessibility.properties
	@Test
	public void testProperties() {
		Properties properties = new Properties();
		// ���������ļ�����
		try {
			InputStream is = Files.newInputStream(
					Paths.get("C:", "Program Files", "Java", "jre1.8.0_172", "lib", "calendars.properties"));
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String name = properties.getProperty("calendar.taiwanese.eras");
		System.out.println(name);

		// д�����ļ�
		try {
			properties.storeToXML(Files.newOutputStream(Paths.get("D:", "abc.xml")), "aaaaaaa");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
