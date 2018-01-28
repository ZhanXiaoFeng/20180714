package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import entity.Category;
import service.CategoryService;

@Controller
public class CategoryServlet {
	@Autowired
	@Qualifier("categoryService")
	CategoryService categoryService;

	/*
	 * ������Ʒ���
	 */
	@RequestMapping("/insertCate.do")
	public String insertDo(Category category, HttpServletRequest request) {
		Category category1 = new Category();
		category.setId(category.getId());
		if (category.getName() == "") {
			category1.setName(null);
		} else {
			category1.setName(category.getName());
			int category2 = categoryService.insert(category1);
			System.out.println(category2);
			if (category2 > 0) {
				request.setAttribute("category2", category2);
				request.setAttribute("message", "���ݲ���ɹ�");
			} else {
				request.setAttribute("message", "���ݲ���ʧ��");
			}
		}
		List<Category> categorys = categoryService.selectAll();
		request.setAttribute("categorys", categorys);
		return "selectAllCate";
	}

	@RequestMapping("insertCate.html")
	public String insert() {
		return "insertCate";
	}

	@RequestMapping("categoryIndex.html")
	public String index() {
		return "categoryIndex";
	}

	/*
	 * ��ѯ�������
	 */
	@RequestMapping("/selectAllCate.do")
	public List<Category> selectAllDo(Category category, HttpServletRequest request) {
		List<Category> categorys = categoryService.selectAll();
		request.setAttribute("categorys", categorys);
		System.out.println(categorys);
		return categorys;
	}

	@RequestMapping("/selectCateById.do")
	public String selectById(Category category, HttpServletRequest request) {
		String idStr = request.getParameter("id");
		int id1 = Integer.parseInt(idStr);
		request.setAttribute("id", id1);
		System.out.println(id1);
		Category category3 = categoryService.selectById(id1);
		request.setAttribute("category3", category3);
		System.out.println(category3);
		return "selectCateById";
	}

	/*
	 * ɾ�����
	 */
	@RequestMapping("/deleteCate.do")
	public String deleteDo(Category category, HttpServletRequest request) {
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		categoryService.deleteById(id);
		System.out.println(category);
		List<Category> categorys = categoryService.selectAll();
		request.setAttribute("categorys", categorys);
		return "selectAllCate";
	}

	/*
	 * �������
	 */
	@RequestMapping("/updateCate.do")
	public ModelAndView updateCate(@RequestParam(value = "id", required = true) int id, HttpServletRequest request) {
		System.out.println(id);
		Category category = categoryService.selectById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("category", category);
		modelAndView.setViewName("updateCate");
		return modelAndView;
	}

	@RequestMapping("/updateC.do")
	public String updateDo(Category category, HttpServletRequest request) {
		int updateById = categoryService.updateById(category);
		if (updateById > 0) {
			System.out.println("���³ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
		List<Category> categorys = categoryService.selectAll();
		request.setAttribute("categorys", categorys);
		return "selectAllCate";
	}

}
