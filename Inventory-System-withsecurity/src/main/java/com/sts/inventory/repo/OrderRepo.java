package com.sts.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.inventory.dto.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
	
}
