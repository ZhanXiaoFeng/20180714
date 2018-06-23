
/**  
* @Title: Demo04_2.java
* @Package demo04
* @Description: ���캯��������
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo04;

/**
 * @ClassName: Demo04_2
 * @Description: ���캯��������
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo04_2 {
	public static void main(String[] args) {
		Server1 s = new SimpleServer1(1000);
		s.Start();
	}
}

// ����һ������
abstract class Server1 {
	public final static int DEFAULT_PORT = 40000;

	/**************************************/
	public void Start() {
		// ��������ṩ�Ķ˿ں�
		int port = getPort();
		System.out.println(" �˿ںţ� " + port);
		/* ���м������� */
	}

	/**************************************/

	// �������ṩ�˿ںţ� ���������Լ��
	protected abstract int getPort();
}

class SimpleServer1 extends Server1 {
	private int port = 100;

	// ��ʼ������һ���˿ں�
	public SimpleServer1(int _port) {
		port = _port;
	}

	// ���˿ں��Ƿ���Ч�� ��Ч��ʹ��Ĭ�϶˿ڣ� ����ʹ�������ģ��
	@Override
	protected int getPort() {
		return Math.random() > 0.5 ? port : DEFAULT_PORT;
	}
}