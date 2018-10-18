package com.cs506.vigure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@RequestMapping("/")
	public String showPage() {
		return "helloworld";
	}
}
