package com.sts.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sts.inventory.dto.Products;

public interface ProductRepo extends JpaRepository<Products, Long> {

	@Query(nativeQuery=true,value="SELECT COUNT(*) \r\n" + 
			"FROM  products \r\n" + 
			"where product_name = :productName and not pId=:pId ")
	int isProductExist(String productName, Long pId);

}
