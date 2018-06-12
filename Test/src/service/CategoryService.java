package service;

import java.util.List;

import entity.Category;

public interface CategoryService {

	/*
	 * ������Ʒ���
	 */
	int insert(Category category);

	/*
	 * ����������Ʒ���
	 */
	int insertCondition(Category category);

	/*
	 * ͨ��id�鿴��Ʒ���
	 */
	Category selectById(int id);

	/*
	 * �����鿴������Ʒ���
	 */
	List<Category> selectCondition();

	/*
	 * �鿴�ڼ�����������Ʒ���
	 */
	List<Category> selectIn(int[] arry);

	/*
	 * �鿴��Ʒ���
	 */
	List<Category> selectAll();

	/*
	 * ͨ��ID������Ʒ���
	 */
	int updateById(Category category);

	/*
	 * ͨ��idɾ��ָ����Ʒ���
	 */
	int deleteById(int id);

}
