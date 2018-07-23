
/**
* @Title: TestAutoUtil.java
* @Package com.zrf.reflect.homework
* @Description: Java�������ʵ���Զ�����
* @author ZRF
* @date 2018��7��21��
* @version V1.0  
*/

package com.zrf.reflect.homework;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.Test;
import com.zrf.reflect.bean.Person;

/**
 * @ClassName: TestAutoUtil
 * @Description: Java�������ʵ���Զ�����
 * @author ZRF
 * @date 2018��7��21��
 */

public class TestAutoUtil {
	@Test
	public void testProperties() throws Exception {
		Properties properties = new Properties();
		Person p = null;
		// ���������ļ�����
		try {
			InputStream is = Files.newInputStream(Paths.get("D:", "autotest.properties"));
			properties.load(is);
			Set<String> spn = properties.stringPropertyNames();
			System.out.println("keyֵ��");
			Stream.of(spn).forEach(System.out::println);

			// ��ȡ�õ�value1:("lisi",157)_setName(java.lang.String)_("xiaogou")
			System.out.println("valueֵ��");
			String value1 = properties.getProperty(spn.toString().substring(1, spn.toString().indexOf("]")));
			System.out.println(value1);

			String str = spn.toString();// �õ��ַ���
			// ��ȡcom.zrf.reflect.bean.Person
			String str1 = str.substring(1, str.indexOf("_"));

			// ��ȡjava.lang.String����
			String str2 = str.substring(str.indexOf("(") + 1, str.indexOf(","));

			// ��ȡdouble
			String str3 = str.substring(str.indexOf(",") + 1, str.indexOf(")"));

			// ����java.lang.String��
			Class strClass = Class.forName(str2);

			// ��ȡ"lisi"
			String str4 = value1.substring(value1.indexOf("(") + 1, value1.indexOf(","));

			// ��ȡ157
			String str5 = value1.substring(value1.indexOf(",") + 1, value1.indexOf(")"));
			// ת��Ϊdouble��ֵ
			double height = Double.parseDouble(str5);

			Class clazz = Class.forName(str1);
			Constructor con = clazz.getConstructor(strClass, double.class);
			p = (Person) con.newInstance(str4, height);
			System.out.println(p);

			// ��ȡsetName
			String str6 = value1.substring(value1.indexOf("_") + 1, value1.indexOf("(j"));

			Method method = clazz.getMethod(str6, strClass);

			// ת��ΪgetName
			String str8 = str6.replace(str6.substring(0, 3), "get");

			// ��ȡ"xiaogou"
			String str7 = value1.substring(value1.lastIndexOf("_") + 3, value1.lastIndexOf(")") - 1);

			method.invoke(p, str7);
			// ʹ��Get�������Setֵ
			Method method2 = clazz.getMethod(str8);
			Object res = method2.invoke(p);
			Stream.of(res).forEach(System.out::println);

			// д�뵽�ļ�
			try {
				properties.storeToXML(Files.newOutputStream(Paths.get("D:", "autotest.xml")), str8);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
