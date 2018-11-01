package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cs506.vigure.db.dao.LoginDAO;

@Controller
@RequestMapping("/login")
public class AccountController {

	// injecting DAO for DB access
	@Autowired
	private LoginDAO loginDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginPage() {
		return "loginSignUp";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session) {
		
		if(loginDAO.validateUser(username, password)) {
			session.setAttribute("username", username);
			return "testLoginSucc";
		}
		else {
			return "loginSignUp";
		}
		
		// basic test, credentials stored in .java file
		/*if(username.equalsIgnoreCase("acc1") && password.equalsIgnoreCase("123")) {
			session.setAttribute("username", username);
			return "testLoginSucc";
		} else {
			return "loginSignUp";
		}*/
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../";
	}
}
