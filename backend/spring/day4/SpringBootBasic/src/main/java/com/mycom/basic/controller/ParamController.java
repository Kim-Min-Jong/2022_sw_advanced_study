package com.mycom.basic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.basic.dto.CarDto;

@RestController
public class ParamController {

	@GetMapping(value = "/param1")
	public Map<String, String> m1(HttpServletRequest request) { // request 직접 파라미터로
		String seq = request.getParameter("seq");
		System.out.println("param1 seq : " + seq);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}

	@GetMapping(value = "/param2")
	public Map<String, String> m2(String seq) {
		System.out.println("param2 seq : " + seq);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}

	// dto 객체 이용
	@GetMapping(value = "/car1")
	public Map<String, String> m4(String name, int price) {
		System.out.println("name : " + name);
		System.out.println("price : " + price);
		CarDto dto = new CarDto(name, price, "");
		System.out.println(dto);

		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}

	// dto 에 default constructor 가 있어야 된다. 테스트( 어라? 또 되네.. )
	@GetMapping(value = "/car2")
	public Map<String, String> m5(CarDto dto) {
		System.out.println("CarDto name : " + dto.getName()); // dto의 property 개념으로 처리 // dto.getName2 로 변경한 후 테스트
		System.out.println("CarDto price : " + dto.getPrice());
		System.out.println("CarDto owner : " + dto.getOwner());

		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}

	@GetMapping(value = "/session")
	public Map<String, String> m6(CarDto dto, HttpSession session) {
		System.out.println(dto);
		session.setAttribute("carDto", dto);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
	@GetMapping(value = "/session2")
	public Map<String, String> m7(HttpSession session) {
		System.out.println("session2");
		CarDto dto = (CarDto)session.getAttribute("carDto");
		System.out.println(dto);
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map; 
	}
}
