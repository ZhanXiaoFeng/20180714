
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

public class Demo07_2 {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer j = new Integer(100);
		compareTo(i, j);
	}

	/**
	 * @Title: compareTo @Description: TODO(������һ�仰�����������������) @param @param
	 *         i @param @param j ���� @return void �������� @throws
	 */

	// �Ƚ�������װ�����С
	private static void compareTo(Integer i, Integer j) {
		System.out.println(i == j);
		System.out.println(i > j);
		System.out.println(i < j);
	}
}