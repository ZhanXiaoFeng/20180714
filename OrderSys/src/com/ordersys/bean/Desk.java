package com.ordersys.bean;

/**
 *  ��װDesk,������Desk��ı������������������ֱ����ķ���
 * @author cetc
 * ���ӱ����ڴ洢���Ӻţ���Ӧ���ӺŵĹ˿����ѵ��ܼۣ�Ϊ�����ӷ���ķ���Ա�ı��
 */
public class Desk {
	private int id;
	private int waiterId;
	private int totalPrice;
	private boolean pay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

	public Desk(int id, int waiterId, int totalPrice, boolean pay) {
		super();
		this.id = id;
		this.waiterId = waiterId;
		this.totalPrice = totalPrice;
		this.pay = pay;
	}

	public Desk(int waiterId, int totalPrice, boolean pay) {
		super();
		this.waiterId = waiterId;
		this.totalPrice = totalPrice;
		this.pay = pay;
	}

	public Desk() {
		super();

	}

	@Override
	public String toString() {
		return "Desk [id=" + id + ", waiterId=" + waiterId + ", totalPrice="
				+ totalPrice + ", pay=" + pay + "]";
	}

}
