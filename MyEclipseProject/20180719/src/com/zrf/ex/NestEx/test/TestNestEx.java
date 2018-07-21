
/**
* @Title: TestNestEx.java
* @Package com.zrf.ex.NestEx.test
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.NestEx.test;

import org.junit.Test;

import com.zrf.ex.NestEx.NestEx;
import com.zrf.ex.NestEx.NestEx.Nest;
import com.zrf.ex.NestEx.NestEx.StaticNest;

/**
 * @ClassName: TestNestEx
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��7��19��
 */

public class TestNestEx {
	@Test
	public void test() {
		/******************�汾һ********************/
		 /* 
		NestEx nestEx = new NestEx();
		NestEx.Nest nest = nestEx.new Nest();
		nest.say("Hello");
		
		NestEx.StaticNest staticNest = new NestEx.StaticNest();
		staticNest.play();
		*/
		NestEx nestEx = new NestEx();
		Nest nest = nestEx.new Nest();
		nest.say("Hello");

		StaticNest staticNest = new StaticNest();
		staticNest.play();
	}
}
