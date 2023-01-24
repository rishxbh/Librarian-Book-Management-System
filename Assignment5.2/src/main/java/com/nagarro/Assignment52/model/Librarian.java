package com.nagarro.Assignment52.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Librarian {
	@Id
	String username;
	String userpassword;
	@Column(name = "full_name")
	String fullName;
	public Librarian(String username, String password, String fullName) {
		super();
		this.username = username;
		this.userpassword = password;
		this.fullName = fullName;
	}
	public Librarian() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return userpassword;
	}
	public void setPassword(String password) {
		this.userpassword = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
