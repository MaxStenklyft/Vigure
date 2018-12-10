package com.cs506.vigure.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cs506.vigure.db.dao.DebateDAO;
import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
public class DebateRoomController {
	
	// injecting DAO for DB access
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private DebateDAO debateDAO;
	
	@RequestMapping(value = "/debateRoom/{debateID}", method = RequestMethod.GET)
	public ModelAndView loadDebatePage(@PathVariable("debateID") String debateID,
				HttpSession currSession) {
		//login validateion
		if(!validate(currSession)) return new ModelAndView("loginSignUp");
		
		//retrieve information on particular debate off of URL
		DebateEntity debate = debateDAO.getDebate(Long.parseLong(debateID));
		
		//validate logged in  user has right to access debate
		if(!validateRoom(currSession, debate)) return new ModelAndView("redirect:/main");
		
		
		ModelAndView mav = new ModelAndView("debateRoom");
		mav.addObject("debate", debate);
		return mav;
	}
	
	private boolean validateRoom(HttpSession currSession, DebateEntity debate) {
		if((long)currSession.getAttribute("userID") == debate.getDefenderNum() || 
				(long)currSession.getAttribute("userID") == debate.getInstigatorNum()) {
			return true;
		}
		return false;
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
