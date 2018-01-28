package dao;

import java.util.List;

import entity.Category;

/**
 * ��Ʒ����ӿ�
 * 
 * @author CETC
 *
 */
public interface CategoryMapper {

	// ������Ʒ���y
	int insert(Category category);

	// ����������Ʒ���y
	int insertCondition(Category category);

	// ͨ��id�鿴��Ʒ���y
	Category selectById(int id);

	// �����鿴������Ʒ���y
	List<Category> selectCondition();

	// �鿴�ڼ�����������Ʒ���y
	List<Category> selectIn(int arry[]);
	
	// �鿴��Ʒ���y
	List<Category> selectAll();

	// ͨ��ID������Ʒ���
	int updateById(Category category);

	// ͨ��idɾ��ָ����Ʒ���
	int deleteById(int id);
	
}