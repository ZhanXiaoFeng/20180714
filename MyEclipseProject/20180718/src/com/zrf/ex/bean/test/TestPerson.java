
/**
* @Title: TestPerson.java
* @Package com.zrf.ex.bean.test
* @Description: Person�����
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.zrf.ex.bean.Person;
import com.zrf.ex.meiju.Month;

/**
 * @ClassName: TestPerson
 * @Description: Person�����
 * @author ZRF
 * @date 2018��7��18��
 */

public class TestPerson {
	@Test
	public void test() {
		List<Person> list = new LinkedList<>();
		Person person = new Person("zhangsan", 165, Month.January);
		list.add(person);
		person = new Person("zhangsan", 166, Month.January);
		list.add(person);
		person = new Person("zhangsan", 166, Month.February);
		list.add(person);
		person = new Person("lisi", 165, Month.March);
		list.add(person);
		person = new Person("lisi", 170, Month.April);
		list.add(person);
		person = new Person("wangwu", 170, Month.March);
		list.add(person);
		// ���ֱȽ�
		Comparator<Person> cr1 = Comparator.comparing(Person::getName);
		// ��߱Ƚ�
		Comparator<Person> cr2 = Comparator.comparing(Person::getHeight);
		cr2 = cr2.reversed();// �ԱȽϽ�����з�ת
		// �����·ݱȽϲ����з�ת
		Comparator<Person> cr3 = Comparator.comparing(Person::getMonth).reversed();
		// ��������
		list.sort(cr1.thenComparing(cr2).thenComparing(cr3));
		// ���������
		list.forEach(System.out::println);
	}
}
