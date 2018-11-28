package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
@RequestMapping("/settings")
public class AccountSettingsController {
	
	// injecting DAO for DB access
		@Autowired
		private UserDAO userDAO;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadUserSettingsPage(HttpSession currSession) {
		
		ModelAndView mv = new ModelAndView("settings");
		UserEntity id = userDAO.searchForEntityById((long)currSession.getAttribute("userID"));
		
		
		
		if(id == null) {
			return new ModelAndView("pageNotFound");
		}
		else {
			mv.addObject("id", id);
			/*mv.addObject("firstName", id.getFirstName());
			mv.addObject("lastName", id.getLastName());
			mv.addObject("userName", id.getUserName());
			mv.addObject("interests", id.getCategoricalInterest());
			*/
			
		}
		return mv;
	}
	
	public void changeUserSettings() {
		//TODO
	}
}
