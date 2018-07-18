
/**
* @Title: TestPerson.java
* @Package com.zrf.ex.meiju.test
* @Description: ����ʹ��Person��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.meiju.test;

import org.junit.Test;

import com.zrf.ex.meiju.Month;
import com.zrf.ex.meiju.Person;
import com.zrf.ex.meiju.Sex;

/**
 * @ClassName: TestPerson
 * @Description: ����ʹ��Person��
 * @author ZRF
 * @date 2018��7��18��
 */

public class TestPerson {
	@Test
	public void test() {
		Person person = new Person("zhangsan", Sex.MALE, Month.January);
		person.setName("lisi");
		person.setSex(Sex.MALE);
		person.setMonth(Month.January);
		System.out.println(person);
	}
}
