package com.cs506.vigure.Controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs506.vigure.Models.Debate;
import com.cs506.vigure.Models.User;

@Controller
@RequestMapping("/main")
public class MainController {
	
	private User userModel;

	@RequestMapping(method = RequestMethod.GET)
	public String loadHomePage(User userModel) {
		// TODO
		this.userModel = userModel;
		return "main";
	}
	
	public void loadDebateCreationModel() {
		//TODO
	}
	
	public void sendDebateRequest(Debate debateModel) {
		//TODO
	}
	
	public void getPreviousDebates() {
		//TODO use list of debate IDs to retrieve debate models from database and return list
		ArrayList<Long> previousDebateIDs = userModel.getPreviousDebates();
		ArrayList<Debate> previousDebates = new ArrayList<Debate>();
		
		for (Long id : previousDebateIDs) {
			//lookup debate in database
		}
	}
	
	public void getUpcomingDebates() {
		//TODO use list of debate IDs to retrieve debate models from database and return list
		ArrayList<Long> upcomingDebateIDs = userModel.getUpcomingDebates();
		ArrayList<Debate> upcomingDebates = new ArrayList<Debate>();
		
		for (Long id : upcomingDebateIDs) {
			//lookup debate in database
		}
	}
	
	public void getUserInfo() {
		//TODO
	}
}
