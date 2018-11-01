package com.cs506.vigure.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_model")
public class LoginEntity { // this represents the login_model table in the db

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUsername(String newUserName) {
		this.userName = newUserName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
}
