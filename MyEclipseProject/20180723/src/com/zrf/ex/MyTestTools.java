
/**
* @Title: MyTestTools.java
* @Package com.zrf.ex
* @Description: �����Զ�������
* @author ZRF
* @date 2018��7��23��
* @version V1.0  
*/

package com.zrf.ex;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: MyTestTools
 * @Description: �����Զ�������
 * @author ZRF
 * @date 2018��7��23��
 */

public class MyTestTools {
	// �����ļ�
	private Properties pro;
	// ����
	private Class clazz;
	// ���캯��
	private Constructor cons;
	// ���캯����������
	private Class[] consParams;
	// ���췽������ֵ
	private Object[] consValues;
	// ���췽��
	private Method method;
	// ���췽����������
	private Class[] methodParams;
	// ���췽������ֵ
	private Object[] methodValues;
	// �����޲ι��캯��
	private Object target;

	public MyTestTools() {
		// ���������ļ�����ŵ�λ��
		init("D:\\autotest.properties");
	}

	public MyTestTools(String fileName) {
		// ���������ļ����ļ���
		init(fileName);
	}

	private void init(String fileName) {
		// newһ�������ļ�����
		pro = new Properties();
		try (// ��ȡ�ļ�������
				InputStream is = Files.newInputStream(Paths.get(fileName));) {
			// ���������ļ�
			pro.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * �������ֵ
	 */
	public Properties getPro() {
		return this.pro;
	}

	// ���к�������
	public void run() {
		pro = getPro();
		// �õ��ļ��е�key��ֵ
		Set<String> set = pro.stringPropertyNames();
		set.forEach((name) -> {
			// ��ȡkey��ֵ����Ӧ��valueֵ
			String value = pro.getProperty(name);
			// ��key-valueֵ���д���
			process(name, value);
		});
	}

	/*
	 * ��key-valueֵ���д���
	 */
	public void process(String name, String value) {
		// com.zrf.reflect.bean.Person_(java.lang.String,double)=("lisi",157)_setName(java.lang.String,int,double)_("xiaogou",10,157.0)
		// com.zrf.reflect.bean.Person ����
		// (java.lang.String,double)���캯���������� ("lisi",157)���캯������ֵ
		// setName ���췽��
		// (java.lang.String,int,double)���췽���������� ("xiaogou",10,157.0)���췽������ֵ

		// keyֵ��������ʽ����
		Pattern pattern1 = Pattern.compile("(.+)_\\((.*)\\)");
		// valueֵ��������ʽ����
		Pattern pattern2 = Pattern.compile("\\((.*)\\)_(.+)\\((.*)\\)_\\((.*)\\)");
		String className = null;
		String consParamType = "";
		String consParamValue = null;

		String methodName = null;
		String methodParamType = null;
		String methodParamValue = null;

		Matcher matcher1 = pattern1.matcher(name);
		if (matcher1.find()) {
			// ����
			className = matcher1.group(1);
			// ���캯����������
			consParamType = matcher1.group(2);
		}

		Matcher matcher2 = pattern2.matcher(value);
		if (matcher2.find()) {
			// ���캯������ֵ
			consParamValue = matcher2.group(1);
			// ���췽��
			methodName = matcher2.group(2);
			// ���췽����������
			methodParamType = matcher2.group(3);
			// ���췽������ֵ
			methodParamValue = matcher2.group(4);
		}

		try {
			// ������ƻ�ȡClass����
			this.clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/************** ִ�й��췽�� *****************/
		// �������췽���Ĳ�������
		makeCons(consParamType);
		// ���빹�췽���Ĳ�������
		this.makeConsObject(consParamValue);
		this.makeTarget();// ��������
		// ����������������
		this.methodParams = this.getParamClasses(methodParamType);
		// ��ȡ�����ķ������ƣ�������������
		getMethod(methodName, methodParamType);// ����Method
		// ��ȡ�����Ĳ���ֵ
		makeMethodParams(methodParamValue);
		// �������еķ�����ִ�ж�Ӧ���еķ���
		execute();
		/*
		 * ִ����ߵķ����� 1��Method 2������ֵ���ɵ����� Method Class �������� �����б�(Class...)
		 * 
		 * ִ�У� method Ŀ����� ����ֵ���󹹳ɵ�����
		 */
	}

	public void execute() {
		try {
			this.method.invoke(this.target, methodValues);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void getMethod(String methodName, String paramType) {
		try {
			this.method = this.clazz.getMethod(methodName, getParamClasses(paramType));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public Class[] getParamClasses(String paramType) {
		Class[] classes = null;
		if (paramType == null || "".equals(paramType.trim())) {
			classes = new Class[] {};
		} else {
			String arr[] = paramType.split(",");
			classes = new Class[arr.length];
			for (int i = 0; i < arr.length; i++) {
				classes[i] = this.transform(arr[i]);
			}
		}
		return classes;
	}

	// ���캯��
	public void makeCons(String paramType) {
		Class[] classes = this.getParamClasses(paramType);
		this.consParams = classes;
		try {
			this.cons = clazz.getConstructor(classes);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public Object[] getParamValues(Class[] types, String consString) {
		Object[] paramValues = null;
		if (consString == null || "".equals(consString.trim())) {
			paramValues = new Object[] {};
		} else {
			String arr[] = consString.split(",");
			paramValues = new Object[arr.length];
			for (int i = 0; i < arr.length; i++) {
				paramValues[i] = this.transform(types[i], arr[i]);
			}
		}

		return paramValues;
	}

	// ������Ķ�Ӧ����ת��
	public Class transform(String name) {
		Class c = null;
		switch (name) {
		case "byte":
			c = byte.class;
			break;
		case "short":
			c = short.class;
			break;
		case "int":
			c = int.class;
			break;
		case "long":
			c = long.class;
			break;
		case "char":
			c = char.class;
			break;
		case "boolean":
			c = boolean.class;
			break;
		case "double":
			c = double.class;
			break;
		case "float":
			c = float.class;
			break;
		default:
			try {
				c = Class.forName(name);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		return c;
	}

	public void makeMethodParams(String consString) {
		this.methodValues = getParamValues(this.methodParams, consString);
	}

	public void makeConsObject(String consString) {
		this.consValues = this.getParamValues(consParams, consString);
	}

	public Object transform(Class class1, String value) {
		Object obj = null;
		if (class1 == String.class) {
			obj = value;
		} else if (class1 == boolean.class || class1 == Boolean.class) {
			obj = Boolean.valueOf(value);
		} else if (class1 == char.class || class1 == Character.class) {
			obj = value.charAt(0);
		} else if (class1 == double.class || class1 == Double.class) {
			obj = Double.valueOf(value);
		} else if (class1 == float.class || class1 == Float.class) {
			obj = Float.valueOf(value);
		} else if (class1 == byte.class || class1 == Byte.class) {
			obj = Byte.valueOf(value);
		} else if (class1 == short.class || class1 == Short.class) {
			obj = Short.valueOf(value);
		} else if (class1 == int.class || class1 == Integer.class) {
			obj = Integer.valueOf(value);
		} else if (class1 == long.class || class1 == Long.class) {
			obj = Long.valueOf(value);
		}
		return obj;
	}

	public void makeTarget() {
		try {
			// �����޲ι��캯������������Ӧ���вι��췽��
			// ���빹�췽����Ӧ��ֵ
			this.target = this.cons.newInstance(consValues);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
