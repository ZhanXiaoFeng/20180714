
/**  
* @Title: Person.java
* @Package demo08.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��23��
* @version V1.0  
*/

package demo08.bean;

/**
 * @ClassName: Person
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��23��
 */

public class Person {
	// ����
	private String name;
	// ��ͥ
	private Home home;

	// ���캯����������ֵ
	public Person(String _name) {
		name = _name;
	}

	/**
	 * @return the name
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the home
	 */

	public Home getHome() {
		return home;
	}

	/**
	 * @param home
	 *            the home to set
	 */

	public void setHome(Home home) {
		this.home = home;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */

	@Override
	public String toString() {
		return "Person [name=" + name + ", home=" + home + "]";
	}

	/* home�� name �� getter/setter ����ʡ�� */
	public static class Home {
		// ��ͥ��ַ
		private String address;
		// ��ͥ�绰
		private String tel;

		public Home(String _address, String _tel) {
			address = _address;
			tel = _tel;
		}
		/* address�� tel �� getter/setter ����ʡ�� */

		/**
		 * @return the address
		 */

		public String getAddress() {
			return address;
		}

		/**
		 * @param address
		 *            the address to set
		 */

		public void setAddress(String address) {
			this.address = address;
		}

		/**
		 * @return the tel
		 */

		public String getTel() {
			return tel;
		}

		/**
		 * @param tel
		 *            the tel to set
		 */

		public void setTel(String tel) {
			this.tel = tel;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @return
		 * 
		 * @see java.lang.Object#toString()
		 */

		@Override
		public String toString() {
			return "Home [address=" + address + ", tel=" + tel + "]";
		}

	}
}