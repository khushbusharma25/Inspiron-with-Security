package com.sts.inventory.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RestController;

import com.sts.inventory.dto.Products;
import com.sts.inventory.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	public ResponseEntity<?> getAllProducts(){
		return productService.getAllProducts();
	}
	
	public Products getProductById(Long pId){
		return productService.getProductById(pId);
	}
	
	public Map<String, Object> saveProduct(Products products){
		return productService.saveProduct(products);
	}
	
	public Map<String, Object> deleteProduct(Long pId){
		return productService.deleteProduct(pId);
	}
	
}
