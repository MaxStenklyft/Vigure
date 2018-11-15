package com.cs506.vigure.Controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	public AccountController() {
		
	}
	
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
		
		String hashedPassword = hashPassword(password);
		password = null;
		
		if(hashedPassword != null && loginDAO.validateUser(username, hashedPassword)) {
			long currUserID = loginDAO.getUsernameID(username);
			session.setAttribute("userID", currUserID);
			return "main";
		}
		else {
			return "loginSignUp";
		}
		
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../";
	}
	
	private String hashPassword(String password) {
		String hashedPassword = null;
		
		try {
			// begin password hashing
			// Create MessageDigest instance for MD5
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        //Add password bytes to digest
	        md.update(password.getBytes());
	        //Get the hash's bytes
	        byte[] bytes = md.digest();
	        //This bytes[] has bytes in decimal format;
	        //Convert it to hexadecimal format
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        //Get complete hashed password in hex format
	        hashedPassword = sb.toString();	
	        password = null;
		}
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
		
		return hashedPassword;
	}
}
