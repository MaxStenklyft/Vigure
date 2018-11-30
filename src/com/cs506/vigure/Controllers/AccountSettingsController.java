package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cs506.vigure.db.dao.LoginDAOImpl;
import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.dao.UserDAOImpl;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
@RequestMapping("/settings")
public class AccountSettingsController {
	
		// injecting DAO for DB access
		@Autowired
		private UserDAO userDAO;
		
		// Current user
		private UserEntity id;
		// Current userID
		private long ID;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadUserSettingsPage(HttpSession currSession) {
		ID = (long)currSession.getAttribute("userID");
		ModelAndView mv = new ModelAndView("settings");
		id = userDAO.searchForEntityById(ID);
		
		
		if(id == null) {
			return new ModelAndView("pageNotFound");
		}
		else {
			mv.addObject("id", id);
			
		}
		return mv;
	}

	@RequestMapping(value = "/updateSettings" , method = RequestMethod.POST)
	public void changeUserSettings(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("COI") String cat_interests, HttpSession session) {
		
		userDAO.updateUserSettings(username, ID, cat_interests);

	}
}
