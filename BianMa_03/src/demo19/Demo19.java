
/**  
* @Title: Demo19.java
* @Package demo19
* @Description: �Ƽ���д toString����
* @author ZRF
* @date 2018��6��24��
* @version V1.0  
*/

package demo19;

/**
 * @ClassName: Demo19
 * @Description: �Ƽ���д toString����
 * @author ZRF
 * @date 2018��6��24��
 */

public class Demo19 {
	public static void main(String[] args) {
		System.out.println(new Person(" ���� "));
	}
}

class Person {
	private String name;

	public Person(String _name) {
		name = _name;
	}
	/* name �� getter/setter ����ʡ�� */

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

	/*
	 * (non-Javadoc)
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}