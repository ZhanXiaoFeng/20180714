
/**
* @Title: LoginServlet.java
* @Package com.zrf.skydrive.controller
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��6��
* @version V1.0  
*/

package com.zrf.skydrive.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.mapred.JobConf;

import com.zrf.skydrive.dao.HdfsDao;
import com.zrf.skydrive.utils.DbUtil;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 6849335019279659363L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		DbUtil db = new DbUtil();
		if (db.checkUser(username, password)) {
			// �û��Ϸ�����תҳ��
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			JobConf conf = HdfsDao.getConfig();
			HdfsDao hdfs = new HdfsDao(conf);

			FileStatus[] list = hdfs.ls("/" + username);

			request.setAttribute("list", list);

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {
			// �û����Ϸ������ص�¼���棬����ʾ������Ϣ
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
