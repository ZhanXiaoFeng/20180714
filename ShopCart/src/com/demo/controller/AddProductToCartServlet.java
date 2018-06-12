package com.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entity.Product;
import com.demo.service.ProductService;

@WebServlet("/AddProductToCartServlet")
public class AddProductToCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1.�õ�id
		String id = request.getParameter("id");
		// 2.����service�еĸ���id��ѯ��Ʒ�ķ���
		ProductService service = new ProductService();

		try {
			Product p = service.findProductById(id);

			// 3.����Ʒ��ӵ����ﳵ
			// 3.1 ��session�л�ȡ���ﳵ
			Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
			int count = 1; // Ĭ��������1
			if (cart == null) { // �����һ�ι����û�й��ﳵ
				cart = new HashMap<Product, Integer>();
			} else {
				// �й��ﳵ����Ҫ�����ڹ��ﳵ���������Ʒ
				Integer c = cart.get(p);
				if (c != null) { // ˵�����ﳵ���������Ʒ��
					count = c + 1;
				}
			}
			cart.put(p, count); // ����Ʒ��ӵ��˹��ﳵ.

			// 4.�����ﳵ�洢��session�С�
			request.getSession().setAttribute("cart", cart);

			response.getWriter().write("<a href='" + request.getContextPath() + "/listProductByPage'>��������</a>,<a href='"
					+ request.getContextPath() + "/cart.jsp'>�鿴���ﳵ</a>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}