package com.sts.inventory.repo;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sts.inventory.dto.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserDTO, Long>{
	UserDTO findByUserNameAndPassword(String userName, String password);
	
	UserDTO findByFName(String fName);
	
	List<UserDTO> findByLNameLike(String lName);
	
	List<UserDTO> findByAgeGreaterThan(int age);
	
	List<UserDTO> findByLNameOrFName(String lName, String fName);
	
	int deleteByfName(String fName); // not available so we can use modidying
	
	UserDTO findByUserName(String userName);
	
	@Modifying
	@Transactional
	@Query("update UserDTO u set u.fName= ?1, u.address = ?2 where u.lName= ?3")
	int updateByLName(String fName, String address, String lName);
	
	@Query("select u from #{#entityName} u where u.address = ?1")
	  List<UserDTO> findByAddress(String address);
}
