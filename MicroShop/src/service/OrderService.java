package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	// �½�����
	int insertOrder(Order order);

	// ��ѯ����
	List<Order> selectByPrimaryKey(int orderId);

	// ͨ���û�id��ѯȫ��������¼
	Order selectAllByUserId(int userId);

	// �����²���Ķ���
	Order selectOrderByStatus(int status);

	// ���¶���
	int updateByPrimaryKeySelective(Order order);

	// ������ɾ��
	int deleteByPrimaryKey(int id);

	Order selectOrderById(int orderId);

	// ���ݶ���ID���¶�����״̬
	int updateOrderStatusById(Order order);

	// �鿴���ﳵ
	List<Order> showCartByCustidAndStatus(int orderId);
}
