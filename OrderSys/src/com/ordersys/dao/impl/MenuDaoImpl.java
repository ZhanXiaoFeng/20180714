package com.ordersys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ordersys.bean.Menu;
import com.ordersys.bean.Order;
import com.ordersys.dao.MenuDao;
import com.ordersys.utils.Constant;
import com.ordersys.utils.MySQLTool;

/**
 * MenuDao�ӿ��µľ���ʵ����
 * 
 * @author ZRF
 *
 */
public class MenuDaoImpl implements MenuDao {

	@Override
	// �����Ʒ
	public int insertMenu(Menu menu) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "insert into tb_menu values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, menu.getId());
		ps.setString(2, menu.getName());
		ps.setInt(3, menu.getPrice());
		ps.setString(4, menu.getImg());
		int res = ps.executeUpdate();
		MySQLTool.free(ps, conn);
		return res;
	}

	@Override
	// ���²�Ʒ����
	public int updateMenu(Menu menu) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "update tb_menu set name = ? , price = ? ,img = ? where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, menu.getName());
		ps.setInt(2, menu.getPrice());
		ps.setString(3, menu.getImg());
		ps.setInt(4, menu.getId());
		int res = ps.executeUpdate();
		MySQLTool.free(ps, conn);
		return res;
	}

	@Override
	// ���²�Ʒ����
	public int updateMenuOnPriceWithId(int price, int id) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "update tb_menu set price=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, price);
		ps.setInt(2, id);
		int res = ps.executeUpdate();
		MySQLTool.free(ps, conn);
		return res;
	}

	@Override
	// ͨ��idɾ����Ʒ
	public int deleteMenuById(int menuId) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "delete from tb_menu where id= ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, menuId);
		int res = ps.executeUpdate();
		MySQLTool.free(ps, conn);
		return res;
	}

	@Override
	// ͨ����Ʒid��ѯ�˵�
	public Menu selectMenuById(int menuId) throws SQLException {
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_menu where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, menuId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String name = rs.getString("name");
			int price = rs.getInt("price");
			String img = rs.getString("img");
			return new Menu(menuId, name, price, img);
		}
		MySQLTool.free(rs, ps, conn);
		return null;
	}

	@Override
	// ͨ����Ʒid��ѯ�˵�
	public List<Menu> selectAllMenus() throws SQLException {
		List<Menu> res = new ArrayList<Menu>();
		Connection conn = MySQLTool.getConnection();
		java.sql.Statement stmt = conn.createStatement();
		String sql = "select * from tb_menu";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Menu menu = new Menu(rs.getInt("id"), rs.getString("name"),
					rs.getInt("price"), rs.getString("img"));
			res.add(menu);
		}
		MySQLTool.free(rs, stmt, conn);
		return res;
	}

	@Override
	// ͨ�����ӺŻ�ȡ�������ܼ�
	public int getToalPriceWithDesk(List<Order> orders) throws SQLException {
		int totalPrice = 0;
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_menu where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = null;
		for (Order order : orders) {
			ps.setInt(1, order.getFoodId());
			rs = ps.executeQuery();
			if (rs.next()) {
				totalPrice += rs.getInt("price");
			}
		}
		MySQLTool.free(rs, ps, conn);
		return totalPrice;
	}

	@Override
	public int selectCount() throws SQLException {
		Connection conn = MySQLTool.getConnection();

		String sql = "select count(*) cc from tb_menu";
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getInt("cc");
		MySQLTool.free(rs, ps, conn);
		return -1;
	}

	@Override
	// ͨ����ҳpageNum��ѯ�˵�
	public List<Menu> selectMenusByPageNum(int pageNum) throws SQLException {
		List<Menu> res = new ArrayList<Menu>();
		Connection conn = MySQLTool.getConnection();
		String sql = "select * from tb_menu limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, (pageNum - 1) * Constant.PAGE_SIZE);
		ps.setInt(2, Constant.PAGE_SIZE);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Menu menu = new Menu(rs.getInt("id"), rs.getString("name"),
					rs.getInt("price"), rs.getString("img"));
			res.add(menu);
		}
		MySQLTool.free(rs, ps, conn);
		return res;
	}
}
