
/**  
* @Title: Demo15.java
* @Package demo15
* @Description: break ���򲻿���
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo15;

/**
 * @ClassName: Demo15
 * @Description: break ���򲻿���
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo15 {
	public static void main(String[] args) {
		System.out.println("2 = " + toChineseNumberCase(2));
	}

	// �Ѱ��������ַ�������Ĵ�д����
	public static String toChineseNumberCase(int n) {
		String chineseNumber = "";
		switch (n) {
		case 0:
			chineseNumber = " �� ";
			break;
		case 1:
			chineseNumber = " Ҽ ";
			break;
		case 2:
			chineseNumber = " �� ";
			break;
		case 3:
			chineseNumber = " �� ";
			break;
		case 4:
			chineseNumber = " �� ";
			break;
		case 5:
			chineseNumber = " �� ";
			break;
		case 6:
			chineseNumber = " ½ ";
			break;
		case 7:
			chineseNumber = " �� ";
			break;
		case 8:
			chineseNumber = " �� ";
			break;
		case 9:
			chineseNumber = " �� ";
			break;
		}
		return chineseNumber;
	}

}
