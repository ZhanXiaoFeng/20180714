package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import entity.Admin;
import service.AdminService;
import utils.MD5;

@Controller
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	// ���ʵ�¼ҳ��
	@RequestMapping("/login.html")
	public String loginIndex() {
		return "login";
	}

	@RequestMapping("/login.do")
	public String login(Admin admin, HttpServletRequest request) {
		MD5 md5 = new MD5();
		String password = md5.MD5Encode(admin.getPassword());
		admin.setPassword(password);
		Admin admin2 = adminService.login(admin);
		System.out.println(admin2);
		if (admin2 != null) {
			request.setAttribute("message", "��ӭ��¼");
			request.setAttribute("admin2", admin2);
			return "../../����/../admin/index";
		}
		request.setAttribute("message", "�û������������");
		return "../../����/../admin/login";
	}

	// �鿴������Ϣ
	@RequestMapping("/selectById.do")
	public String selectById(int id, HttpServletRequest request, HttpServletResponse response) {
		Admin res = adminService.selectByCondition(id);
		request.setAttribute("res", res);
		System.out.println(res);
		return "../../admin/admin_info";
	}

	// �����ϴ�ҳ��
	@RequestMapping("/uploadImg.html")
	public String uploadImg() {
		return "adminUploadImg";
	}

	// �ϴ���Ƭ����
	@RequestMapping("/uploadImg.do")
	public String uploadImg(@RequestParam("file") MultipartFile file, Admin admin, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String filename = file.getOriginalFilename();
		System.out.println(admin);
		// �ļ�·��
		if (file.getSize() > 1000000) {
			System.out.println(file.getSize());
			request.setAttribute("message", "�ļ��Ĵ�С����1000000");
			return "/adminUploadImg";
		}
		System.out.println(request.getServletContext().getRealPath("/"));
		String path = request.getServletContext().getRealPath("/static/img/admin");
		try {
			file.transferTo(new File(path + File.separator + filename));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		admin.setId(admin.getId());
		admin.setImgUrl(filename);
		int uploadImg = adminService.updateById(admin);
		if (uploadImg > 0) {
			request.setAttribute("message", "ͷ���ϴ��ɹ���");
			return "/adminUploadImg";
		} else {
			request.setAttribute("message", "ͷ���ϴ�ʧ�ܣ�");
		}
		return "/adminUploadImg";
	}
}
