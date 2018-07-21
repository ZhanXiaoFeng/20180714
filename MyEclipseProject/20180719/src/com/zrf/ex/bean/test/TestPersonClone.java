
/**
* @Title: TestPersonClone.java
* @Package com.zrf.ex.bean.test
* @Description:  ǳ��¡�����¡
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import org.junit.Test;
import com.zrf.ex.bean.Month;
import com.zrf.ex.bean.Person;
import com.zrf.ex.bean.PersonClone;

/**
 * @ClassName: TestPersonClone
 * @Description: ǳ��¡�����¡
 * @author ZRF
 * @date 2018��7��19��
 */

public class TestPersonClone {
	@Test
	public void testClone() {
		System.out.println("-------------ǳ��¡----------------");
		long nanoTimeStart = System.nanoTime();
		Person person = new Person("rongrong", 185, Month.May);
		System.out.println("ǳ��¡����ʱ�䣺" + (System.nanoTime() - nanoTimeStart) + "����");
		// ����ǳ��¡����
		Person p1 = person.clone();
		p1.add(4);
		p1.add(5);
		System.out.println("ԭlistԪ��");
		person.printList();
		System.out.println("-----------------------------");
		System.out.println("��listԪ��");
		p1.printList();

		System.out.println("-------------�������¡----------------");
		person = new Person("rongrong", 180, Month.May);
		// ���ô������¡����
		nanoTimeStart = System.nanoTime();
		Person p2 = PersonClone.deepClone(person);
		System.out.println("�������¡����ʱ�䣺" + (System.nanoTime() - nanoTimeStart) + "����");
		p2.add(4);
		p2.add(5);
		System.out.println("ԭlistԪ��");
		person.printList();
		System.out.println("-----------------------------");
		System.out.println("��listԪ��");
		p2.printList();

		System.out.println("-------------�ڴ����¡----------------");
		nanoTimeStart = System.nanoTime();
		person = new Person("rongrong", 175, Month.May);
		System.out.println("�ڴ����¡����ʱ�䣺" + (System.nanoTime() - nanoTimeStart) + "����");
		// �����ڴ����¡����
		Person p3 = PersonClone.deepCloneMemory(person);
		p3.add(4);
		p3.add(5);
		System.out.println("ԭlistԪ��");
		person.printList();
		System.out.println("-----------------------------");
		System.out.println("��listԪ��");
		p3.printList();
	}
}
