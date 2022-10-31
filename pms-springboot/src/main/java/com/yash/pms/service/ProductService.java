package com.yash.pms.service;

import java.util.List;

import com.yash.pms.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> findAllProducts();

	Product findProductById(int id);

	Product get(int id);

	void deleteProduct(int id);
}
