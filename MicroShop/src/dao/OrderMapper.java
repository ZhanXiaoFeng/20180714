package dao;

import java.util.List;

import entity.Order;

/**
 * ������
 * 
 * @author CETC
 *
 */
public interface OrderMapper {
	// �½�����
	int insertOrder(Order order);

	// �����½�����
	int insertCondition(Order order);

	// �����²���Ķ���
	Order selectOrderByStatus(int status);

	// ͨ������id��ѯ���ֶ�����¼
	List<Order> selectByPrimaryKey(int id);

	// ͨ���û�id��ѯȫ��������¼
	Order selectAllByUserId(int id);

	// �������¶�����¼
	int updateByPrimaryKeySelective(Order order);

	// ������ɾ����15�����ڶ���δ��������Զ�ȡ����
	int deleteByPrimaryKey(int id);
	
	Order selectOrderById(int orderId);

	// ���ݶ���ID���¶�����״̬
	int updateOrderStatusById(Order order);
	
	//�鿴���ﳵ
	List<Order> showCartByCustidAndStatus(int orderId);
}