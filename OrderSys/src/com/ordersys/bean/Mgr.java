package com.ordersys.bean;

/**
 * ��װMgr,������Mgr��ı������������������ֱ����ķ���
 * @author cetc
 *����Ա����������Ա��š�����������
 */
public class Mgr {
	private int id;
	private String name;
	private String pwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Mgr() {
		super();
	}

	public Mgr(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Mgr(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Mgr [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}

}
