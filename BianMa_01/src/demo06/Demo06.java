
/**  
* @Title: Demo06.java
* @Package demo06
* @Description: ��д�䳤����Ҳѭ�浸��
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo06;

/**
 * @ClassName: Demo06
 * @Description: ��д�䳤����Ҳѭ�浸��
 * @author ZRF
 * @date 2018��6��21��
 */

public class Demo06 {
	public static void main(String[] args) {
		// ����ת��
		Base base = new Sub();
		base.fun(100, 50);
		// ��ת��
		Sub sub = new Sub();
		//sub.fun(100, 50);
	}

}

// ����
class Base {
	void fun(int price, int... discounts) {
		System.out.println("Base......fun");
	}
}

// ���࣬ ��д���෽��
class Sub extends Base {
	@Override
	void fun(int price, int[] discounts) {
		System.out.println("Sub......fun");
	}
}
