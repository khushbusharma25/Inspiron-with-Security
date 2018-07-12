package com.sts.inventory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sts.inventory.dto.Products;
import com.sts.inventory.repo.ProductRepo;
import com.sts.inventory.service.ProductService;

public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public ResponseEntity<?> getAllProducts() {
		List<Products> productList=productRepo.findAll();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@Override
	public Products getProductById(Long pId) {
		return productRepo.findOne(pId);
	}

	@Override
	public Map<String, Object> saveProduct(Products products) {
		Map<String, Object> response= new HashMap<>();
		int count = productRepo.isProductExist(products.getProductName(),products.getpId());
		try {
			if(count>=1) {
				response.put("status", 2);
				response.put("message", "product already exist");
			}
			else {
				if(products.getpId()==null) {
					productRepo.save(products);
				}else {
					Products products2 = productRepo.findOne(products.getpId());
					products2.setPrice(products.getPrice());
					products2.setDiscription(products.getDiscription());
					products2.setProductName(products.getProductName());
					products2.setWeight(products.getWeight());
					productRepo.save(products2);
				}
				response.put("status", 1);
				response.put("message", "product saved successsfully");
			}
		} catch (Exception e) {
			response.put("status", 2);
			response.put("message", "All fiels are required");
		}
		 return response;
	}

	@Override
	public Map<String, Object> deleteProduct(Long pId) {
		Map<String, Object> response= new HashMap<>();
		response.put("status", 2);
		response.put("message", "unable to delete");
		if(pId!=null) {
			productRepo.delete(pId);
			response.put("status", 1);
			response.put("message", "product deleted");
		}
		return response;
	}

}
