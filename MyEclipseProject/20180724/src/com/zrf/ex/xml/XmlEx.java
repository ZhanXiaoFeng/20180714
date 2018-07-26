
/**
* @Title: XmlEx.java
* @Package com.zrf.ex.xml
* @Description: xml�ļ�ʹ��
* @author ZRF
* @date 2018��7��24��
* @version V1.0  
*/

package com.zrf.ex.xml;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.zrf.ex.bean.Student;

/**
 * @ClassName: XmlEx
 * @Description: xml�ļ�ʹ��
 * @author ZRF
 * @date 2018��7��24��
 */

public class XmlEx {
	@Test
	public void readXml() throws Exception {
		// ����ģʽ
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// ����ģʽ
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		InputStream is = this.getClass().getResourceAsStream("/student.xml");
		Document document = documentBuilder.parse(is);
		Element element = (Element) document.getChildNodes().item(0);
		System.out.println(element.getNodeName() + "\t" + element.getNodeValue());

		// ��ȡzhangsan
		NodeList nodeList = element.getElementsByTagName("name");
		Element name = (Element) nodeList.item(0);
		String attr = name.getAttribute("value");
		System.out.println(attr);

		// ��ȡ165
		NodeList nodeListHeight = element.getElementsByTagName("height");
		Element height = (Element) nodeListHeight.item(0);
		String text = height.getTextContent();
		System.out.println(text);

		// ��ȡ165
		Text firstChild = (Text) height.getFirstChild();
		System.out.println(firstChild.getNodeValue().trim());
		System.out.println(firstChild.getWholeText());

		// ��ȡsex-->true
		NodeList nodeListSex = element.getElementsByTagName("sex");
		Element sex = (Element) nodeListSex.item(0);
		String text1 = sex.getTextContent();
		System.out.println(text1);

		Text lastChild = (Text) sex.getLastChild();
		System.out.println(lastChild.getNodeValue().trim());

		// ���÷�����Ƶ����вι��췽��
		Class clazz = Class.forName("com.zrf.ex.bean.Student");
		// ���ù��캯��
		Student s = (Student) clazz.newInstance();
		// ָ����������
		Constructor cons = clazz.getConstructor(String.class, double.class, boolean.class);
		Student s1 = (Student) cons.newInstance(attr, Double.parseDouble(text), Boolean.parseBoolean(text1));
		Stream.of(s1).forEach(System.out::println);
	}

	@Test
	public void testXmlReflect() throws Exception {
		Document document = init();
		Element element = (Element) document.getChildNodes().item(0);// student�ڵ�

		// ��ȡClass��
		// �õ�com.zrf.ex.bean.Student
		String className = element.getAttribute("class");
		System.out.println("����Ϊ����" + className);

		// ��ȡ����-ֵ-����(name-zhangsan-java.lang.String)
		NodeList nameList = document.getElementsByTagName("name");
		Element item = (Element) nameList.item(0);
		String name = item.getNodeName();
		System.out.println("�������ƣ���" + name);
		String nameValue = item.getElementsByTagName("value").item(0).getTextContent();
		System.out.println("����ֵ������" + nameValue);
		String nameType = item.getElementsByTagName("type").item(0).getTextContent();
		System.out.println("�������ͣ���" + nameType);

		// ��ȡ����-ֵ-����(height-165-double)
		NodeList nameList1 = document.getElementsByTagName("height");
		Element item1 = (Element) nameList1.item(0);
		String height = item1.getNodeName();
		System.out.println("�������ƣ���" + height);
		String heightValue = item1.getElementsByTagName("value").item(0).getTextContent();
		System.out.println("����ֵ������" + heightValue);
		String heightType = item1.getElementsByTagName("type").item(0).getTextContent();
		System.out.println("�������ͣ���" + heightType);

		// ��ȡ����-ֵ-����(sex-true-boolean)
		NodeList nameList2 = document.getElementsByTagName("sex");
		Element item2 = (Element) nameList2.item(0);
		String sex = item2.getNodeName();
		System.out.println("�������ƣ���" + sex);
		String sexValue = item2.getElementsByTagName("value").item(0).getTextContent();
		System.out.println("����ֵ������" + sexValue);
		String sexType = item2.getElementsByTagName("type").item(0).getTextContent();
		System.out.println("�������ͣ���" + sexType);
	}

	/**
	 * @Title: init @Description:
	 * TODO(������һ�仰�����������������) @param @return @param @throws
	 * ParserConfigurationException @param @throws SAXException @param @throws
	 * IOException ���� @return Document �������� @throws
	 */

	private Document init() throws ParserConfigurationException, SAXException, IOException {
		// ����ģʽ
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// ����ģʽ
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		InputStream is = this.getClass().getResourceAsStream("/student1.xml");
		Document document = documentBuilder.parse(is);
		return document;
	}
}
