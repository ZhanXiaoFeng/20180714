package service;

import entity.Admin;

public interface AdminService {

	// ����Ա��¼
	Admin login(Admin admin);

	// ��ѯ������Ϣ
	Admin selectByCondition(int id);

	// ���¸�����Ϣ
	int updateById(Admin admin);

}
