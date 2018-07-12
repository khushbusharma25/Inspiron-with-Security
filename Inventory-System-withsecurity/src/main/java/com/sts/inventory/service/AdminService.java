package com.sts.inventory.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sts.inventory.dto.AdminDTO;

public interface AdminService {
	AdminDTO saveAdmin(AdminDTO adminDTO);
	
	List<AdminDTO> getAllAdmin();
	
	AdminDTO getAdminById(Long id);
	
	AdminDTO updateAdmin(AdminDTO adminDTO);
	
	ResponseEntity<?> deleteAdmin(Long id);
}
