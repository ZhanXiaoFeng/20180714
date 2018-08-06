
/**
* @Title: DbUtil.java
* @Package com.zrf.skydrive.utils
* @Description: ���ݿ�����
* @author ZRF
* @date 2018��8��6��
* @version V1.0  
*/

package com.zrf.skydrive.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: DbUtil
 * @Description: ���ݿ����Ӽ���¼��֤
 * @author ZRF
 * @date 2018��8��6��
 */

public class DbUtil {
	private Connection connection;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hadoop?user=root&password=root");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

	private Statement sm = null;

	private Connection conn = null;

	private ResultSet rs = null;

	public void close() {
		try {

			if (sm != null) {
				sm.close();
				sm = null;
			}

			if (conn != null) {
				conn.close();
				sm = null;
			}

			if (rs != null) {
				rs.close();
				sm = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkUser(String user, String password) {
		boolean b = false;

		try {
			// �������
			conn = new DbUtil().getConnection();
			// ����statement
			sm = conn.createStatement();

			rs = sm.executeQuery("select * from tb_user where username=\"" + user + "\"");

			if (rs.next()) {
				// ˵�����û�����
				String pwd = rs.getString(3);
				// System.out.println(pwd);
				if (password.equals(pwd)) {
					// ˵��������ȷ
					b = true;
				} else {
					b = false;
				}
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}
}
