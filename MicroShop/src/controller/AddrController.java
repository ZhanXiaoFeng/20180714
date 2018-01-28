package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import entity.Addr;
import service.AddrService;

@Controller
public class AddrController {
	@Autowired
	@Qualifier("addrService")
	private AddrService addrService;

	public AddrService getAddrService() {
		return addrService;
	}

	public void setAddrService(AddrService addrService) {
		this.addrService = addrService;
	}

	@RequestMapping("/insertAddr.html")
	public String insert() {
		return "insertAddr";
	}

	@RequestMapping("/insertAddr.do")
	public String insertAddr(Addr addr, HttpServletRequest request) {
		int insert = addrService.insert(addr);
		if (insert > 0) {
			request.setAttribute("message", "��ӵ�ַ�ɹ���");
			return "cart";
		}

		request.setAttribute("message", "��ӵ�ַʧ�ܣ�");
		return "insertAddr";
	}

	@RequestMapping("/deleteAddr.html")
	public String deleteAddr() {
		return "deleteAddr";
	}

	@RequestMapping("/deleteAddr.do")
	public String deleteAddr(Addr addr, HttpServletRequest request) {
		int deleteById = addrService.deleteById(addr.getId());
		if (deleteById > 0) {
			request.setAttribute("message", "ɾ����ַ�ɹ���");
			return "deleteAddr";
		} else {
			request.setAttribute("message", "ɾ����ַʧ�ܣ�");
		}
		return "deleteAddr";
	}

	@RequestMapping("/updateAddr.html")
	public String updateAddr() {
		return "updateAddr";
	}

	@RequestMapping("/updateAddr.do")
	public String updateAddr(Addr addr, HttpServletRequest request) {
		int insert = addrService.updateByCondition(addr);
		if (insert > 0) {
			request.setAttribute("message", "���µ�ַ�ɹ���");
			return "updateAddr";
		} else {
			request.setAttribute("message", "���µ�ַʧ�ܣ�");
		}
		return "updateAddr";
	}

	@RequestMapping("/showAddr.html")
	public String showAddr() {
		return "showAddr";
	}

	@RequestMapping("/showAllAddr.do")
	public String showAllAddr(Addr addr, HttpServletRequest request) {
		List<Addr> Addrs = addrService.selectAll();
		if (Addrs != null) {
			request.setAttribute("message", "��ѯ�ɹ���");
			request.setAttribute("Addrs", Addrs);
			return "showAddr";
		} else {
			request.setAttribute("message", "��ѯʧ�ܣ�");
		}
		return "showAddr";
	}

	@RequestMapping("/showAddrById")
	public String selectById(int id, HttpServletRequest request, HttpServletResponse response) {
		Addr res = addrService.selectById(id);
		request.setAttribute("res", res);
		System.out.println(res);
		return "showAddrById";
	}

}
