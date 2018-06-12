package com.ordersys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ordersys.bean.Order;
import com.ordersys.dao.OrderDao;
import com.ordersys.utils.MySQLTool;

/**
 * Order�ӿڵľ���ʵ���෽��
 * @author ZRF
 *
 */
public class OrderDaoImpl implements OrderDao {

	@Override  //����һ������
	public int insertOrder(List<Order> orders) throws SQLException {
		Connection conn = MySQLTool.getConnection();// ����һ�����Ӷ���
		// �ر��Զ��ύ����
		conn.setAutoCommit(false);
		// ִ��sql���
		String sql = "insert into tb_order(deskid,foodid) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (Order order : orders) {
			ps.setInt(1, order.getDeskId());
			ps.setInt(2, order.getFoodId());
			ps.addBatch();// ������
		}
		try {
			ps.executeBatch();
		} catch (Exception e) {
			// ���ִ�в��ɹ���ع�����
			conn.rollback();
			e.printStackTrace();
			return 0;
		}
		// �ύ����
		conn.commit();
		// ���������û�Ĭ��״̬
		conn.setAutoCommit(true);
		// �ͷ���Դ
		MySQLTool.free(ps, conn);
		return 1;
	}

	/**
	 * ���ݲ�����id��deskId����ѯ��Ӧ����
	 */
	@Override
	public List<Order> selectOrderByDeskId(int deskId) throws SQLException {
		List<Order> res = new ArrayList<Order>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_order where deskId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, deskId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {// �����Ϊ�շ���һ������
			res.add(new Order(rs.getInt("deskid"), rs.getInt("foodid")));
		}
		MySQLTool.free(rs, ps, conn);// �ͷ���Դ
		return res;
	}

	/**
	 * �����˽���֮����ݶ�Ӧ�Ķ������ҵ���������������ݿ���ɾ��
	 */
	@Override
	public int deleteOrderByDeskId(int deskId) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "delete from tb_order where deskid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, deskId);
		int res = ps.executeUpdate();
		MySQLTool.free(ps, conn);
		return res;
	}
}
