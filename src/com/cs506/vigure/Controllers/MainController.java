package com.cs506.vigure.Controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.cs506.vigure.db.dao.DebateDAO;
import com.cs506.vigure.db.dao.LoginDAO;
import com.cs506.vigure.db.dao.UserDAO;
import com.cs506.vigure.db.entity.DebateEntity;
import com.cs506.vigure.db.entity.UserEntity;

import Enums.DebateStatusEnum;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class MainController {
	
	
	public MainController(){
		
	}
	
	// injecting DAO for DB access
	@Autowired
	private DebateDAO debateDao;
	
	// injecting DAO for DB access
	@Autowired
	private UserDAO userDao;

	@Transactional
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadMainPage(HttpSession currSession) {
		if(!validate(currSession)) return new ModelAndView("loginSignUp");
		UserEntity user = userDao.searchForEntityById((long)currSession.getAttribute("userID"));
		ModelAndView mav = new ModelAndView("main");
		List<DebateEntity> debates = debateDao.getUsersDebates(user.getId());
		mav.addObject("debates", debates);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/searchUsers", method = RequestMethod.POST)
	public String searchUsers(
		@RequestParam("users") String users,
		HttpSession session) {
		
		return "redirect:/user/"+users;		
	}
	
	@Transactional
	@RequestMapping(value = "/sendDebateRequest", method = RequestMethod.POST)
	public ModelAndView sendDebateRequest(
			@RequestParam("roomTitle") String roomTitle,
			@RequestParam("debateTopic") String debateTopic,
			@RequestParam("opponent") String opponent,
			@RequestParam("scheduledTime") String scheduledTime,
			@RequestParam("speakingInterval") String speakingInterval,
			@RequestParam("rounds") String rounds,
			HttpSession session) {
		if(!validate(session)) return new ModelAndView("loginSignUp");
		
		List<String> errors = new ArrayList<>();
		ModelAndView mav = new ModelAndView("main");
		
		
		DebateEntity debate = new DebateEntity();
		errors.addAll(validateRoomTitle(roomTitle, debate));
		errors.addAll(validateDebateTopic(debateTopic, debate));
		errors.addAll(validateOpponent(opponent, debate));
		errors.addAll(validateScheduledTime(scheduledTime, debate));
		errors.addAll(validateSpeakingInterval(speakingInterval, debate));
		errors.addAll(validateRounds(rounds, debate));
		debate.setInstigatorNum((long)session.getAttribute("userID"));
		
		if(errors.size() == 0) {
			debateDao.sendDebateRequest(debate);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(errors.toArray());
		mav.addObject("errors", sb.toString());
		return new ModelAndView("redirect:/main");
	}
	
	public List<DebateEntity> getDebates(long userId) {
		//TODO use list of debate IDs to retrieve debate models from database and return list
		ArrayList<DebateEntity> previousDebates = new ArrayList<DebateEntity>();
		
		return debateDao.getUsersDebates(userId);
		
	}
	
	private List<String> validateRounds(String rounds, DebateEntity debate) {
		List<String> errors = new ArrayList<>();
		if(rounds != null && rounds.length() >= 1) {
			try {
				int numRounds = Integer.parseInt(rounds);
				debate.setRounds(numRounds);
			}
			catch(NumberFormatException e) {
				errors.add("Rounds input was not recognized as a valid number");
			}
		}
		else {
			errors.add("Please enter the desired number of rounds");
		}
		return errors;
	}
	
	private List<String> validateDebateTopic(String debateTopic, DebateEntity debate) {
		List<String> errors = new ArrayList<>();
		if(debateTopic == null || debateTopic.length() < 1) errors.add("Please Enter a Debate Topic");
		else {
			debate.setTopic(debateTopic);
		}
		return errors;
	}
	
	private List<String> validateOpponent(String opponent, DebateEntity debate) {
		List<String> errors = new ArrayList<>();
		if(opponent == null || opponent.length() < 1) {
			errors.add("Please Enter an Opponents Username");
		}
		else {
			//int opponentId = userDAO.getUserID(opponent);TODO IMPLEMENT USER DAO
			int opponentId = 1;
			if(-1 == opponentId) {
				errors.add("Entered Opponent does not exist, please check spelling");
			}
			else {
				debate.setDefenderNum(opponentId);
			}
		}
		return errors;
	}
	
	private List<String> validateScheduledTime(String time, DebateEntity debate) {
		List<String> errors = new ArrayList<>();
		if(time == null || time.length() < 1) {
			errors.add("Please Enter a time and date for the debate");
		}
		else {
			//TODO Convert time to SQL format
			//TODO Check if time is in the future
			//TODO Add converted time to debate Entity
			Calendar today = Calendar.getInstance();
			today.set(Calendar.YEAR, 2020);
			debate.setStartTime(today.getTime());
		}
		
		return errors;
	}
	
	private List<String> validateRoomTitle(String roomTitle, DebateEntity debate) {
		List<String> errors = new ArrayList<>();
		if(roomTitle == null || roomTitle.length() < 1) {
			errors.add("Please Enter a Title for the Debate Room");
		}
		else {
			debate.setTitle(roomTitle);
		}
		
		
		return errors;
	}
	
	private List<String> validateSpeakingInterval(String speakingInterval, DebateEntity debate) {
		List<String> errors = new ArrayList<>();
		
		if(speakingInterval == null || speakingInterval.length() < 1) {
			errors.add("Please Enter a Title for the Debate Room");
		}
		else {
			try {
				int timeInterval = Integer.parseInt(speakingInterval);
				debate.setTimeInterval(timeInterval);
			} catch(NumberFormatException e) {
				errors.add("Unrecognized Time Interval.");
			}
			
		}

		return errors;
	}
	
	public boolean validate(HttpSession session) {
		if(session.getAttribute("userID") == null) return false;
		
		UserEntity user = userDao.searchForEntityById((long)session.getAttribute("userID"));
		if(user == null) {
			return false;
		}
		return true;
	}
}
