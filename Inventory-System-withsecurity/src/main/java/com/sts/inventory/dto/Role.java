package com.sts.inventory.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long role_id;
    private String userName;
    private String role;
  
	public Long getId() {
		return role_id;
	}
	public void setId(Long id) {
		this.role_id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
    
}
