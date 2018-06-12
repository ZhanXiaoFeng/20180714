package dao;

import java.util.List;

import entity.Category;

public interface CategoryMapper {
	// ������Ʒ���y
	public int insert(Category category);

	// ����������Ʒ���y
	public int insertCondition(Category category);

	// ͨ��id�鿴��Ʒ���y
	public Category selectById(int id);

	// �����鿴������Ʒ���y
	public List<Category> selectCondition();

	// �鿴�ڼ�����������Ʒ���y
	public List<Category> selectIn(int arry[]);

	// �鿴��Ʒ���y
	public List<Category> selectAll();

	// ͨ��ID������Ʒ���
	public int updateById(Category category);

	// ͨ��idɾ��ָ����Ʒ���
	public int deleteById(int id);

}
