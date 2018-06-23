
/**  
* @Title: Demo07.java
* @Package demo07
* @Description: �����������������
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo07;

/**
 * @ClassName: Demo07
 * @Description: �����������������
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo07 {
	public static void main(String[] args) {
		new Base();
		new Base("");
		new Base(0);
		System.out.println(" ʵ������������ " + Base.getNumOfObjects());
	}
}

class Base {
	// ���������
	private static int numOfObjects = 0;
	{
		// �������飬 ���������������
		numOfObjects++;
	}

	public Base() {
	}

	// �вι�������޲ι���
	public Base(String _str) {
		this();
	}

	// �вι��첻������������
	public Base(int _i) {
	}

	// ������һ�� JVM �У� �����˶��ٸ�ʵ������
	public static int getNumOfObjects() {
		return numOfObjects;
	}
}