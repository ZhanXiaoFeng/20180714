
/**  
* @Title: Demo08.java
* @Package demo08
* @Description: ����ʹ�����ͳ�
* @author ZRF
* @date 2018��6��22��
* @version V1.0  
*/

package demo08;

import java.util.Scanner;

/**
 * @ClassName: Demo08
 * @Description: ����ʹ�����ͳ�
 * @author ZRF
 * @date 2018��6��22��
 */

public class Demo08 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int ii = input.nextInt();
			System.out.println("\n====" + ii + " ������ж� ======");
			// ����ͨ�� new ������ Integer ����
			Integer i = new Integer(ii);
			Integer j = new Integer(ii);
			System.out.println("new �����Ķ��� " + (i == j));
			// ��������תΪ��װ���ͺ�Ƚ�
			i = ii;
			j = ii;
			System.out.println(" ��������ת���Ķ��� " + (i == j));
			// ͨ����̬��������һ��ʵ��
			i = Integer.valueOf(ii);
			j = Integer.valueOf(ii);
			System.out.println("valueOf �����Ķ��� " + (i == j));
		}
	}
}