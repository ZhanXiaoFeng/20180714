
/**  
* @Title: Demo05_3.java
* @Package demo05
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��22��
* @version V1.0  
*/

package demo05;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName: Demo05_3
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��22��
 */

public class Demo05_3 {
	public static void main(String[] args) {
		// ���
		BigDecimal d = new BigDecimal(888888);
		// �����ʣ� �� 3 ���㼾����
		BigDecimal r = new BigDecimal(0.001875 * 3);
		// ������Ϣ
		BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
		System.out.println(" ����Ϣ�ǣ� " + i);
	}
}