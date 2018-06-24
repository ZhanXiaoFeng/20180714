
/**  
* @Title: Demo13.java
* @Package demo13
* @Description: ��������ǳ����
* @author ZRF
* @date 2018��6��24��
* @version V1.0  
*/

package demo13;

/**
 * @ClassName: Demo13
 * @Description: ��������ǳ����
 * @author ZRF
 * @date 2018��6��24��
 */

public class Demo13 {
	public static void main(String[] args) {
		// ���常��
		Person f = new Person(" ���� ");
		// ��������
		Person s1 = new Person(" ����� ", f);
		Person s2 = s1.clone();
		s2.setName(" С���� ");
		// �ϸɵ�
		s1.getFather().setName(" �ɵ� ");
		System.out.println(s1.getName() + " �ĸ����� " + s1.getFather().getName());
		System.out.println(s2.getName() + " �ĸ����� " + s2.getFather().getName());
	}
}

class Person implements Cloneable {
	// ����
	private String name;
	// ����
	private Person father;

	public Person(String _name) {
		name = _name;
	}

	public Person(String _name, Person _parent) {
		name = _name;
		father = _parent;
	}

	// ������ʵ��

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

	/**
	 * @return the father
	 */

	public Person getFather() {
		return father;
	}

	/**
	 * @param father
	 *            the father to set
	 */

	public void setFather(Person father) {
		this.father = father;
	}

	@Override
	public Person clone() {
		Person p = null;
		try {
			p = (Person) super.clone();
			p.setFather(new Person(p.getFather().getName()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
}