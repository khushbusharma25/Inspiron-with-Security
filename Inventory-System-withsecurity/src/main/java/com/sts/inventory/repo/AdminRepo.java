package com.sts.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.inventory.dto.AdminDTO;

@Repository
public interface AdminRepo extends JpaRepository<AdminDTO, Long> {

}
