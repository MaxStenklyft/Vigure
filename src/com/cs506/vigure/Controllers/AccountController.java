package com.cs506.vigure.Controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cs506.vigure.db.dao.DebateDAO;
import com.cs506.vigure.db.dao.LoginDAO;
import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
@RequestMapping("/login")
public class AccountController {

	public AccountController() {
		
	}
	
	// injecting DAO for DB access
	@Autowired
	private DebateDAO debateDao;
	
	// injecting DAO for DB access
	@Autowired
	private LoginDAO loginDAO;
	
	// injecting DAO for DB access
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginPage() {
		return "loginSignUp";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session) {
		
		String hashedPassword = hashPassword(password);
		password = null;
		
		if(hashedPassword != null && loginDAO.validateUser(username, hashedPassword)) {
			long currUserID = loginDAO.getUsernameID(username);
			session.setAttribute("userID", currUserID);

			UserEntity user = userDAO.searchForEntityById(currUserID);
			ModelAndView mav = new ModelAndView("main");
			List<DebateEntity> debates = debateDao.getUsersDebates(user.getId());
			mav.addObject("debates", debates);
			mav.addObject("user", user);
			return mav;
		}
		else {
			ModelAndView mav = new ModelAndView("loginSignUp");
			return mav;
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
