package com.mycom.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController

/*
 *  
 * 
 */
public class HomeController {

	
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}

	@RequestMapping("/home")
	public String home() {
		System.out.println("home.html");
		return "home.html";
	}
//	@RequestMapping("/login")
//	public String login() {
//		System.out.println("login.html");
//		return "login.html";
//	}
	
}
