package com.cs506.vigure.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
public class OtherUserPageController {

	private UserEntity user;
	
	// injecting DAO for DB access
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public ModelAndView loadUserPage( @PathVariable("username") long username) {
		ModelAndView mav = new ModelAndView("other");
		
		return mav;
	}
	
	public void loadDebateCreationModel() {
		//TODO
	}
	
	public void sendDebateRequest() {
		//TODO
	}
}
