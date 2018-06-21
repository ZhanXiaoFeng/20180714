
/**  
* @Title: Salary.java
* @Package demo14.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo14.bean;

import java.io.Serializable;

/**
 * @ClassName: Salary
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��21��
 */

public class Salary implements Serializable {
	private static final long serialVersionUID = 44663L;
	// ��������
	private int basePay;
	// ��Ч����
	private int bonus;

	public Salary(int _basePay, int _bonus) {
		basePay = _basePay;
		bonus = _bonus;
	}

	/**
	 * @return the basePay
	 */

	public int getBasePay() {
		return basePay;
	}

	/**
	 * @param basePay
	 *            the basePay to set
	 */

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	/**
	 * @return the bonus
	 */

	public int getBonus() {
		return bonus;
	}

	/**
	 * @param bonus
	 *            the bonus to set
	 */

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
