package com.sts.inventory.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sts.inventory.dto.UserDTO;
import com.sts.inventory.repo.RoleRepo;
import com.sts.inventory.repo.UserRepo;
import com.sts.inventory.service.UserService;




@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Autowired
	RoleRepo role;
	public UserDTO saveStudent(UserDTO userDTO) {
	
		return repo.save(userDTO);
	}
	
	public List<UserDTO> saveStudents(List<UserDTO> userDTO) {
		
		return repo.save(userDTO);
	}
	
	public  Page<UserDTO> getAllStudents(Pageable pageable) {
//		List<StudentDTO> listStudent=  studentRepo.findAll();
//		Map<String,List<StudentDTO>> map= new HashMap<String, List<StudentDTO>>(); 
//		map.put("studentList", listStudent);
//		return map;
		return  repo.findAll(pageable);
	}
	
	public UserDTO getStudentByKey(Long id) {
	
		return repo.findOne(id);
	}

	public UserDTO updateStudent(UserDTO userDTO) {
		UserDTO dto = repo.getOne(userDTO.getUser_id());
		dto.setfName(userDTO.getfName());
		dto.setlName(userDTO.getlName());
		dto.setEmail(userDTO.getEmail());
		dto.setAddress(userDTO.getAddress());
		dto.setContNo(userDTO.getContNo());
		
		return repo.save(dto);
	}
	
	
	public ResponseEntity<?> deleteStudent(Long id) {
		UserDTO userDTO = repo.findOne(id);
		 repo.delete(userDTO);
		return null;
		
	}
	
	public UserDTO authnticate(UserDTO userDTO) {
		userDTO = repo.findByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword());
		System.out.println(userDTO);
		return userDTO;
		
	}
	
	public UserDTO findByUserName(String username) {
		UserDTO userDTO = repo.findByUserName(username);
		
		return userDTO;
		
	}

	@Override
	public UserDTO findByFName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return repo.findByFName(userDTO.getfName());
	}

//	@Override
//	public List<UserDTO> search(UserDTO userDTO) {
//		// TODO Auto-generated method stub
//		return repo.search(userDTO.getfName());
//	}

	@Override
	public List<UserDTO> searchByAge(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return repo.findByAgeGreaterThan(userDTO.getAge());
	}

	@Override
	public List<UserDTO> searchBylastName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return repo.findByLNameLike(userDTO.getlName());
	}

	@Override
	public List<UserDTO> findByLNameOrFName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return repo.findByLNameOrFName(userDTO.getlName(), userDTO.getfName());
	}

	@Override
	public List<UserDTO> findByAddress(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return repo.findByAddress(userDTO.getAddress());
	}

	@Override
	public int deleteByfName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return repo.deleteByfName(userDTO.getfName());
	}

	@Override
	public int updateBylName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return repo.updateByLName(userDTO.getfName(), userDTO.getAddress(), userDTO.getlName());
	}
	
	
	
	
}
