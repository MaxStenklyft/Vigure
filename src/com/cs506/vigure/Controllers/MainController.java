package com.cs506.vigure.Controllers;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

@Controller
public class MainController {
	
	private UserEntity userModel;

	public void loadHomePage(UserEntity userModel) {
		// TODO
		this.userModel = userModel;
	}
	
	public void loadDebateCreationModel() {
		//TODO
	}
	
	public void sendDebateRequest(DebateEntity debateModel) {
		//TODO
	}
	
	public void getPreviousDebates() {
		//TODO use list of debate IDs to retrieve debate models from database and return list
		ArrayList<Long> previousDebateIDs = userModel.getPreviousDebates();
		ArrayList<DebateEntity> previousDebates = new ArrayList<DebateEntity>();
		
		for (Long id : previousDebateIDs) {
			//lookup debate in database
		}
	}
	
	public void getUpcomingDebates() {
		//TODO use list of debate IDs to retrieve debate models from database and return list
		ArrayList<Long> upcomingDebateIDs = userModel.getUpcomingDebates();
		ArrayList<DebateEntity> upcomingDebates = new ArrayList<DebateEntity>();
		
		for (Long id : upcomingDebateIDs) {
			//lookup debate in database
		}
	}
	
	public void getUserInfo() {
		//TODO
	}
}
