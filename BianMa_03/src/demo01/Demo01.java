
/**  
* @Title: Demo01.java
* @Package demo01
* @Description: �ڽӿ��в�Ҫ����ʵ�ִ���
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo01;

/**
 * @ClassName: Demo01
 * @Description: �ڽӿ��в�Ҫ����ʵ�ִ���
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo01 {
	public static void main(String[] args) {
		// ���ýӿڵ�ʵ��
		B.s.doSomething();
	}
}

// �ڽӿ��д���ʵ�ִ���
interface B {
	public static final S s = new S() {
		public void doSomething() {
			System.out.println("���ڽӿ���ʵ���� ");
		}
	};
}

// ��ʵ�ֵĽӿ�
interface S {
	public void doSomething();
}
