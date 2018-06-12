package com.ordersys.dao;

import java.sql.SQLException;
import java.util.List;
import com.ordersys.bean.Desk;

public interface DeskDao {
	
	/**
	 * ָ�����Ӻ�
	 * @param desk
	 * @return desk
	 * @throws SQLException
	 */
	int insertDesk(Desk desk) throws SQLException; 
 
	/**
	 * �������Ӻ�
	 * @param desk
	 * @return desk
	 * @throws SQLException
	 */
	int updateDesk(Desk desk) throws SQLException;  
	
	/**
	 * ��ѯ���Ӻ�
	 * @param deskId
	 * @return ���Ӻŵ�id
	 * @throws SQLException
	 */
	Desk selectDesk(int deskId) throws SQLException; 

	/**
	 * ������������
	 * @return 
	 * @throws SQLException
	 */
	List<Desk> selectAllDesks() throws SQLException; 
	
	/**
	 * �������п���
	 * @return
	 * @throws SQLException
	 */
	List<Desk> selectAllNotSelectedDesks() throws SQLException; 
	
	/**
	 * ���������ѱ�ʹ�õ�����
	 * @return
	 * @throws SQLException
	 */
	List<Desk> selectAllHaveSelectedDesks() throws SQLException; 

}
