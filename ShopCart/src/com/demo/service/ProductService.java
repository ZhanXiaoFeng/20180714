package com.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.demo.entity.Product;

public interface ProductService {
	// �����Ʒ
	public void addProduct(Product p) throws SQLException;

	// ��ѯ������Ʒ
	public List<Product> findAll() throws SQLException;

	// ����id��ѯ��Ʒ
	public Product findProductById(String id) throws SQLException;

	// �޸���Ʒ
	public void editProduct(Product p) throws SQLException;

	// ɾ��ѡ��
	public void delSelectById(String[] ids) throws SQLException;

	// ��������
	public List<Product> findByCondition(String id, String category, String name, String minPrice, String maxPrice)
			throws SQLException;

}