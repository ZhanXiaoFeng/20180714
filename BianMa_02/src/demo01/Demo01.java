
/**  
* @Title: Demo01.java
* @Package demo01
* @Description: ��ż�жϣ� �������ж�
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo01;

import java.util.Scanner;

/**
 * @ClassName: Demo01
 * @Description: ��ż�жϣ� �������ж�
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo01 {
	public static void main(String[] args) {
		// ���ռ����������
		Scanner input = new Scanner(System.in);
		System.out.print(" �������������ж���ż�� ");
		while (input.hasNextInt()) {
			int i = input.nextInt();
			// String str = i + "->" + (i % 2 == 1 ? " ���� " : " ż�� ");
			String str = i + "->" + (i % 2 == 0 ? "ż�� " : " ���� ");
			System.out.println(str);
		}
	}
}