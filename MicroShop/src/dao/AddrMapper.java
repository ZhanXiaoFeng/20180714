package dao;

import java.util.List;

import entity.Addr;

/**
 * ��ַ��Ϣ�ӿ�
 * 
 * @author CETC
 *
 */
public interface AddrMapper {

	// ��ӵ�ַ��Ϣ
	public int insert(Addr addr);

	// ͨ���˿�ID��ѯ��ַ
	Addr selectByCustomerId(int customerId);

	// ������ӵ�ַ��Ϣ
	int insertCondition(Addr addr);

	// ͨ��id��ѯ��ַ��Ϣ
	Addr selectById(int id);

	// ��ѯ���е�ַ��Ϣ
	List<Addr> selectAll();

	// �������µ�ַ��Ϣ
	int updateByCondition(Addr addr);

	// ɾ����ַ��Ϣ
	int deleteById(int id);
}