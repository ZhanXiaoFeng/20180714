
/**  
* @Title: Demo19.java
* @Package demo19
* @Description: ���Ծ��Բ��Ǽ���
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo19;

/**
 * @ClassName: Demo19
 * @Description: ���Ծ��Բ��Ǽ���
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo19 {
	public static void main(String[] args) {
		String encode = StringUtils.encode(null);
		System.out.println(encode);
	}
}

// �ַ�����������
class StringUtils {
	public static String encode(String str) {
		assert str != null : " ���ܵ��ַ���Ϊ null";
		/* ���ܴ��� */
		return str;
	}
}