
/**  
* @Title: Demo18.java
* @Package demo18
* @Description: ���� instanceof ��Ԥ�ڽ��
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo18;

import java.util.Date;

/**
 * @ClassName: Demo18
 * @Description: ���� instanceof ��Ԥ�ڽ��
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo18 {
	public static void main(String[] args) {
		// String �����Ƿ��� Object ��ʵ��
		boolean b1 = "Sting" instanceof Object;
		System.out.println(b1);
		// String �����Ƿ��� String ��ʵ��
		boolean b2 = new String() instanceof String;
		System.out.println(b2);
		// Object �����Ƿ��� String ��ʵ��
		boolean b3 = new Object() instanceof String;
		System.out.println(b3);
		// ���������Ƿ���װ�����͵�ʵ��
		// boolean b4 = 'A' instanceof Character;
		// �ն����Ƿ��� String ��ʵ��
		boolean b5 = null instanceof String;
		System.out.println(b5);
		// ����ת����Ŀն����Ƿ��� String ��ʵ��
		boolean b6 = (String) null instanceof String;
		System.out.println(b6);
		// Date �����Ƿ��� String ��ʵ��30 ��д���������룺 ���� Java ����� 151 ������
		// boolean b7 = new Date() instanceof String;
		// �ڷ��������ж� String �����Ƿ��� Date ��ʵ��
		boolean b8 = new GenericClass<String>().isDateInstance("");
		System.out.println(b8);
	}
}

class GenericClass<T> {
	// �ж��Ƿ��� Date ����
	public boolean isDateInstance(T t) {
		return t instanceof Date;
	}
}
