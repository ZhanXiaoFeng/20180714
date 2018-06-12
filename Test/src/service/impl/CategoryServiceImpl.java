package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.CategoryMapper;
import entity.Category;
import service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	@Qualifier("categoryMapper")
	private CategoryMapper categoryMapper;

	public CategoryMapper getCategoryMapper() {
		return categoryMapper;
	}

	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}

	/*
	 * ������Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#insert(entity.Category)
	 */
	@Override
	public int insert(Category category) {
		return categoryMapper.insert(category);
	}

	/*
	 * ����������Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#insertCondition(entity.Category)
	 */
	@Override
	public int insertCondition(Category category) {
		return categoryMapper.insertCondition(category);
	}

	/*
	 * ͨ��id�鿴��Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#selectById(int)
	 */
	@Override
	public Category selectById(int id) {
		return categoryMapper.selectById(id);
	}

	/*
	 * �����鿴������Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#selectCondition()
	 */
	@Override
	public List<Category> selectCondition() {
		return categoryMapper.selectCondition();
	}

	/*
	 * �鿴�ڼ�����������Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#selectIn(int[])
	 */
	@Override
	public List<Category> selectIn(int[] arry) {
		return categoryMapper.selectIn(arry);
	}

	/*
	 * �鿴��Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#selectAll()
	 */
	@Override
	public List<Category> selectAll() {
		return categoryMapper.selectAll();
	}

	/*
	 * ͨ��ID������Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#updateById(entity.Category)
	 */
	@Override
	public int updateById(Category category) {
		return categoryMapper.updateById(category);
	}

	/*
	 * ͨ��idɾ��ָ����Ʒ���(non-Javadoc)
	 * 
	 * @see service.CategoryService#deleteById(int)
	 */
	@Override
	public int deleteById(int id) {
		return categoryMapper.deleteById(id);
	}

}
