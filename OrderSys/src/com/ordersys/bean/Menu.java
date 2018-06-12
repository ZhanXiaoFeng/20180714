package com.ordersys.bean;

/**
 * ��װMenu,������Menu��ı������������������ֱ����ķ���
 * @author cetc
 *�˵������ڴ洢��Ʒ�ĸ�����Ϣ����������Ʒ��š����������ۡ�ͼƬ������ �˵������Ψһ�ģ����Ҳ�����������
 */
public class Menu {
	private int id;
	private String name;
	private int price;
	private String img;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Menu() {
		super();
	}

	public Menu(String name, int price, String img) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
	}

	public Menu(int id, String name, int price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price
				+ ", img=" + img + "]";
	}

}
