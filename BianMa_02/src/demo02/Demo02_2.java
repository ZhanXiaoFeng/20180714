
/**  
* @Title: Demo02.java
* @Package demo02
* @Description: ���������ʹ������
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo02;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @ClassName: Demo02
 * @Description: ���������ʹ������
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo02_2 {
	public static void main(String[] args) {
		NumberFormat f = new DecimalFormat("#.##");
		System.out.println(f.format(10.00 - 9.60));
	}
}