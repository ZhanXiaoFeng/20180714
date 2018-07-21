
/**
* @Title: TestTreeSet.java
* @Package com.zrf.ex.bean.test
* @Description: TreeSet
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

import com.zrf.ex.bean.Month;
import com.zrf.ex.bean.Person;

/**
 * @ClassName: TestTreeSet
 * @Description: TreeSet
 * @author ZRF
 * @date 2018��7��19��
 */

public class TestTreeSet {
	@Test
	public void test() {
		// ���ֱȽ�
		Comparator<Person> cr1 = Comparator.comparing(Person::getName);
		// ��߱Ƚ�
		Comparator<Person> cr2 = Comparator.comparing(Person::getHeight);
		// �����·ݱȽ�
		Comparator<Person> cr3 = Comparator.comparing(Person::getMonth);
		Comparator<Person> com = cr1.thenComparing(cr2).thenComparing(cr3);
		TreeSet<Person> set = new TreeSet<>(com);
		Person person = new Person("zhangsan", 165, Month.January);
		set.add(person);
		person = new Person("zhangsan", 166, Month.January);
		set.add(person);
		person = new Person("zhangsan", 166, Month.February);
		set.add(person);
		person = new Person("lisi", 165, Month.March);
		set.add(person);
		person = new Person("lisi", 170, Month.April);
		set.add(person);
		person = new Person("wangwu", 170, Month.March);
		set.add(person);
		person = new Person("wangwu", 170, Month.March);
		set.add(person);
		person = new Person("wangwu", 170, Month.March);
		set.add(person);
		// �õ�һ�������ظ�Ԫ�ص�TreeSet����
		set.forEach(System.out::println);

		List<Person> list = new LinkedList<Person>();
		person = new Person("zhangsan", 166, Month.February);
		list.add(person);
		person = new Person("lisi", 170, Month.April);
		list.add(person);
		person = new Person("wangwu", 170, Month.March);
		list.add(person);
		System.out.println("----------------ceiling-------------------");
		Person ceiling = set.ceiling(new Person("maoao", 170, Month.March));
		System.out.println(ceiling);

		System.out.println("----------------headSet-------------------");
		SortedSet<Person> headSet = set.headSet(ceiling);
		headSet.forEach(System.out::println);

		System.out.println("----------------tailSet-------------------");
		SortedSet<Person> tailSet = set.tailSet(ceiling);
		tailSet.forEach(System.out::println);

	}

}
