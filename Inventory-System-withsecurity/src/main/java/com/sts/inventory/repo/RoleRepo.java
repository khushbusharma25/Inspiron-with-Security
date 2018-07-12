package com.sts.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.inventory.dto.Role;
@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}
