package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Customer;
import service.CustomerService;
import utils.MD5;

public class testCustomer {

	@Test
	public void testinsertCust() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		MD5 md5=new MD5();
		String md5Encode = md5.MD5Encode("18456");
		Customer customer=new Customer("����",md5Encode , "gehui", "upload/img/Jellsh.jpg", "15607835555", "2680112456@qq.com");
		// ͨ��id��ȡbean����
		CustomerService service = (CustomerService) context.getBean("service");
		// ���÷���
		int insertCust = service.regist(customer);
		if (insertCust>0) {
			
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
	}
	
	@Test
	public void testselectCustById() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// ͨ��id��ȡbean����
		CustomerService service = (CustomerService) context.getBean("service");
		// ���÷���
		 Customer customer = service.selectCustById(1);
		  System.out.println(customer);
	}
	
	@Test
	public void testselectByNameAndPwd() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		MD5 md5=new MD5();
		String md5Encode = md5.MD5Encode("123456");
		Customer customer=new Customer();
		customer.setUsername("��");
		customer.setPassword(md5Encode);
		// ͨ��id��ȡbean����
		CustomerService service = (CustomerService) context.getBean("service");
		// ���÷���
		Customer selectByNameAndPwd = service.login(customer);
		System.out.println(selectByNameAndPwd);
		//System.out.println("���ܺ���ַ���"+MD5.MD5Encode(customer.setPassword("12345")));
	}
	
	@Test
	public void testupdateByCondition() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Customer customer=new Customer();
		customer.setNickname("zhangsan");
		customer.setId(1);
		// ͨ��id��ȡbean����
		CustomerService service = (CustomerService) context.getBean("service");
		// ���÷���
		int updateByCondition = service.updateByCondition(customer);
		if (updateByCondition>0) {
			
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
	}
	
	@Test
	public void testdeleteCustById() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Customer customer=new Customer("����", "12345", "admin", "upload/img/Jellsh.jpg", "15607835545", "2680112456@qq.com");
		// ͨ��id��ȡbean����
		CustomerService service = (CustomerService) context.getBean("service");
		// ���÷���
		int insertCust = service.deleteCustById(1);
		if (insertCust>0) {
			
			System.out.println("success");
			
		}else {
			System.out.println("failed");
		}
	}
	
	
}
