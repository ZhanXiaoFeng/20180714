
/**  
* @Title: Demo05.java
* @Package demo05
* @Description: �����ڹ��캯���г�ʼ��������
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo05;

/**
 * @ClassName: Demo05
 * @Description: �����ڹ��캯���г�ʼ��������
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo05 {
	public static void main(String[] args) {
		Son s = new Son();
		s.doSomething();
	}
}

// ����
class Father {
	Father() {
		new Other();
	}
}// ����

class Son extends Father {
	public void doSomething() {
		System.out.println("Hi,show me something");
	}
}

// �����
class Other {
	public Other() {
		new Son();
	}
}