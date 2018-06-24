
/**  
* @Title: Demo11.java
* @Package demo11
* @Description: �ö��ؼ̳г�Ϊ��ʵ
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo11;

/**
 * @ClassName: Demo11
 * @Description: �ö��ؼ̳г�Ϊ��ʵ
 * @author ZRF
 * @date 2018��6��23��
 */

public class Demo11 {
	// ����
	interface Father {
		public int strong();
	}

	// ĸ��
	interface Mother {
		public int kind();
	}

	class FatherImpl implements Father {
		// ���׵�ǿ׳ָ���� 8
		public int strong() {
			return 8;
		}
	}

	class MotherImpl implements Mother {
		// ĸ�׵�����ָ���� 8
		public int kind() {
			return 8;
		}
	}

	class Son extends FatherImpl implements Mother {
		@Override
		public int strong() {
			// ���ӱȸ���ǿ׳
			return super.strong() + 1;
		}

		@Override
		public int kind() {
			return new MotherSpecial().kind();
		}

		private class MotherSpecial extends MotherImpl {
			public int kind() {
				// ��������ָ��������
				return super.kind() - 1;
			}
		}
	}

	class Daughter extends MotherImpl implements Father {
		@Override
		public int strong() {
			return new FatherImpl() {
				@Override
				public int strong() {
					// Ů����ǿ׳ָ��������
					return super.strong() - 2;
				}
			}.strong();
		}
	}
}