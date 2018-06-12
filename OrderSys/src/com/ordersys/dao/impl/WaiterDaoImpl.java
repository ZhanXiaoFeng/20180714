package com.ordersys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ordersys.bean.Waiter;
import com.ordersys.dao.WaiterDao;
import com.ordersys.utils.Constant;
import com.ordersys.utils.DesUtils;
import com.ordersys.utils.MySQLTool;

/**
 * WaiterDao�ӿڵľ���ʵ����
 * 
 * @author ZRF
 *
 */
public class WaiterDaoImpl implements WaiterDao {

	@Override
	// �������Ա
	public int insertWaiter(Waiter waiter) throws SQLException {
		Connection conn = MySQLTool.getConnection();// ��������
		String sql = "insert into tb_waiter(id,name,pwd) values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);// ����statement����
		ps.setInt(1, waiter.getId()); // ��sql������
		ps.setString(2, waiter.getName());// ����sql���
		String pwd = null;
		try {
			DesUtils des = new DesUtils("123456");
			pwd = des.encrypt(waiter.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps.setString(3,pwd);// ����sql���
		int res = ps.executeUpdate();// ִ�и��²���
		MySQLTool.free(ps, conn);// �ͷ���Դ
		return res;
	}

	@Override
	// ͨ������Աidɾ������Ա
	public int deleteWaiterById(int id) throws SQLException {
		Connection conn = MySQLTool.getConnection();// ��������
		String sql = "delete from tb_waiter where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);// ����statement����
		ps.setInt(1, id);// ����sql���
		int res = ps.executeUpdate();// ִ�и��²���
		MySQLTool.free(ps, conn);// �ͷ���Դ
		return res;
	}

	@Override
	// ͨ������Ա���ֺ������ѯ����Ա
	public Waiter selectWaiterByNameAndPwd(String name, String pwd)
			throws SQLException {
		Connection conn = MySQLTool.getConnection();// ��������
		String sql = "select *  from tb_waiter where name=? and pwd=?";//
		PreparedStatement ps = conn.prepareStatement(sql);// ����statement����,����sql���
		ps.setString(1, name);
		try {
			DesUtils des = new DesUtils("123456");
			pwd = des.encrypt(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps.setString(2, pwd);// ����sql���
		ResultSet rs = ps.executeQuery();// ��ȡ��ǰsql����ѯ����Waiter����
		while (rs.next()) {
			return new Waiter(rs.getInt("id"), rs.getString("name"),
					rs.getString("pwd"));// ��rs��ȡ����Waiter�����id
											// name,pwd���ø��µ�Waiter����
		}
		MySQLTool.free(rs, ps, conn);// �ͷ���Դ
		return null;
	}

	@Override
	// ��ѯ���з���Ա
	public List<Waiter> selectAllWaiter() throws SQLException {
		List<Waiter> res = new ArrayList<Waiter>();// ����һ��Waiter���͵�����
		Connection conn = MySQLTool.getConnection();// ��������
		Statement stmt = conn.createStatement();// ����statement����
		String sql = "select * from tb_waiter";//
		ResultSet rs = stmt.executeQuery(sql);// ��ȡ��ǰ��ѯ����Waiter����
		while (rs.next()) {// ѭ������
			Waiter waiter = new Waiter(rs.getInt("id"), rs.getString("name"),
					rs.getString("pwd"));// ��rs��ȡ����Waiter����� id name
											// pwd���ø��µ�Waiter����
			res.add(waiter);// ���������úõ�Waiter������ӵ�����res��
		}
		MySQLTool.free(rs, stmt, conn);// �ͷ���Դ
		return res;// ��������res
	}

	@Override
	// ͨ����ҳpageNum��ѯ���з���Ա
	public List<Waiter> selectWaitersByPageNum(int pageNum) throws SQLException {
		List<Waiter> res = new ArrayList<Waiter>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_waiter limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNum - 1) * Constant.PAGE_SIZE);
		ps.setInt(2, Constant.PAGE_SIZE);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Waiter waiter = new Waiter(rs.getInt("id"), rs.getString("name"),
					rs.getString("pwd"));

			res.add(waiter);
		}
		MySQLTool.free(rs, ps, conn);
		return res;
	}

	@Override
	// ��ѯϵͳ�з���Ա���ܼ�¼��
	public int selectCount() throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "select count(*) cc from tb_waiter";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getInt("cc");
		MySQLTool.free(rs, ps, conn);
		return -1;
	}
}
