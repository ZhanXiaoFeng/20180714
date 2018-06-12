package com.ordersys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordersys.bean.Desk;
import com.ordersys.service.DeskService;
import com.ordersys.service.OrderService;
import com.ordersys.service.impl.DeskServiceImpl;
import com.ordersys.service.impl.OrderServiceImpl;

/**
 * desk������
 * 
 * @author cetc ��Ҫ���ƣ��ٲ���ȫ��û�����ڱ�ʹ�õ����� �ڲ���ȫ�����ڱ�ʹ�õ����� �۽���
 */
@WebServlet("/deskServlet")
public class DeskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeskService deskService = new DeskServiceImpl();
	private OrderService orderService = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "findAllNotSelectedDesk":
			findAllNotSelectedDesk(request, response);
			break;
		case "findAllHaveSelectedDesk":
			findAllHaveSelectedDesk(request, response);
			break;
		// case "updateDesk":
		// updateDesk(request);
		// break
		case "payMoney":
			try {
				payMoney(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	// private void updateDesk(HttpServletRequest request) {
	// String waiteridStr=request.getParameter("waiterid");
	// int waiterid = Integer.parseInt(waiteridStr);
	// String notSelectedDeskIdStr = request.getParameter("notSelectedDeskId");
	// int notSelectedDeskId = Integer.parseInt(notSelectedDeskIdStr);
	// Desk desk=new Desk(notSelectedDeskId, waiterid, 0, false);
	// try {
	// deskService.updateDesk(desk);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	/**
	 * ���ڽ��ˣ�����ҳ�淵�ص�index.html
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws IOException
	 */
	private void payMoney(HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {
		String haveSelectedDeskIdStr = request
				.getParameter("haveSelectedDeskId");// ��ȡ���ڱ�ʹ�õ����Ӻ�
		int haveSelectedDeskId = Integer.parseInt(haveSelectedDeskIdStr);
		orderService.deleteOrderByDeskId(haveSelectedDeskId);// ���˺�ɾ��������Order��Ӧ�����е�����
		Desk desk = new Desk(haveSelectedDeskId, 0, 0, true);
		deskService.updateDesk(desk);// ����Desk��
		response.sendRedirect("index.html");
	}

	/**
	 * �����������ڱ�ʹ�õ����ӣ�����ֵ�ض���aim
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAllHaveSelectedDesk(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Desk> list = null;
		try {
			list = deskService.findAllHaveSelectedDesks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allHaveSelectedDesk", list);
		String aim = request.getParameter("aim");
		request.getRequestDispatcher(aim).forward(request, response);
	}

	/**
	 * �ҳ�����û�����ڱ�ʹ�õ����ӣ�����ֵ�ض���aim
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAllNotSelectedDesk(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Desk> list = null;
		try {
			list = deskService.findAllNotSelectedDesks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("allNotSelectedDesk", list);
		String aim = request.getParameter("aim");
		request.getRequestDispatcher(aim).forward(request, response);
	}
}
