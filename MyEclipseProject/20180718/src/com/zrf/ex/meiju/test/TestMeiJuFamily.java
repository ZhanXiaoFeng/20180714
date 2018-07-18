
/**
* @Title: TestMeiJuFamily.java
* @Package com.zrf.ex.meiju.test
* @Description: ����ö�ٵ�ʹ��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.meiju.test;

import org.junit.Test;
import com.zrf.ex.meiju.MeiJuFamily;

/**
 * @ClassName: TestMeiJuFamily
 * @Description: ����ö�ٵ�ʹ��
 * @author ZRF
 * @date 2018��7��18��
 */

public class TestMeiJuFamily {
	@Test
	public void test() {
		int value = MeiJuFamily.NUMBER_OF_FAMILY.getValue();
		System.out.println("Family of SUM:" + value + "��");

		// ��ö�ٳ�ʼֵ�����޸�
		MeiJuFamily.NUMBER_OF_FAMILY.setValue(6);
		int value1 = MeiJuFamily.NUMBER_OF_FAMILY.getValue();
		System.out.println("Family of SUM:" + value1 + "��");
	}
}
