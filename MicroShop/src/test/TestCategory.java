package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Category;
import service.CategoryService;	

public class TestCategory {
	/*
	 * ������Ʒ������
	 */
	/*@Test
	public void testInsert() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category category = new Category("��Ʒ���һ", true, null);
		if (service.insert(category) > 0) {
			System.out.println("����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}*/

	/*
	 * ����������Ʒ������
	 */
	/*@Test
	public void testInsertCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category category = new Category("��Ʒ����", true, null);
		if (service.insertCondition(category) > 0) {
			System.out.println("����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}*/

	/*
	 * ͨ��id�鿴��Ʒ������
	 */
	@Test
	public void testSelectById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category select = service.selectById(1);
		if (select != null) {
			System.out.println("��ѯ�ɹ�");
			System.out.println(select);
		} else {
			System.out.println("��ѯʧ��");
		}
	}

	/*
	 * �鿴��Ʒ������
	 */
	@Test
	public void testSelectAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		List<Category> selectAll = service.selectAll();
		for (Category category : selectAll) {
			System.out.println(category);
		}
	}

	/*
	 * �鿴�ڼ�����������Ʒ������
	 */
	@Test
	public void testSelectIn() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		int arry[] = { 1, 2, 3 };
		List<Category> selectAll = service.selectIn(arry);
		for (Category category : selectAll) {
			System.out.println(category);
		}
	}

	/*
	 * �����鿴������Ʒ���
	 */
	@Test
	public void testSelectCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		List<Category> select = service.selectCondition();
		for (Category category : select) {
			System.out.println(category);
		}
	}

	/*
	 * ͨ��ID������Ʒ������
	 */
	@Test
	public void testUpdateById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		Category category = new Category();
		category.setId(2);
		category.setIntro("ˮ����");
		service.updateById(category);
		if (service.updateById(category) > 0) {
			System.out.println(category);
		} else {
			System.out.println("����ʧ��");
		}
	}

	/*
	 * ͨ��idɾ��ָ����Ʒ���
	 */
	@Test
	public void testDeleteById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService service = (CategoryService) context.getBean("CategoryService");
		if (service.deleteById(3) > 0) {
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}
}
