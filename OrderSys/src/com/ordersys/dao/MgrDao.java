package com.ordersys.dao;

import java.sql.SQLException;

import com.ordersys.bean.Mgr;

public interface MgrDao {
	
	/**
	 * ����Ա��¼
	 * @param name
	 * @param pwd
	 * @return 
	 * @throws SQLException
	 */
	Mgr selectMgrByNameAndPwd(String name, String pwd) throws SQLException;

}
