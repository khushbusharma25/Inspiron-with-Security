package com.sts.inventory.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sts.inventory.dto.UserDTO;

@Service
public interface UserService {
	UserDTO saveStudent(UserDTO userDTO);
	
	List<UserDTO> saveStudents(List<UserDTO> userDTO);
	
	Page<UserDTO> getAllStudents(Pageable pageable);
	
	UserDTO getStudentByKey(Long id);
	
	UserDTO updateStudent(UserDTO userDTO);
	
	ResponseEntity<?> deleteStudent(Long id);
	
	UserDTO authnticate(UserDTO userDTO);

	//List<UserDTO> search(UserDTO userDTO);

	List<UserDTO> searchBylastName(UserDTO userDTO);
	
	List<UserDTO> searchByAge(UserDTO userDTO);

	UserDTO findByFName(UserDTO userDTO);
	
	List<UserDTO> findByLNameOrFName(UserDTO userDTO);
	
	List<UserDTO> findByAddress(UserDTO userDTO);
	
	int deleteByfName(UserDTO userDTO);
	
	int updateBylName(UserDTO userDTO);
	
	UserDTO findByUserName(String username);
}
