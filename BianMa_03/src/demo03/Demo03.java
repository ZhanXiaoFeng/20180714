
/**  
* @Title: Demo03.java
* @Package demo02
* @Description: ��Ҫ��д��̬����
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo03;

/**
 * @ClassName: Demo03
 * @Description: ��Ҫ��д��̬����
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo03 {
	public static void main(String[] args) {
		Base base = new Sub();
		// ���÷Ǿ�̬����
		base.doAnything();
		// ���þ�̬����
		base.doSomething();
	}
}

class Base {
	// ���ྲ̬����
	public static void doSomething() {
		System.out.println(" ���Ǹ��ྲ̬���� ");
	}

	// ����Ǿ�̬����
	public void doAnything() {
		System.out.println(" ���Ǹ���Ǿ�̬���� ");
	}
}

class Sub extends Base {
	// ����ͬ���� ͬ�����ľ�̬����
	public static void doSomething() {
		System.out.println(" �������ྲ̬���� ");
	}

	// ��д����ķǾ�̬����
	@Override
	public void doAnything() {
		System.out.println(" ��������Ǿ�̬���� ");
	}
}