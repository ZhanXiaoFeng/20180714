
/**  
* @Title: Deserialize.java
* @Package demo14
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo14;

import demo11.utils.SerializationUtils;
import demo14.bean.Person;

/**
 * @ClassName: Deserialize
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��21��
 */

public class Deserialize {

	public static void main(String[] args) {
		// ����ϵͳ�����л��� ����ӡ��Ϣ
		Person p = (Person) SerializationUtils.readObject();
		StringBuffer sb = new StringBuffer();
		sb.append(" ���� :" + p.getName());
		sb.append("\t �������ʣ� " + p.getSalary().getBasePay());
		sb.append("\t ��Ч���ʣ� " + p.getSalary().getBonus());
		System.out.println(sb);
	}

}
