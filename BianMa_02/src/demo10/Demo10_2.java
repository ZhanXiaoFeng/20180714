
/**  
* @Title: Demo10_2.java
* @Package demo10
* @Description: ��Ҫ��������������
* @author ZRF
* @date 2018��6��22��
* @version V1.0  
*/

package demo10;

import java.util.Random;

/**
 * @ClassName: Demo10_2
 * @Description: ��Ҫ��������������
 * @author ZRF
 * @date 2018��6��22��
 */

public class Demo10_2 {
	public static void main(String[] args) {
		Random r = new Random(1000);
		for (int i = 1; i < 4; i++) {
			System.out.println(" �� " + i + " �Σ� " + r.nextInt());
		}
	}
}