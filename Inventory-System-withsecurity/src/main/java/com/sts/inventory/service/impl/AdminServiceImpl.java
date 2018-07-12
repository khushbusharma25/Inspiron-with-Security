package com.sts.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sts.inventory.dto.AdminDTO;
import com.sts.inventory.repo.AdminRepo;

@Service
public class AdminServiceImpl {

	@Autowired
	AdminRepo repo;
	
	public AdminDTO saveAdmin(AdminDTO adminDTO) {
		return repo.save(adminDTO);
	}
	
	public  List<AdminDTO> getAllAdmin() {
//		List<StudentDTO> listStudent=  studentRepo.findAll();
//		Map<String,List<StudentDTO>> map= new HashMap<String, List<StudentDTO>>(); 
//		map.put("studentList", listStudent);
//		return map;
		return  repo.findAll();
	}
	
	public AdminDTO getAdminById(Long id) {
	
		return repo.findOne(id);
	}

	public AdminDTO updateAdmin(AdminDTO adminDTO) {
		AdminDTO dto = repo.getOne(adminDTO.getId());
		dto.setfName(adminDTO.getfName());
		dto.setlName(adminDTO.getlName());
		dto.setEmail(adminDTO.getEmail());
		dto.setContNo(adminDTO.getContNo());
		
		return repo.save(dto);
	}
	
	
	public ResponseEntity<?> deleteAdmin(Long id) {
		AdminDTO adminDTO = repo.findOne(id);
		 repo.delete(adminDTO);
		return null;
		
	}
	
	
}
