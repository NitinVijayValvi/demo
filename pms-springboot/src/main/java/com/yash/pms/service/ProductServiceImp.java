package com.yash.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.pms.exception.ProductNotFoundException;
import com.yash.pms.model.Product;
import com.yash.pms.repo.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductServiceImp(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product by id " + id + "Not Found"));
	}

	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteProductById(id);
		throw new ProductNotFoundException("Product with "+id+"Is not Present");
	}

	
	
}
