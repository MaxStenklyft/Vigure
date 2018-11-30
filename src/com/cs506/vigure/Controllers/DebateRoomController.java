package com.cs506.vigure.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs506.vigure.db.entity.DebateEntity;

@Controller
@RequestMapping("/debateRoom")
public class DebateRoomController {

	private DebateEntity debateModel;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadDebatePage() {
		ModelAndView mav = new ModelAndView("startTime");
		mav.addObject("startTime", debateModel.getStartTime().getTime());
		return "debateRoom";
	}
}
