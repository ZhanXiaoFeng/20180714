package dao;

import entity.Admin;

/**
 * ����Ա���ݷ��ʲ�ӿ�
 * 
 * @author CETC
 *
 */
public interface AdminMapper {

	// ����Ա��¼
	Admin login(Admin admin);

	// ��ѯ������Ϣ
	Admin selectByCondition(int id);

	// ���¸�����Ϣ
	int updateById(Admin Admin);

}
