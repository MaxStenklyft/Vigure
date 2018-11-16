package com.cs506.vigure.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
public class OtherUserPageController {

	private UserEntity user;
	
	// injecting DAO for DB access
	@Autowired
	private UserDAO userDAO;
	
	
	public void loadUserPage() {
		//TODO
	}
	
	public void loadDebateCreationModel() {
		//TODO
	}
	
	public void sendDebateRequest() {
		//TODO
	}
}
