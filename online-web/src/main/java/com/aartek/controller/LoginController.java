package com.aartek.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aartek.model.UserDTO;
import com.aartek.model.UserRegistration;
import com.aartek.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginservice;

	@RequestMapping("/showlogin")
	public String message(Map<String, Object> map) {
		map.put("UserDTO", new UserDTO());
		return "login";
	}

	@RequestMapping("/verifylogin")
	public String verifylogin(@ModelAttribute("UserDTO") UserDTO login) {
		boolean validateLogin = false;
		System.out.println("hii");
		System.out.println("hello");
		System.out.println("--- Login Controller ----");
		System.out.println(login.getEmailId());
		System.out.println(login.getPassword());
		System.out.println("--- ------- ----");
		validateLogin = loginservice.validateService(login);
		System.out.println("login Value =" + validateLogin);
		if (validateLogin == true)
			return "welcome";
		else {
			return "login";
		}
	}
}