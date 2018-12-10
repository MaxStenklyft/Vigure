package com.cs506.vigure.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs506.vigure.db.entity.UserEntity;

@Controller
@RequestMapping("/settings")
public class AccountSettingsController {
	
	private UserEntity user;

	@RequestMapping(method = RequestMethod.GET)
	public String loadUserSettingsPage() {
		return "settings";
	}


	@RequestMapping(value = "/updateSettings" , method = RequestMethod.POST)
	public String changeUserSettings(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("COI") String cat_interests, 
			@RequestParam("bio") String bio,
			HttpSession session) {
		
		userDAO.updateUserSettings(username, ID, cat_interests, bio);
		
		return "redirect:/settings";


	
	public void changeUserSettings() {
		//TODO

	}
}
