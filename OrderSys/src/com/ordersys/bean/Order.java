package com.ordersys.bean;

/**
 * ��װOrder,������Order��ı������������������ֱ����ķ���
 * @author cetc
 *���������ڴ洢������Ϣ�������������š��˿;Ͳ͵����Ӻš����в�Ʒ���
 */
public class Order {
	private int id;
	private int deskId;
	private int foodId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public Order() {
		super();
	}

	public Order(int deskId, int foodId) {
		super();
		this.deskId = deskId;
		this.foodId = foodId;
	}

	public Order(int id, int deskId, int foodId) {
		super();
		this.id = id;
		this.deskId = deskId;
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", deskId=" + deskId + ", foodId=" + foodId
				+ "]";
	}

}
