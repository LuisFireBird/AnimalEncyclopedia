package com.luis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luis.dao.UserDAO;
import com.luis.entities.User;
import com.luis.entities.UserFormValidationGroup;


@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/createUserForm")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		return "createUserForm";
	}
	
	@PostMapping("/createUser")
	public String createUser(Model model,@Validated(com.luis.entities.UserFormValidationGroup.class) User user, BindingResult result) {
		if(result.hasErrors()) {
			return "createUserForm";
		}
		userDAO.createUser(user);
		return "createUser";
	}

}
