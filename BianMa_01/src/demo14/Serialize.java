
/**  
* @Title: Serialize.java
* @Package demo14
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo14;

import demo14.utils.SerializationUtils;
import demo14.bean.Person;
import demo14.bean.Salary;

/**
 * @ClassName: Serialize
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��21��
 */

public class Serialize {
	public static void main(String[] args) {
		// �������� 1000 Ԫ , ��Ч���� 2500 Ԫ
		Salary salary = new Salary(1000, 2500);
		// ��¼��Ա��Ϣ
		Person person = new Person(" ���� ", salary);
		// HR ϵͳ�־û��� �����ݵ���˰ϵͳ
		SerializationUtils.writeObject(person);
	}

}
