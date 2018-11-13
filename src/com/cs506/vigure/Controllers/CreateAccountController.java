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
@RequestMapping("/signup")
public class CreateAccountController {

	// injecting DAO for DB access
	@Autowired
	private LoginDAO loginDAO;
	
	public CreateAccountController() {	
	}
		
	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginPage() {
		return "createAccount";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerUser(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("bio") String bio,
			@RequestParam("COI") String coi) {
				
		if(loginDAO.register(email, username, password)) {
			return "main";
		}
		
		return "home";
	}
}
