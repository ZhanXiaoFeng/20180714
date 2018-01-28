package service;

import java.util.List;

import entity.Addr;

/**
 * AddrService�����
 * 
 * @author CETC
 *
 */
public interface AddrService {
	// ��ӵ�ַ��Ϣ
	int insert(Addr addr);
	//ͨ���˿�ID��ѯ��ַ
	Addr selectByCustomerId(int customerId);

	// ������ӵ�ַ��Ϣ
	int insertCondition(Addr addr);

	// ͨ��id��ѯ��ַ��Ϣ
	Addr selectById(int id);

	// ������ѯ��ַ��Ϣ
	List<Addr> selectAll();

	// �������µ�ַ��Ϣ
	int updateByCondition(Addr addr);

	// ɾ����ַ��Ϣ
	int deleteById(int id);
}
