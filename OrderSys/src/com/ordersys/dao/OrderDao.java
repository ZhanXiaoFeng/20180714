package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Order;

public interface OrderDao {

	/**
	 * ����һ������
	 * @param orders
	 * @return
	 * @throws SQLException
	 */
	int insertOrder(List<Order> orders) throws SQLException;
	
	/**
	 * ͨ������id��ѯ����
	 * @param deskId
	 * @return
	 * @throws SQLException
	 */
	List<Order> selectOrderByDeskId(int deskId) throws SQLException;

	/**
	 * ͨ������idɾ������
	 * @param deskId
	 * @return
	 * @throws SQLException
	 */
	int deleteOrderByDeskId(int deskId) throws SQLException;

}
