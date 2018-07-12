package com.sts.inventory.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.inventory.dto.UserDTO;
import com.sts.inventory.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
//	@Qualifier("validationController")
//	private Validator validator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(new ValidationController());
//	}
	
	@PostMapping("/authenticate")
	public String authenticate(@Valid @RequestBody UserDTO userDTO){
		System.out.println(userDTO);
		userDTO = userService.authnticate(userDTO);
	
		if(userDTO.getfName()!=null){
			return "success";
		}
		else {
			return "fail";
		}
	}
	
	
	@GetMapping("/getAll")
		
	Page<UserDTO> list( Pageable pageable){
			Page<UserDTO> users = userService.getAllStudents(pageable);
			return users;
			
	}
	
	@PostMapping("/save")
	public String saveStudent(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "fail to save";
		}else {
			userService.saveStudent(userDTO);
			return "Success";
		}
		 
		
	}
	@PostMapping("/saveList")
	public String saveStudents(@Valid @RequestBody List<UserDTO >userDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "fail to save";
		}else {
			userService.saveStudents(userDTO);
			return "Success";
		}
		 
		
	}
	@GetMapping("/getByKey/{id}")
	public UserDTO getStudentById(@PathVariable(value="id") Long id) {
		return userService.getStudentByKey(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value="id") Long id) {
		return userService.deleteStudent(id);
	
	}
	
	@PutMapping("/updateStudent")
	public String updateStudent(@Valid @RequestBody UserDTO userDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "fail to updated";
		}else {
			userService.updateStudent(userDTO);
			return "Successfully Updated";
		}
	}
	
	@PostMapping("/getByfname")
	public UserDTO getByFname(@Valid @RequestBody UserDTO userDTO) {
		return userService.findByFName(userDTO);
	}
	
//	@PostMapping("/search")
//	public List<UserDTO> search(@Valid @RequestBody UserDTO userDTO) {
//		return userService.search(userDTO);
//	}
	
	@PostMapping("/searchBylName")
	public List<UserDTO> searchByLName(@Valid @RequestBody UserDTO userDTO) {
		return userService.searchBylastName(userDTO);
	} 
	@PostMapping("/searchAge")
	public List<UserDTO> searchByAge(@Valid @RequestBody UserDTO userDTO) {
		return userService.searchByAge(userDTO);
	}
	
	@PostMapping("/searchforlname")
	public List<UserDTO> findByFNmeOrLname(@Valid @RequestBody UserDTO userDTO) {
		return userService.findByLNameOrFName(userDTO);
	}
	
	@PostMapping("/getByAdd")
	public List<UserDTO> getByAddress(@Valid @RequestBody UserDTO userDTO) {
		return userService.findByAddress(userDTO);
	}
	
	@PostMapping("/deleteByFname") //not available
	public String deleteByFname(@Valid @RequestBody UserDTO userDTO) {
		 userService.deleteByfName(userDTO);
		 return "deleted";
	}
	
	@PostMapping("/updateBylName") 
	public String updateBylName(@Valid @RequestBody UserDTO userDTO) {
		 int i =userService.updateBylName(userDTO);
		 if(i !=0)
		 return "updated";
		 else {
			 return "failed";
		 }
	}
}
