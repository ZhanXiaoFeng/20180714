
/**  
* @Title: Person.java
* @Package demo14.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo14.bean;

import java.io.IOException;
import java.io.Serializable;

/**
 * @ClassName: Person
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��21��
 */

public class Person implements Serializable {
	private static final long serialVersionUID = 60407L;
	// ����
	private String name;
	// нˮ
	private transient Salary salary;

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
	 * @return the salary
	 */

	public Salary getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public Person(String _name, Salary _salary) {
		name = _name;
		salary = _salary;
	}

	// ���л�ί�з���
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		out.writeInt(salary.getBasePay());
	}

	// �����л�ʱί�з���
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		salary = new Salary(in.readInt(), 0);
	}
}
