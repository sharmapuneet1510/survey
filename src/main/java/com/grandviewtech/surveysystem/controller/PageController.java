package com.grandviewtech.surveysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
	{
		
		@RequestMapping(value = "/login")
		public String getLoginPage()
			{
				return "login";
			}
			
	}
