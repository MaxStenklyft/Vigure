package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
@RequestMapping("/debateRoom")
public class DebateRoomController {
	
	// injecting DAO for DB access
	@Autowired
	private UserDAO userDAO;

	private DebateEntity debateModel;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadDebatePage(HttpSession currSession) {
		if(!validate(currSession)) return "loginSignUp";
		return "debateRoom";
	}
	
	public boolean validate(HttpSession session) {
		if(session.getAttribute("userID") == null) return false;
		
		UserEntity user = userDAO.searchForEntityById((long)session.getAttribute("userID"));
		if(user == null) {
			return false;
		}
		return true;
	}
}
