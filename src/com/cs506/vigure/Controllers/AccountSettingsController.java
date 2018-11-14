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
		return "loginSignUp";
	}
	
	public void changeUserSettings() {
		//TODO
	}
}
