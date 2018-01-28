package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Addr;
import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Goods;
import entity.Order;
import entity.OrderItem;
import service.AddrService;
import service.GoodsService;
import service.OrderItemService;
import service.OrderService;

/**
 * ���ﳵģ�������
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	@Qualifier("goodsService")
	private GoodsService goodsService;

	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;

	@Autowired
	@Qualifier("orderItemService")
	private OrderItemService orderItemService;

	@Autowired
	@Qualifier("addrService")
	private AddrService addrService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	// �ҵĹ��ﳵ
	@RequestMapping("/myCart")
	public String myCart() throws Exception {
		return "cart";
	}

	// ɾ�����ﳵ��Ŀ
	@RequestMapping("/removeCartItem.do")
	public String removeCartItem(HttpSession session, Integer gid) throws Exception {
		// ͨ��CartItem,����cart��removeCartItem��ɹ��ﳵ��Ӳ���
		// ���ﳵ����session��
		System.out.println(gid);
		Cart cart = getCart(session);
		cart.removeCartItem(gid);
		return "cart";

	}

	// ��չ��ﳵ
	@RequestMapping("/clearCart.do")
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Cart cart = getCart(session);
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		cart.clearCart();
		return "./cart";
	}

	// ����Ʒ��ӵ����ﳵ:��ӹ��ﳵ
	@RequestMapping("/addCart.do")
	public String addCart(HttpSession session, Integer count, Integer gid) throws Exception {
		// ����CartItem
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		cartItem.setGoods(goodsService.selectById(gid));
		// ͨ��CartItem,����cart��addCart��ɹ��ﳵ��Ӳ���
		// ���ﳵ����session��
		Cart cart = getCart(session);
		cart.addCart(cartItem);
		return "cart";
	}

	// ��session�л�ȡ���ﳵ
	private Cart getCart(HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	/*
	 * public String addCart(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * 1. �õ��� 2. �õ���Ŀ���õ���Ʒ�������� 3. ����Ŀ��ӵ�����
	 * 
	 * 
	 * 1. �õ���
	 * 
	 * Cart cart = (Cart)request.getSession().getAttribute("cart");
	 * 
	 * �����ݵ�ֻ��bid������ 2. �õ���Ŀ > �õ���Ʒ������ > �ȵõ���Ʒ��gid��Ȼ��������Ҫͨ��gid��ѯ���ݿ�õ�goods > ����������
	 * 
	 * String gidStr = request.getParameter("gid"); int gid =
	 * Integer.parseInt(gidStr); Goods goods=goodsService.selectById(gid); int count
	 * = Integer.parseInt(request.getParameter("count")); CartItem cartItem = new
	 * CartItem(); cartItem.setGoods(goods); cartItem.setCount(count);
	 * 
	 * 
	 * 3. ����Ŀ��ӵ�����
	 * 
	 * cart.addCart(cartItem);
	 * 
	 * return "cart"; }
	 */

	@RequestMapping("/addOrderItem.do")
	public String addOrderItem(HttpSession session, HttpServletRequest request) throws Exception {
		Object login = session.getAttribute("login");
		if (login == null) {
			return "customerLogin";
		}
		// ��ȡһ��ʼ���ɵ��µĶ�����id
		Customer customer = (Customer) session.getAttribute("login");
		int newOrderId = (int) session.getAttribute("newOrderId");
		// ��ȡҪ���빺�ﳵ����Ʒ��ID
		String goodsIdStr = request.getParameter("gid");
		int goodsId = Integer.parseInt(goodsIdStr);
		// ��ȡҪ���빺�ﳵ����Ʒ������
		String goodsAmountStr = request.getParameter("gamount");
		int goodsAmount = Integer.parseInt(goodsAmountStr);
		// ��ȡҪ���빺�ﳵ����Ʒ�ĵ���
		String goodsPrice = request.getParameter("gprice");
		goodsPrice += 0;
		Float price = Float.valueOf(goodsPrice);
		OrderItem orderItem = new OrderItem(goodsId, goodsAmount, price, newOrderId);
		int res = orderItemService.insertOrderItem(orderItem);
		// ���ҳ��µĶ���
		Order order2 = orderService.selectOrderById(newOrderId);
		// ����������µ���Ʒ֮��Ķ������ܼ�
		float priceSum = price * goodsAmount + order2.getPrice();
		// ������״̬Ϊ0˵����δ����
		Order order = new Order(newOrderId, 0, priceSum, order2.getPaymethod(), order2.getAddrId(),
				order2.getCustomerId());
		int res2 = orderService.updateByPrimaryKeySelective(order);
		if (res != 0 && res2 != 0) {
			System.out.println("���빺�ﳵ�ɹ�");
			// �ɹ����빺�ﳵ�����ص���ҳ
			Goods goods = new Goods();
			List<Goods> goods2 = goodsService.selectCondition(goods);
			for (Goods goods3 : goods2) {
				System.out.println(goods3);
			}
			request.setAttribute("goods2", goods2);
			request.setAttribute("username", customer.getUsername());
			return "../../index";
		}
		return "false";
	}

	@RequestMapping("addOrderItemBuyBefore.do")
	public String addOrderItemBuyBefore(HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("login");
		if (customer == null) {
			return "customerLogin";
		}
		// ��ȡҪ���빺�ﳵ����Ʒ��ID
		String goodsIdStr = request.getParameter("gid");
		int goodsId = Integer.parseInt(goodsIdStr);
		// ��ȡҪ���빺�ﳵ����Ʒ������
		String goodsAmountStr = request.getParameter("gamount");
		int goodsAmount = Integer.parseInt(goodsAmountStr);
		Goods goods = goodsService.selectById(goodsId);
		float totalPrice = (float) (goodsAmount * goods.getPrice2());
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("goods", goods);
		request.setAttribute("goodsAmount", goodsAmount);
		// ��ȡ��ַ
		Addr addr = addrService.selectByCustomerId(customer.getId());
		request.setAttribute("addr", addr);
		request.setAttribute("customer", customer);
		return "cart";
	}

	@RequestMapping("/addOrderItemBuy.do")
	public String addOrderItemBuy(HttpSession session, HttpServletRequest request) throws Exception {
		Object login = session.getAttribute("login");
		if (login == null) {
			return "customerLogin";
		}
		// ��ȡһ��ʼ���ɵ��µĶ�����id
		Customer customer = (Customer) session.getAttribute("login");
		int newOrderId = (int) session.getAttribute("newOrderId");
		// ��ȡҪ���빺�ﳵ����Ʒ��ID
		String goodsIdStr = request.getParameter("gid");
		int goodsId = Integer.parseInt(goodsIdStr);
		// ��ȡҪ���빺�ﳵ����Ʒ������
		String goodsAmountStr = request.getParameter("goodsAmount");
		int goodsAmount = Integer.parseInt(goodsAmountStr);
		// ��ȡҪ���빺�ﳵ����Ʒ�ĵ���
		Goods goods4 = goodsService.selectById(goodsId);
		Double price2 = goods4.getPrice2();
		price2 += 0;
		float price = new Double(price2).floatValue();
		OrderItem orderItem = new OrderItem(goodsId, goodsAmount, price, newOrderId);
		int res = orderItemService.insertOrderItem(orderItem);
		// ���ҳ��µĶ���
		Order order2 = orderService.selectOrderById(newOrderId);
		// ����������µ���Ʒ֮��Ķ������ܼ�
		float priceSum = price * goodsAmount + order2.getPrice();
		// ������״̬Ϊ0˵����δ����
		Order order = new Order(newOrderId, 0, priceSum, order2.getPaymethod(), order2.getAddrId(),
				order2.getCustomerId());
		int res2 = orderService.updateByPrimaryKeySelective(order);
		if (res != 0 && res2 != 0) {
			System.out.println("���빺�ﳵ�ɹ�");
			// �ɹ����빺�ﳵ�����ص���ҳ
			Goods goods = new Goods();
			List<Goods> goods2 = goodsService.selectCondition(goods);
			for (Goods goods3 : goods2) {
				System.out.println(goods3);
			}
			request.setAttribute("goods2", goods2);
			request.setAttribute("username", customer.getUsername());
			return "../../index";
		}
		return "false";
	}

	// �鿴�ҵĹ��ﳵ
	@RequestMapping("/showMyCart.do")
	public String showMyCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("login");
		if (customer != null) {
			List<Order> order = orderService.showCartByCustidAndStatus(customer.getId());
			request.setAttribute("orders", order);
			return "showCart";
		}
		return "customerLogin";
	}

	// ���ﳵ�������鴦��
	@RequestMapping("/showCartDetail.do") // jsp�еı���action�����ݲ��ҵ��˴�
	public String testOrderSearch(HttpServletRequest request, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("login");
		String orderIdStrs = request.getParameter("orderId");
		int orderId = Integer.parseInt(orderIdStrs);
		Order orders = orderService.selectAllByUserId(orderId);
		request.setAttribute("username", customer.getUsername());
		request.setAttribute("orders", orders);
		// ��ȡ��ַ
		Addr addr = addrService.selectByCustomerId(customer.getId());
		request.setAttribute("addr", addr);
		return "showCartDetail";
	}
}
