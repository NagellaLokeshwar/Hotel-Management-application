package com.example.springboot4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private String id;
	private String username;
	private String password;
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phoneNo=" + phoneNo + "]";
	}
	private String email;
	private String phoneNo;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String username, String password, String email, String phoneNo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getUsername() {
		return username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
