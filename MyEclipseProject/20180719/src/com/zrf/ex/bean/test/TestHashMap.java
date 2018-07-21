
/**
* @Title: TestHashMap.java
* @Package com.zrf.ex.bean.test
* @Description: HashMap
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

import com.zrf.ex.bean.Month;
import com.zrf.ex.bean.Person;
import java.util.Map.Entry;

/**
 * @ClassName: TestHashMap
 * @Description: HashMap
 * @author ZRF
 * @date 2018��7��19��
 */

public class TestHashMap {
	@Test
	public void test() {
		HashMap<String, Person> map = new HashMap<>();
		Person person = new Person("zhangsan", 165, Month.January);
		map.put("001", person);
		person = new Person("zhangsan", 166, Month.January);
		map.put("002", person);
		person = new Person("zhangsan", 166, Month.February);
		map.put("003", person);
		person = new Person("lisi", 165, Month.March);
		map.put("004", person);
		person = new Person("lisi", 170, Month.April);
		map.put("005", person);
		person = new Person("wangwu", 170, Month.March);
		map.put("006", person);

		// ������1�������� 2������ֵ ��a)�ɼ�ȡֵ��b)��ȡ���е�ֵ 3����������ֵ
		Set<String> set = map.keySet();
		set.forEach(System.out::println);

		// �ɼ�ȡֵ
		System.out.println("************************************");
		set.forEach(s -> System.out.println(map.get(s)));
		// ȡ������ֵ
		System.out.println("************************************");
		map.values().forEach(System.out::println);

		// ȡ�����еļ���ֵ
		System.out.println("************************************");
		Set<Entry<String, Person>> entrySet = map.entrySet();
		entrySet.forEach(entry -> System.out.println(entry.getKey() + "\t" + entry.getValue()));

		System.out.println("**************Delete****************");
		map.remove("006");
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "\t" + entry.getValue()));
	}

}
