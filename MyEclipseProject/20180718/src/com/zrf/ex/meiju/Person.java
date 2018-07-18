
/**
* @Title: Person.java
* @Package com.zrf.ex.meiju
* @Description: ����Person��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.meiju;

/**
 * @ClassName: Person
 * @Description: ����Person��
 * @author ZRF
 * @date 2018��7��18��
 */

public class Person {
	String name;
	Sex sex;
	Month month;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
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

	public Person(String name, Sex sex, Month month) {
		super();
		this.name = name;
		this.sex = sex;
		this.month = month;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", month=" + month + "]";
	}
}
