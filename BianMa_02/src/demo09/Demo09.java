
/**  
* @Title: Demo09.java
* @Package demo09
* @Description: ����ѡ���������
* @author ZRF
* @date 2018��6��22��
* @version V1.0  
*/

package demo09;

/**
 * @ClassName: Demo09
 * @Description: ����ѡ���������
 * @author ZRF
 * @date 2018��6��22��
 */

public class Demo09 {
	public static void main(String[] args) {
		Demo09 cilent = new Demo09();
		int i = 140;
		// �ֱ𴫵� int ���ͺ� Integer ����
		cilent.f(i);
		cilent.f(Integer.valueOf(i));
	}

	public void f(long a) {
		System.out.println(" �������͵ķ��������� ");
	}

	public void f(Long a) {
		System.out.println(" ��װ���͵ķ��������� ");
	}
}