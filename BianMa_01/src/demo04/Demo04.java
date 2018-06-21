
/**  
* @Title: Demo04.java
* @Package demo04
* @Description: ������б䳤�����ķ�������
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo04;

import java.text.NumberFormat;

/**
 * @ClassName: Demo04
 * @Description: ������б䳤�����ķ�������
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo04 {
	// ���ۿۼ���
	public void calPrice(int price, int discount) {
		float knockdownPrice = price * discount / 100.0F;
		System.out.println(" ���ۿۺ�ļ۸��ǣ� " + formateCurrency(knockdownPrice));
	}

	// ���Ӷ��ۿۼ���
	public void calPrice(int price, int... discounts) {
		float knockdownPrice = price;
		for (int discount : discounts) {
			knockdownPrice = knockdownPrice * discount / 100;
		}
		System.out.println(" �����ۿۺ�ļ۸��ǣ� " + formateCurrency(knockdownPrice));
	}

	// ��ʽ���ɱ��Ļ�����ʽ
	private String formateCurrency(float price) {
		return NumberFormat.getCurrencyInstance().format(price / 100);
	}

	public static void main(String[] args) {
		Demo04 demo04 = new Demo04();
		// 499 Ԫ�Ļ�� �� 75 ��
		demo04.calPrice(49900, 75);
	}

}
