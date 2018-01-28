package test;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.Addr;
import service.AddrService;

public class TestAddr {

	@Test
	public void testInsert() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddrService service = (AddrService) context.getBean("AddrService");
		Addr addr = new Addr("��ɽʦ��", "������", "wangwu", "13514625478", 0, "adjkd", 3);
		int insert = service.insert(addr);
		if (insert > 0) {
			System.out.println("����ɹ���");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	@Test
	public void testInsertCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddrService service = (AddrService) context.getBean("AddrService");
		Addr addr = new Addr(null, null, null, null, 0, "111", 3);
		int res = service.insertCondition(addr);
		if (res > 0) {
			System.out.println("����ɹ���");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	@Test
	public void testSelectById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddrService service = (AddrService) context.getBean("AddrService");
		Addr selectById = service.selectById(1);
		if (selectById != null) {
			System.out.println("���ҳɹ���");
			System.out.println(selectById);
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	@Test
	public void testSelectAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddrService service = (AddrService) context.getBean("AddrService");
		List<Addr> res = service.selectAll();
		for (Addr addr : res) {
			System.out.println(addr);
		}
	}

	@Test
	public void testUpdateByCondition() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddrService service = (AddrService) context.getBean("AddrService");
		Addr addr = new Addr();
		addr.setAddr("��ɽ");
		addr.setCustomerId(4);
		addr.setId(6);
		int res = service.updateByCondition(addr);
		if (res > 0) {
			System.out.println("���³ɹ���");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	@Test
	public void testDeleteById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AddrService service = (AddrService) context.getBean("service");
		int res = service.deleteById(6);
		if (res > 0) {
			System.out.println("ɾ���ɹ���");
		} else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}

}
