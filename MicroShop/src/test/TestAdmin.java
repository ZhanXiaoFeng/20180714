package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Admin;
import service.AdminService;
import utils.MD5;

public class TestAdmin {

	@Test
	public void testLogin() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("AdminService");
		MD5 md5 = new MD5();
		String md5Encode = md5.MD5Encode("admin");
		System.out.println(md5Encode);
		Admin admin = new Admin();
		admin.setUsername("Admin");
		admin.setPassword(md5Encode);
		Admin login = adminService.login(admin);
		if (login != null) {
			System.out.println("��¼�ɹ���");
		} else {
			System.out.println("��¼ʧ�ܣ�");
		}
	}

/*	@Test
	public void testSelectById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("AdminService");
		Admin selectById = adminService.selectById(1);
		if (selectById != null) {
			System.out.println("���ҳɹ���");
			System.out.println(selectById);
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}
*/
	@Test
	public void testUpdateById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = (AdminService) context.getBean("AdminService");
		Admin admin = new Admin();
		admin.setEmail("admin@qq.com");
		admin.setGender("1");
		admin.setId(1);
		int updateById = adminService.updateById(admin);
		if (updateById > 0) {
			System.out.println("���³ɹ���");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

}
