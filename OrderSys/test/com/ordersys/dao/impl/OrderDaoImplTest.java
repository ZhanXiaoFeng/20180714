package com.ordersys.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ordersys.bean.Order;
import com.ordersys.dao.OrderDao;

public class OrderDaoImplTest {

	private static OrderDao orderDao;

	@BeforeClass
	// ִ��@test֮ǰ����ִ��BeforCalss
	public static void setUpBeforeClass() throws Exception {
		orderDao = new OrderDaoImpl();
	}

	@Test
	public void testInsertOrder() throws SQLException {

		/*
		 * orders.setDeskId(1);// Ϊ�½��Ķ�������ֵ orders.setFoodId(1); int res =
		 * orderDao.insertOrder(order); if (res > 0) {
		 * System.out.println("����ɹ�"); }
		 */
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(1, 2));
		int insertOrderRes = orderDao.insertOrder(orders);
		System.out.println(insertOrderRes);

	}

	@Test
	public void testSelectOrderByDeskId() throws SQLException {
		/*
		 * Order res = orderDao.selectOrderByDeskId(1);
		 * System.out.println(res.getDeskId());
		 * System.out.println(res.getFoodId());
		 */

		List<Order> selectOrderByDeskIdRes = orderDao.selectOrderByDeskId(2);
		for (Order order : selectOrderByDeskIdRes) {
			System.out.println(order);
		}
	}

	@Test
	public void testDeleteOrderByDeskId() throws SQLException {
		int res = orderDao.deleteOrderByDeskId(1);
		if (res > 0) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
		System.out.println(res);
	}

}
