
/**  
* @Title: Demo07.java
* @Package demo07
* @Description: ������װ���͵Ĵ�С�Ƚ�
* @author ZRF
* @date 2018��6��22��
* @version V1.0  
*/

package demo07;

/**
 * @ClassName: Demo07
 * @Description: ������װ���͵Ĵ�С�Ƚ�
 * @author ZRF
 * @date 2018��6��22��
 */

public class Demo07_1 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		compare(i, j);
	}

	// �Ƚ�������װ�����С
	public static void compare(Integer i, Integer j) {
		System.out.println(i == j);
		System.out.println(i > j);
		System.out.println(i < j);
	}
}