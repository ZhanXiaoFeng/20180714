package com.shopping.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.servlet.bean.ClothesBean;
import com.shopping.servlet.dao.ClothesDao;

public class ShoppingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp); //�˴��޸ģ�Ŀ����Ϊ�˽��ʹ�����߳������ܿͻ�����ʲô��ʽ�����󣬶�ִֻ��doPost����
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	      //�����ݷ��͸��ͻ���
		ArrayList<ClothesBean> clothesData = ClothesDao.getClothesData();
		
		System.out.println("���ݿ��е�����Ϊ:" + clothesData.toString());
	}
	
	

}
