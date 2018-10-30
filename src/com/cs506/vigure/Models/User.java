package com.cs506.vigure.Models;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String firstName;
	private String lastName;
	private String image;
	private long id;
	private String userName;
	private String bio;
	private String categoricalInterest;
	
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
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
