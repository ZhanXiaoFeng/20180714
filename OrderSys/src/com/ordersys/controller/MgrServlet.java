package com.ordersys.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ordersys.bean.Mgr;
import com.ordersys.service.MgrService;
import com.ordersys.service.impl.MgrServiceImpl;

/**
 * ����Ա��½������
 * 
 * @author cetc
 *
 */
@WebServlet("/mgrServlet")
public class MgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MgrService mgrService = new MgrServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "login":
			login(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 * ����Ա��½ʱ�жϹ���Ա�Ƿ�Ϸ����Ϸ����ض���mgr/index.jsp������������ڵ�½ҳ��
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String mgrName = request.getParameter("mgrName");
		String mgrPwd = request.getParameter("mgrPwd");

		Mgr loginRes = null;
		try {
			loginRes = mgrService.login(mgrName, mgrPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();

		if (loginRes != null) {
			session.setAttribute("mgr", loginRes);
			System.out.println("��¼�ɹ�");
			response.sendRedirect("mgr/index.jsp");
		} else {
			response.sendRedirect("mgrLogin.jsp");
		}
	}

}
