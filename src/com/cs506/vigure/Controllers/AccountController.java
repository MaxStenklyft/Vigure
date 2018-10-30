package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AccountController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "loginSignUp";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session) {
		if(username.equalsIgnoreCase("acc1") && password.equalsIgnoreCase("123")) {
			session.setAttribute("username", username);
			return "testLoginSucc";
		} else {
			return "loginSignUp";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../Vigure";
	}
}
