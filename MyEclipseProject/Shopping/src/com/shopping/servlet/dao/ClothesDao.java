package com.shopping.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.shopping.servlet.bean.ClothesBean;

public class ClothesDao {
	
	private static Connection connection;
	//����һ��������� �����ݿ����
	
	public static ArrayList<ClothesBean> getClothesData(){
	
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("���سɹ�");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("����ʧ��");
			}
        
        
      try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shopping", "root", "123456");
				System.out.println("�������ӳɹ�");
				System.out.println("���ݿ����");
				
				Statement statement = connection.createStatement();
				String sql = "select * from clothes";//"select * from news  order by id desc"
				ResultSet resultSet = statement.executeQuery(sql);
		           ArrayList<ClothesBean> arrayList = new ArrayList<ClothesBean>();
				while (resultSet.next()) {
      		int id = resultSet.getInt("id"); //�ַ����������ݿ���е��ֶ�
      		String title = resultSet.getString("title");
      		String des = resultSet.getString("des");
      		String image_url = resultSet.getString("image_url");
      		
      		float price = resultSet.getInt("price");
      		
      		
      		ClothesBean newsBean = new ClothesBean();
      		newsBean.setId(id);
      		newsBean.setTitle(title);
      		newsBean.setDes(des);
      		newsBean.setImage_url(image_url);
      		newsBean.setPrice(price);
      		
      		arrayList.add(newsBean);
				}
				System.out.println(arrayList.toString());
				return arrayList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("���ݿ�����ʧ��");
				e.printStackTrace();
			} finally{
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		return null;
	}
}
