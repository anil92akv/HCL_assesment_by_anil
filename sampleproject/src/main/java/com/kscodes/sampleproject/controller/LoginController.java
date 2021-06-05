package com.kscodes.sampleproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kscodes.sampleproject.model.Login;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView getLoginPage() {
		return new ModelAndView("login", "command", new Login());
	}

	@RequestMapping(value = "/processLogin", method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("login") Login login) {

		String userName = login.getUserName();
		String password = login.getPassword();

		if ("admin".equalsIgnoreCase(userName)
				&& "admin123".equalsIgnoreCase(password)) {
			ModelAndView mv = new ModelAndView("success");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("error");
			return mv;
		}
	}
}
