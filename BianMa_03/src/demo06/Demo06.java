
/**  
* @Title: Demo06.java
* @Package demo06
* @Description: ʹ�ù������龫������
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo06;

/**
 * @ClassName: Demo06
 * @Description: ʹ�ù������龫������
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo06 {
	public void Client() {
		System.out.println(" ִ�й������� ");
		System.out.println(" ִ���޲ι��� ");
	}

	public void Client(String _str) {
		System.out.println(" ִ�й������� ");
		System.out.println(" ִ���вι��� ");
	}

	public static void main(String[] args) {
		Demo06 demo06 = new Demo06();
		demo06.Client();
		demo06.Client(null);
	}
}