
/**  
* @Title: Demo03.java
* @Package demo03
* @Description: ��Ҫ������ĬĬת��
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo03;

/**
 * @ClassName: Demo03
 * @Description: ��Ҫ������ĬĬת��
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo03 {
	// ������ 30 ���� / �룬 ����
	public static final int LIGHT_SPEED = 30 * 10000 * 1000;

	public static void main(String[] args) {
		System.out.println(" ��Ŀ 1�� ���������䵽������Ҫ 1 �룬 ���������͵���ľ��롣 ");
		long dis1 = LIGHT_SPEED * 1;
		System.out.println(" ���������ľ����ǣ� " + dis1 + " �� ");
		System.out.println("--------------------------------------------");
		System.out.println(" ��Ŀ 2�� ̫�������䵽��������Ҫ 8 ���ӣ� ����̫��������ľ��롣");
		// ����Ҫ����������Χ�� ʹ�� long ��
		// long dis2 = LIGHT_SPEED * 60L * 8;
		long dis2 = 1L * LIGHT_SPEED * 60 * 8;
		System.out.println(" ̫�������ľ����ǣ� " + dis2 + " �� ");
	}

}