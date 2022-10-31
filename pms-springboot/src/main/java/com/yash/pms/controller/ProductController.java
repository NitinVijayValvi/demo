package com.yash.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pms.model.Product;
import com.yash.pms.service.ProductService;

@RestController
@RequestMapping("/api/v")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		// TODO Auto-generated constructor stub
		this.productService = productService;
	}

	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {

		Product newproduct = productService.saveProduct(product);

		return new ResponseEntity<Product>(newproduct, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> products = productService.findAllProducts();

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Product> getProductByID(@PathVariable("id") int id) {

		Product product = productService.findProductById(id);

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable int id) {

		Product updaProduct = productService.get(id);
		productService.saveProduct(product);
		return new ResponseEntity<>(updaProduct, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {

		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}