
/**  
* @Title: Product.java
* @Package demo11
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo11;

import demo11.bean.Person;
import demo11.utils.SerializationUtils;

/**
 * @ClassName: Product
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��21��
 */

public class Producter {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		person.setName(" ����ħ�� ");
		// ���л��� ���浽������
		SerializationUtils.writeObject(person);
	}

}
