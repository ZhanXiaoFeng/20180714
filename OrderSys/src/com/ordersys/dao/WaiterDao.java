package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Waiter;

public interface WaiterDao {

	/**
	 * �������Ա 
	 * @param waiter
	 * @return
	 * @throws SQLException
	 */
	int insertWaiter(Waiter waiter) throws SQLException;

	/**
	 * ͨ������Աidɾ������Ա
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int deleteWaiterById(int id) throws SQLException; 

	/**
	 * ͨ������Ա���ֺ������ѯ����Ա
	 * @param name
	 * @param pwd
	 * @return
	 * @throws SQLException
	 */
	Waiter selectWaiterByNameAndPwd(String name, String pwd)
			throws SQLException;
	
	/**
	 * ��ѯ���з���Ա
	 * @return
	 * @throws SQLException
	 */
	List<Waiter> selectAllWaiter() throws SQLException;
	
	/**
	 * ͨ����ҳpageNum��ѯ���з���Ա
	 * @param pageNum
	 * @return
	 * @throws SQLException
	 */
	List<Waiter> selectWaitersByPageNum(int pageNum) throws SQLException;
	
	/**
	 * ��ѯϵͳ�з���Ա���ܼ�¼��
	 * @return
	 * @throws SQLException
	 */
	int selectCount() throws SQLException;

}
