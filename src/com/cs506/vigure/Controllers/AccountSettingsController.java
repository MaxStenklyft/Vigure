package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
@RequestMapping("/settings")
public class AccountSettingsController {
	
	// injecting DAO for DB access
	@Autowired
	private UserDAO userDao;
	

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadUserSettingsPage(HttpSession session) {
		if(!validate(session)) return new ModelAndView("loginSignUp");
		long ID = (long)session.getAttribute("userID");
		ModelAndView mav = new ModelAndView("settings");
		UserEntity user = userDao.searchForEntityById(ID);
		mav.addObject("id", user);
		return mav;
	}


	@RequestMapping(value = "/updateSettings" , method = RequestMethod.POST)
	public ModelAndView changeUserSettings(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("COI") String cat_interests, 
			@RequestParam("bio") String bio,
			HttpSession session) {
		if(!validate(session)) return new ModelAndView("loginSignUp");
		long ID = (long)session.getAttribute("userID");
		userDao.updateUserSettings(username, ID, cat_interests, bio);
		
		return new ModelAndView("redirect:/settings");
	}

	
	public boolean validate(HttpSession session) {
		if(session.getAttribute("userID") == null) return false;
		
		UserEntity user = userDao.searchForEntityById((long)session.getAttribute("userID"));
		if(user == null) {
			return false;
		}
		return true;
	}
}
