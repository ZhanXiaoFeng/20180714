
/**  
* @Title: Demo17.java
* @Package demo17
* @Description: �� equals��ʹ�� getClass���������ж�
* @author ZRF
* @date 2018��6��24��
* @version V1.0  
*/

package demo17;

/**
 * @ClassName: Demo17
 * @Description: �� equals��ʹ�� getClass���������ж�)
 * @author ZRF
 * @date 2018��6��24��
 */

public class Demo17 {
	public static void main(String[] args) {
		Employee e1 = new Employee(" ���� ", 100);
		Employee e2 = new Employee(" ���� ", 1001);
		Person p1 = new Person(" ���� ");
		System.out.println(p1.equals(e1));
		System.out.println(p1.equals(e2));
		System.out.println(e1.equals(e2));
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
		if (obj!=null && obj.getClass() == this.getClass()) {
			Person p = (Person) obj;
			if (p.getName() == null || name == null) {
				return false;
			} else {
				return name.equalsIgnoreCase(p.getName());
			}
		}
		return false;
	}

}

class Employee extends Person {
	private int id;

	/* id �� getter/setter ����ʡ�� */
	public Employee(String _name, int _id) {
		super(_name);
		id = _id;
	}

	/**
	 * @return the id
	 */

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Employee) {
			Employee e = (Employee) obj;
			return super.equals(obj) && e.getId() == id;
		}
		return false;
	}
}