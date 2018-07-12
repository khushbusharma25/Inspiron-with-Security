package com.sts.inventory.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.sts.inventory.dto.Products;

public interface ProductService {

	ResponseEntity<?> getAllProducts();

	Products getProductById(Long pId);

	Map<String, Object> saveProduct(Products products);

	Map<String, Object> deleteProduct(Long pId);

}
