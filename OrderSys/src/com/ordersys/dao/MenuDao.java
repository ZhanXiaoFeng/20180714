package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Menu;
import com.ordersys.bean.Order;

public interface MenuDao {
	/**
	 * �����Ʒ
	 * @param menu
	 * @return �˵�
	 * @throws SQLException
	 */
	int insertMenu(Menu menu) throws SQLException;  

	/**
	 * ���²�Ʒ����
	 * @param menu
	 * @return �˵�
	 * @throws SQLException
	 */
	int updateMenu(Menu menu) throws SQLException;  

	/**
	 * ͨ����Ʒ��Ÿ��¼۸�
	 * @param price
	 * @param id
	 * @return id and price
	 * @throws SQLException
	 */
	int updateMenuOnPriceWithId(int price,int id) throws SQLException;  
	
	/**
	 * ͨ��idɾ����Ʒ
	 * @param menuId
	 * @return  menuId
	 * @throws SQLException
	 */
	int deleteMenuById(int menuId) throws SQLException;  

	/**
	 * ͨ����Ʒid��ѯ�˵�
	 * @param menuId
	 * @return menuId
	 * @throws SQLException
	 */
	Menu selectMenuById(int menuId) throws SQLException; 

	/**
	 * ��ѯ���в�Ʒ
	 * @return ���в�Ʒ
	 * @throws SQLException
	 */
	List<Menu> selectAllMenus() throws SQLException;  
	
	/**
	 * ͨ�����ӺŻ�ȡ�������ܼ� 
	 * @param orders
	 * @return order
	 * @throws SQLException
	 */
	int getToalPriceWithDesk(List<Order> orders) throws SQLException; 
	
	/**
	 * ͨ����ҳpageNum��ѯ�˵�
	 * @param pageNum
	 * @return pageNum
	 * @throws SQLException
	 */
	List<Menu> selectMenusByPageNum(int pageNum) throws SQLException;
	
	/**
	 * ��ѯ�˵��в�Ʒ��������
	 * @return
	 * @throws SQLException
	 */
	int selectCount() throws SQLException;
}
