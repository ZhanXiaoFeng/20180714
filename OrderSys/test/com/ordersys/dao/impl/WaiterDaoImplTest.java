package com.ordersys.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ordersys.bean.Waiter;
import com.ordersys.dao.WaiterDao;
import com.ordersys.dao.impl.WaiterDaoImpl;

public class WaiterDaoImplTest {

	private static WaiterDao waiterDao;// ���࿪ʼִ��֮ǰ����һ��WaiterDao�Ķ���

	@BeforeClass
	public static void Init() {
		waiterDao = new WaiterDaoImpl();// ��WaiterDaoImplʵ��Waiter
	}

	@Test
	// ��Ԫ����
	public void testInsertWaiter() throws SQLException {
		Waiter waiter = new Waiter(1, "zhangsan", "1234");// ����һ��Waiter����
		int insertWaiterRes = waiterDao.insertWaiter(waiter);// �����������뵽tb_waiter�в���ִ�н�����ظ�һ��int�Ͷ���
		System.out.println(insertWaiterRes);// ���ִ�в�������Ľ��
	}

	@Test
	public void testDeleteWaiterById() throws SQLException {
		int deleteWaiterByIdRes = waiterDao.deleteWaiterById(1);// ɾ������
		System.out.println(deleteWaiterByIdRes);// ���ɾ�������Ľ��
	}

	@Test
	public void testSelectWaiterByNameAndPwd() throws SQLException {
		Waiter selectWaiterByNameAndPwdRes = waiterDao
				.selectWaiterByNameAndPwd("zhangsan", "1234");// ͨ������������ִ�в�ѯ����
		System.out.println(selectWaiterByNameAndPwdRes);// �����ѯ�����Ľ��

	}

	@Test
	public void testSelectAllWaiter() throws SQLException {
		List<Waiter> res = waiterDao.selectAllWaiter();// ����һ�������� ������Waiter
		for (Waiter waiter : res) {
			System.out.println(waiter);// ���������ѯ��������
		}
	}

}
