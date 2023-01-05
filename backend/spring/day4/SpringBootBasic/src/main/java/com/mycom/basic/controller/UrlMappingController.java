package com.mycom.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 그냥 컨트롤러면 html 파일을 내려준다 생각하면 됨
@Controller
public class UrlMappingController {

	@RequestMapping("/hello") // value 생략
	public String m1() {
		System.out.println("/hello");
//	      return "hello"; // Circular view path [hello]
		return "hello.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	// => @GetMapping
	// => RequestMethod.POST => @PostMapping url을 통한 이동은 get방식이므로 경고가 뜸
	public String m3() {
		System.out.println("/get");
		return "login.html";
	}

	@RequestMapping("/urlMappingRest")
	public String urlMappingRest() {
		return "urlmappingRest.html";
	}


}
