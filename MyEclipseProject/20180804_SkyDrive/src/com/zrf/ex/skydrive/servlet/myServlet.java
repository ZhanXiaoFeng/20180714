package com.zrf.ex.skydrive.servlet;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Servlet implementation class myServlet
 */
@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public myServlet() {
		super();
	}

	FileSystem fs = null;
	{
		// ����һ�����ò�����������һ������������Ҫ���ʵ�hdfs��URI
		// �Ӷ�FileSystem.get()������֪��Ӧ����ȥ����һ������hdfs�ļ�ϵͳ�Ŀͻ��ˣ��Լ�hdfs�ķ��ʵ�ַ
		// new Configuration();��ʱ�����ͻ�ȥ����jar���е�hdfs-default.xml
		// Ȼ���ټ���classpath�µ�hdfs-site.xml
		Configuration conf = new Configuration();
		// һ��ʹ��ip��ַ����Լ����ӳ���ַ���ܻ����
		conf.set("fs.defaultFS", "hdfs://192.168.1.128:8020");
		/**
		 * �������ȼ��� 1���ͻ��˴��������õ�ֵ 2��classpath�µ��û��Զ��������ļ� 3��Ȼ���Ƿ�������Ĭ������
		 */
		conf.set("dfs.replication", "3");

		// ��ȡһ��hdfs�ķ��ʿͻ��ˣ����ݲ��������ʵ��Ӧ����DistributedFileSystem��ʵ��
		// fs = FileSystem.get(conf);

		// �������ȥ��ȡ����conf����Ϳ��Բ�Ҫ��"fs.defaultFS"���������ң�����ͻ��˵���ݱ�ʶ�Ѿ���root�û�
		try {
			String userName = "root";
			try {
				fs = FileSystem.get(new URI("hdfs://192.168.1.128:8020"), conf, userName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (InterruptedException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		switch (op) {
		case "login":
			String userName = request.getParameter("userName");
			if (userName == "root") {
				System.out.println("welcome" + userName);
			}
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("index.jsp").forward(request, response);

			break;
		case "listAll":
			FileStatus[] listStatus = fs.listStatus(new Path("/"));

			String flag = "d--             ";
			for (FileStatus fstatus : listStatus) {
				if (fstatus.isFile())
					flag = "f--         ";
				System.out.println(flag + fstatus.getPath().getName());
			}
			break;

		default:
			break;
		}

	}

}
