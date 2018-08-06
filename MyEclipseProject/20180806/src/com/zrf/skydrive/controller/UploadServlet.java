package com.zrf.skydrive.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapred.JobConf;
import com.zrf.skydrive.dao.HdfsDao;

@WebServlet("/uploadServlet")
public final class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Log log = LogFactory.getLog(UploadServlet.class);

	private final int MAX_FILE_SIZE = 50 * 1024 * 1024; // 50M
	private final int MAX_MEM_SIZE = 50 * 1024 * 1024; // 50M

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//String file = request.getParameter("file");
		File file;
		// ��֤�ϴ�����������
		String contentType = request.getContentType();
		String fileUploadPath = request.getServletContext().getRealPath("");
		System.out.println(fileUploadPath);
		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// �����ڴ��д洢�ļ������ֵ
			factory.setSizeThreshold(MAX_MEM_SIZE);
			// ���ش洢�����ݴ��� maxMemSize.
			factory.setRepository(new File("/myDir"));

			// ����һ���µ��ļ��ϴ��������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ��������ϴ����ļ���С
			upload.setSizeMax(MAX_FILE_SIZE);
			try {
				// ������ȡ���ļ�
				List<FileItem> fileList = upload.parseRequest(request);
				// �����ϴ����ļ�
				Iterator<FileItem> iterator = fileList.iterator();
				log.debug("begin to upload file to tomcat server</p>");
				while (iterator.hasNext()) {
					FileItem item = iterator.next();
					if (!item.isFormField()) {
						// ��ȡ�ϴ��ļ��Ĳ���
						String fileName = item.getName();
						String fn = fileName.substring(fileName.lastIndexOf("\\") + 1);
						log.debug("<br>" + fn + "<br>");
						// boolean isInMemory = item.isInMemory();
						// long sizeInBytes = item.getSize();
						// д���ļ�
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(fileUploadPath, fileName.substring(fileName.lastIndexOf("\\")));
						} else {
							file = new File(fileUploadPath, fileName.substring(fileName.lastIndexOf("\\") + 1));
						}
						item.write(file);
						JobConf conf = HdfsDao.getConfig();
						HdfsDao hdfs = new HdfsDao(conf);
						hdfs.copyFile(fileUploadPath + File.separator + fn, "/myDir/" + fn);
					}
				}

				log.debug("upload file to tomcat server success!");
				request.setAttribute("flag", "success");
				request.setAttribute("msg",
						"upload file to tomcat server success!<br/>upload file to hadoop hdfs success!s");
				request.getRequestDispatcher("upload.jsp").forward(request, response);

			} catch (Exception ex) {
				log.error(ex.getMessage());
				request.setAttribute("flag", "danger");
				request.setAttribute("msg", ex.getMessage());
				request.getRequestDispatcher("upload.jsp").forward(request, response);
			}
		} else {
			log.warn("<p>No file uploaded</p>");
			request.setAttribute("flag", "warning");
			request.setAttribute("msg", "<p>No file uploaded</p>");
			request.getRequestDispatcher("upload.jsp").forward(request, response);
		}
	}
}
