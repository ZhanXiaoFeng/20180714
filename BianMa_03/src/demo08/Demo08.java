
/**  
* @Title: Demo08.java
* @Package demo08
* @Description: ʹ�þ�̬�ڲ�����߷�װ��
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo08;

import demo08.bean.Person;

/**
 * @ClassName: Demo08
 * @Description: ʹ�þ�̬�ڲ�����߷�װ��
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo08 {
	public static void main(String[] args) {
		// �������������
		Person p = new Person(" ���� ");
		// ���������ļ�ͥ��Ϣ
		p.setHome(new Person.Home(" �Ϻ� ", "021"));
		System.out.println(p);
	}
}