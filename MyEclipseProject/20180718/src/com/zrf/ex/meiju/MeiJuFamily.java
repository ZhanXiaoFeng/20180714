
/**
* @Title: MeiJu.java
* @Package com.zrf.ex.meiju
* @Description: ö��ʹ��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.meiju;

/**
 * @ClassName: MeiJu
 * @Description: ö��ʹ��_�汾��
 * @author ZRF
 * @date 2018��7��18��
 */

public enum MeiJuFamily {
	// ����ʹ�õ����캯��
	NUMBER_OF_FAMILY(5);
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	// ע��˴�Ϊprivate����
	private MeiJuFamily(int value) {
		this.value = value;
	}
}
