
/**  
* @Title: Demo14.java
* @Package demo14
* @Description: �Ƽ�ʹ�����л�ʵ�ֶ���Ŀ���
* @author ZRF
* @date 2018��6��24��
* @version V1.0  
*/

package demo14;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName: Demo14
 * @Description: �Ƽ�ʹ�����л�ʵ�ֶ���Ŀ���
 * @author ZRF
 * @date 2018��6��24��
 */

public class Demo14 {
	public static void main(String[] args) {
		// ���常��
		Person f = new Person(" ���� ");
		// ��������
		Person s1 = new Person(" ����� ", f);
		Person s2 = s1.clone(s1);
		s2.setName(" С���� ");
		// �ϸɵ�
		s1.getFather().setName(" �ɵ� ");
		System.out.println(s1.getName() + " �ĸ����� " + s1.getFather().getName());
		System.out.println(s2.getName() + " �ĸ����� " + s2.getFather().getName());
	}
}

class Person implements Serializable {
	private static final long serialVersionUID = 1611293231L;
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

	// ����һ������
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj) {
		// ���������Ķ���
		T clonedObj = null;
		try {
			// ��ȡ�����ֽ�����
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			// �����ڴ�ռ䣬 д��ԭʼ���� �����¶���
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			// �����¶��� ��������ת��
			clonedObj = (T) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clonedObj;
	}
}