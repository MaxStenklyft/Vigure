package com.cs506.vigure.db.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_model")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@Column(name="bio")
	private String categoricalInterest;
	
	@Column(name="previousDebates")
	private ArrayList<Long> previousDebates;
	
	@Column(name="upcomingDebates")
	private ArrayList<Long> upcomingDebates;

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

	public ArrayList<Long> getPreviousDebates() {
		return previousDebates;
	}

	public void setPreviousDebates(ArrayList<Long> previousDebates) {
		this.previousDebates = previousDebates;
	}

	public ArrayList<Long> getUpcomingDebates() {
		return upcomingDebates;
	}

	public void setUpcomingDebates(ArrayList<Long> upcomingDebates) {
		this.upcomingDebates = upcomingDebates;
	}
}
