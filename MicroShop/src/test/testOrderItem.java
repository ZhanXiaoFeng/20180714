package test;

import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import entity.OrderItem;
import service.OrderItemService;
public class testOrderItem {

	@Test
	public void testinsertOrderItem() {

		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderItem orderItem = new OrderItem(1, 1, 1, 100.50f, 1);
		// ͨ��id��ȡbean����
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");

		// ���÷���
		int OrderItem = service.insertOrderItem(orderItem);
		if (OrderItem > 0) {

			System.out.println("success");

		} else {
			System.out.println("failed");
		}
	}

	@Test
	public void testselectOrderItemById() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderItem orderItem = new OrderItem();
		orderItem.setId(2);
		// ͨ��id��ȡbean����
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// ���÷���
		OrderItem selectOrderItemById = service.selectOrderItemById(orderItem);
		if (selectOrderItemById != null) {
			System.out.println(selectOrderItemById);

		} else {
			System.out.println("failed");
		}
	}

	@Test
	public void testselectAllOrderItem() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// ͨ��id��ȡbean����
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// ���÷���
		List<OrderItem> orderItem = service.selectAllOrderItem();

		for (OrderItem orderItem2 : orderItem) {
			System.out.println(orderItem);
		}
	}

	@Test
	public void testupdateOrderNum() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");

		OrderItem orderItem = new OrderItem();

		// ͨ��id��ȡbean����
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// ���÷���
		int updateOrderNum = service.updateOrderNum(2);
		if (updateOrderNum > 0) {

			System.out.println("success");

		} else {
			System.out.println("failed");
		}
	}

	@Test
	public void testdeleteOrderItem() {
		// ��ȡ�����ļ�������bean����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// new ClassPathXmlApplicationContext("applicationContext.xml");

		// ͨ��id��ȡbean����
		OrderItemService service = (OrderItemService) context.getBean("orderItemService");
		// ���÷���
		int deleteOrderItem = service.deleteOrderItem(1);
		if (deleteOrderItem > 0) {

			System.out.println("success");

		} else {
			System.out.println("failed");
		}
	}

}
