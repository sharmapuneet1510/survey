package com.grandviewtech.surveysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController
	{

		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String getLoginPage()
			{
				return "redirect:/pg/login1.html";
			}

		@RequestMapping(value = "/test", method = RequestMethod.GET)
		public String getTest1()
			{
				return "tes";
			}

		@RequestMapping(value = "/register")
		public String getRegistration()
			{
				return "redirect:test";
			}

	}
