package com.sts.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.inventory.dto.AdminDTO;
import com.sts.inventory.service.impl.AdminServiceImpl;

@RestController
@RequestMapping("/ad")
public class AdminController {

	@Autowired
	AdminServiceImpl adminservice;
	
	@GetMapping("/adminhome")
	public String home() {
		return "Welcome to admin page";
	}
	
	@PostMapping("/admin")
	public AdminDTO save(@Valid @RequestBody AdminDTO adminDTO) {
		return adminservice.saveAdmin(adminDTO);
	}
	
	@GetMapping("/admin")
	public List<AdminDTO> getAll() {
		return adminservice.getAllAdmin();
	}
	
	@GetMapping("/admin/{id}")
	public AdminDTO getById(@PathVariable(name="id") Long id) {
		return adminservice.getAdminById(id);
	}
	
	@PutMapping("/admin")
	public AdminDTO	update(@Valid @RequestBody AdminDTO adminDTO) {
		return adminservice.updateAdmin(adminDTO);
	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id) {
		return adminservice.deleteAdmin(id);
	}
		
}

