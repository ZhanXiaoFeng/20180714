
/**
* @Title: TestMonth.java
* @Package com.zrf.ex.meiju.test
* @Description: �����·�ö��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.meiju.test;

import org.junit.Test;

import com.zrf.ex.meiju.Month;

/**
 * @ClassName: TestMonth
 * @Description: �����·�ö��
 * @author ZRF
 * @date 2018��7��18��
 */

public class TestMonth {
	@Test
	public void test() {
		System.out.println(Month.January);
		System.out.println(Month.January.getChinese());
		System.out.println(Month.January.getEnglish());
		System.out.println(Month.January.getSimple());
	}

}
