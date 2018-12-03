package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;

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
	public ModelAndView loadUserPage( @PathVariable("username") String username,
			HttpSession currSession) {
		if(!validate(currSession)) return new ModelAndView("loginSignUp");
		ModelAndView mav = new ModelAndView("otherUser");
		UserEntity user = userDAO.searchForEntityByUserName(username);
		if(user == null) {
			return new ModelAndView("pageNotFound");
		}
		else {
			mav.addObject("otherUser", user);
		}
		return mav;
	}
	
	public void loadDebateCreationModel() {
		//TODO
	}
	
	public void sendDebateRequest() {
		//TODO
	}
	public boolean validate(HttpSession session) {
		if(session.getAttribute("userID") == null) return false;
		
		UserEntity user = userDAO.searchForEntityById((long)session.getAttribute("userID"));
		if(user == null) {
			return false;
		}
		return true;
	}
}
