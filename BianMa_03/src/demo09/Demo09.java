
/**  
* @Title: Demo09.java
* @Package demo09
* @Description: ʹ��������Ĺ��캯��
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo09;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Demo09
 * @Description: ʹ��������Ĺ��캯��
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo09 {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		List l2 = new ArrayList() {
		};
		List l3 = new ArrayList() {
			{
			}
		};
		System.out.println(l1.getClass() == l2.getClass());
		System.out.println(l2.getClass() == l3.getClass());
		System.out.println(l1.getClass() == l3.getClass());
	}
}