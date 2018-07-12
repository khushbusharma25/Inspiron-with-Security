package com.sts.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
//@NamedQuery(name = "UserDTO.findByUsernameAndpassword",
//query = "select u from UserDTO u where u.userName = ?1 AND u.password = ?2")
//@NamedQuery(name="UserDTO.searchByfName",
//query="select u from UserDTO u where u.fName like %?1 ")

public class UserDTO {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long user_id;
	
	@Column(name="first_name")
	private String fName;
	
	@Column(name="last_name")
	private String lName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String  address;
	
	@Column(name="cont_no")
	private String contNo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="role")
	private String role;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContNo() {
		return contNo;
	}
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	
	

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + user_id + ", fName=" + fName + ", lName=" + lName + ", age=" + age + ", email=" + email
				+ ", address=" + address + ", contNo=" + contNo + ", description=" + description + ", role=" + role
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
