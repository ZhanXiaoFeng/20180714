
/**  
* @Title: Demo04.java
* @Package demo04
* @Description: �߽磬 �߽磬 ���Ǳ߽�
* @author ZRF
* @date 2018��6��22��
* @version V1.0  
*/

package demo04;

import java.util.Scanner;

/**
 * @ClassName: Demo04
 * @Description: �߽磬 �߽磬 ���Ǳ߽�
 * @author ZRF
 * @date 2018��6��22��
 */

public class Demo04 {
	// һ����Աӵ�в�Ʒ���������
	public final static int LIMIT = 2000;
	public static void main(String[] args) {
		// ��Ա��ǰӵ�еĲ�Ʒ����
		int cur = 1000;
		Scanner input = new Scanner(System.in);
		System.out.print(" ��������ҪԤ���������� ");
		while (input.hasNextInt()) {
			int order = input.nextInt();
			// ��ǰӵ�е���׼�������Ĳ�Ʒ����֮��
			if (order > 0 && order + cur <= LIMIT) {
				System.out.println(" ���Ѿ��ɹ�Ԥ���� " + order + " ����Ʒ�� ");
			} else {
				System.out.println(" �����޶ Ԥ��ʧ�ܣ� ");
			}
		}
	}
}