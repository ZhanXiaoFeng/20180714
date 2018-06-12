package com.demo.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.demo.dao.ProductDao;
import com.demo.entity.Product;
import com.demo.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao dao = new ProductDao();

	// �����Ʒ
	public void addProduct(Product p) throws SQLException {

		try {
			dao.addProduct(p);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("�����Ʒʧ��");
		}
	}

	// ��ѯ������Ʒ
	public List<Product> findAll() throws SQLException {
		return dao.findAll();
	}

	// ����id��ѯ��Ʒ
	public Product findProductById(String id) throws SQLException {
		return dao.findProductById(id);
	}

	// �޸���Ʒ
	public void editProduct(Product p) throws SQLException {
		dao.editProduct(p);
	}

	// ɾ��ѡ��
	public void delSelectById(String[] ids) throws SQLException {
		dao.delSelectById(ids);
	}

	// ��������
	public List<Product> findByCondition(String id, String category, String name, String minPrice, String maxPrice)
			throws SQLException {

		return dao.findByCondition(id, category, name, minPrice, maxPrice);
	}

}
