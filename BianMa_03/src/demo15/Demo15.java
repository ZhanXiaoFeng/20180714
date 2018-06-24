
/**  
* @Title: Demo15.java
* @Package demo15
* @Description: ��д equals ����ʱ��Ҫʶ�𲻳��Լ�
* @author ZRF
* @date 2018��6��24��
* @version V1.0  
*/

package demo15;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Demo15
 * @Description: ��д equals ����ʱ��Ҫʶ�𲻳��Լ�
 * @author ZRF
 * @date 2018��6��24��
 */

public class Demo15 {
	public static void main(String[] args) {
		Person p1 = new Person("����");
		Person p2 = new Person("����  ");
		List<Person> l = new ArrayList<Person>();
		l.add(p1);
		l.add(p2);
		System.out.println(" �б����Ƿ���������� " + l.contains(p1));
		System.out.println(" �б����Ƿ�������� �� " + l.contains(p2));
	}
}

class Person {
	private String name;

	public Person(String _name) {
		name = _name;
	}

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */

	public void setName(String name) {
		this.name = name;
	}

	/* name �� getter/setter ����ʡ�� */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person p = (Person) obj;
			return name.equalsIgnoreCase(p.getName());
		}
		return false;
	}
}