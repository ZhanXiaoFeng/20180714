
/**  
* @Title: Demo10.java
* @Package demo10
* @Description: ������Ĺ��캯��������
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo10;

/**
 * @ClassName: Demo10
 * @Description: ������Ĺ��캯��������
 * @author ZRF
 * @date 2018��6��23��
 */
enum Ops {
	ADD, SUB
}

public class Demo10 {
	private int i, j, result;

	// �޲ι���
	public Demo10() {
	}

	// �вι���
	public Demo10(int _i, int _j) {
		i = _i;
		j = _j;
	}

	// ���÷��ţ� �Ǽӷ����㻹�Ǽ�������
	protected void setOperator(Ops _op) {
		result = _op.equals(Ops.ADD) ? i + j : i - j;
	}

	// ȡ��������
	public int getResult() {
		return result;
	}

	// �ӷ�����
	class Add extends Demo10 {
		{
			setOperator(Ops.ADD);
		}

		// ��д����Ĺ��췽��
		public Add(int _i, int _j) {
			super(_i, _j);
		}
	}

	public static void main(String[] args) {
		Demo10 c1 = new Demo10(1, 2) {
			{
				setOperator(Ops.ADD);
			}
		};
		System.out.println(c1.getResult());
	}
}
