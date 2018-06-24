
/**  
* @Title: Demo18.java
* @Package demo18
* @Description: ��д equals�������븲д hashCode����
* @author ZRF
* @date 2018��6��24��
* @version V1.0  
*/

package demo18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @ClassName: Demo18
 * @Description: ��д equals�������븲д hashCode����
 * @author ZRF
 * @date 2018��6��24��
 */

public class Demo18 {
	public static void main(String[] args) {
		// Person ���ʵ����Ϊ Map �� key
		Map<Person, Object> map = new HashMap<Person, Object>() {
			{
				put(new Person(" ���� "), new Object());
			}
		};
		// Person ���ʵ����Ϊ List ��Ԫ��
		List<Person> list = new ArrayList<Person>() {
			{
				add(new Person(" ���� "));
			}
		};
		// �б����Ƿ����
		boolean b1 = list.contains(new Person(" ���� "));
		System.out.println(b1);
		// Map ���Ƿ����
		boolean b2 = map.containsKey(new Person(" ���� "));
		System.out.println(b2);
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

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			Person p = (Person) obj;
			if (p.getName() == null || name == null) {
				return false;
			} else {
				return name.equalsIgnoreCase(p.getName());
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).toHashCode();
	}

}