package com.kindson.social;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome")
	public static String welcome() {
		return "Welcome to Spring Boot";
	}
	
	@RequestMapping(value = "/home")
	public static String home() {
		return "index";
	}

}