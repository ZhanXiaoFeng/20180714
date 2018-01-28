package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * ������tb_order��
 * 
 * @author CETC
 *
 */

public class Order {
	// ���
	private int id;
	// ����״̬
	private int status;
	// �����۸�
	private float price;
	// ���ʽ
	private String paymethod;
	// �ջ���ַid
	private int addrId;
	// �˿�id
	private int customerId;
	// �˿���Ϣ
	private Customer customer;
	// �˿͵�ַ��Ϣ
	private Addr addrs;
	// ��������ϸ��Ϣ
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Addr getAddrs() {
		return addrs;
	}
	public void setAddrs(Addr addrs) {
		this.addrs = addrs;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Order(int id, int status, float price, String paymethod, int addrId, int customerId, Customer customer,
			Addr addrs, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.status = status;
		this.price = price;
		this.paymethod = paymethod;
		this.addrId = addrId;
		this.customerId = customerId;
		this.customer = customer;
		this.addrs = addrs;
		this.orderItems = orderItems;
	}
	public Order() {
		super();
	}
	public Order(int id, int status, float price, String paymethod, int addrId, int customerId) {
		super();
		this.id = id;
		this.status = status;
		this.price = price;
		this.paymethod = paymethod;
		this.addrId = addrId;
		this.customerId = customerId;
	}
	public Order(int status, float price, String paymethod, int addrId, int customerId, Customer customer, Addr addrs,
			List<OrderItem> orderItems) {
		super();
		this.status = status;
		this.price = price;
		this.paymethod = paymethod;
		this.addrId = addrId;
		this.customerId = customerId;
		this.customer = customer;
		this.addrs = addrs;
		this.orderItems = orderItems;
	}
	public Order(int status, float price, String paymethod, int addrId, int customerId) {
		super();
		this.status = status;
		this.price = price;
		this.paymethod = paymethod;
		this.addrId = addrId;
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", price=" + price + ", paymethod=" + paymethod + ", addrId="
				+ addrId + ", customerId=" + customerId + ", customer=" + customer + ", addrs=" + addrs
				+ ", orderItems=" + orderItems + "]";
	}

}