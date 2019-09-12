package com.luis.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String showLogin(Model model, @RequestParam(name = "error", required = false) String error, @RequestParam(name = "logout",required = false) String logout) {
		
		if(error!=null) {
			model.addAttribute("error", "your credentials are wrong");
		}
		
		if(logout!=null) {
			model.addAttribute("logout", "you've been logged out");
		}
		
		return "login";
	}
	
	@RequestMapping("/welcomePage")
	public String showWelcomePage(Model model,Principal principal) {
		model.addAttribute("welcomeName",principal.getName());
		return "welcomePage";
	}
	

}
