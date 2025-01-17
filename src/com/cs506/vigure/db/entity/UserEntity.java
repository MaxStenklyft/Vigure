package com.cs506.vigure.db.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_model")
public class UserEntity { // this represents the user_model table in db

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="picture")
	private String image;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="bio")
	private String bio;
	
	@Column(name="categoricalInterest")
	private String categoricalInterest;

	public UserEntity(int id, String username, String bio, String coi) {
		this.id = id;
		this.userName = username;
		this.bio = bio;
		this.categoricalInterest = coi;
	}
	
	public UserEntity(){}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getCategoricalInterest() {
		return categoricalInterest;
	}

	public void setCategoricalInterest(String categoricalInterest) {
		this.categoricalInterest = categoricalInterest;
	}

}
