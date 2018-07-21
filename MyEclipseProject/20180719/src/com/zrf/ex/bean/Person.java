
/**
* @Title: Person.java
* @Package com.zrf.ex.bean
* @Description: ����Person��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: Person
 * @Description: ����Person��
 * @author ZRF
 * @date 2018��7��18��
 */
/**************************** �̳�ʵ�� *******************************/
// Cloneable��ʵ��ǳ��¡ Serializable��ʵ�����¡
public class Person implements Comparable<Person>, Cloneable, Serializable {
	/**
	 * @Fields :serialVersionUID
	 */
	private static final long serialVersionUID = 1461713549179147990L;
	private String name;
	private double height;
	private Month month;

	// ֤����ǳ��¡������
	private List<Integer> list;
	{
		list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 4));
	}

	// ��list���������Ԫ��
	public void add(int i) {
		list.add(i);
	}

	// ���listԪ��
	public void printList() {
		list.forEach(System.out::println);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Person() {
		super();
	}

	public Person(String name, double height, Month month) {
		super();
		this.name = name;
		this.height = height;
		this.month = month;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", month=" + month + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// ʹ��set���ϱ��빹��hashCode()��equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (month != other.month)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person p) {
		/*
		 * this,p ���һ��Comparator,Ȼ�����compare(,)
		 */
		// ���ֱȽ�
		Comparator<Person> cr1 = Comparator.comparing(Person::getName);
		// ��߱Ƚ�
		Comparator<Person> cr2 = Comparator.comparing(Person::getHeight);
		// �����·ݱȽ�
		Comparator<Person> cr3 = Comparator.comparing(Person::getMonth);
		Comparator<Person> com = cr1.thenComparing(cr2).thenComparing(cr3);
		return com.compare(this, p);
	}

	/*
	 * int i= this.getName().compareTo(p.getName());
	 * 
	 * if(i==0){ double d=this.getHeight()-p.getHeight();
	 * 
	 * if(d==0){ i=this.getMonth().ordinal()-p.getMonth().ordinal(); }else
	 * if(d>0){ i=1; }else{ i=-1; }
	 * 
	 * 
	 * } return i;
	 */
	@Override // ǳ��¡
	public Person clone() {
		try {
			return (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
