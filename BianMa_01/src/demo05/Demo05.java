
/**  
* @Title: Demo05.java
* @Package demo05
* @Description: ���� null ֵ�Ϳ�ֵ��в���䳤����
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo05;

/**
 * @ClassName: Demo05
 * @Description: ���� null ֵ�Ϳ�ֵ��в���䳤����
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo05 {
	public void methodA(String str, Integer... is) {
	}

	public void methodA(String str, String... strs) {
	}

	public static void main(String[] args) {
		Demo05 client = new Demo05();
		client.methodA("China", 0);
		client.methodA("China", "People");
		String[] strs = null;
		client.methodA("China",strs);
	}
}
