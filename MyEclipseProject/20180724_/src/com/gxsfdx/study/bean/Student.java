
/**
* @Title: Student.java
* @Package com.gxsfdx.study.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��24��
* @version V1.0  
*/

package com.gxsfdx.study.bean;

/**
 * @ClassName: Student
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��7��24��
 */

public class Student {
	private String name;
	private double height;
	private boolean sex;

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

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Student() {
		super();
	}

	public Student(String name, double height, boolean sex) {
		super();
		this.name = name;
		this.height = height;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", height=" + height + ", sex=" + sex + "]";
	}

}
