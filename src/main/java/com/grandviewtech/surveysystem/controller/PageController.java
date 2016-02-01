package com.grandviewtech.surveysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grandviewtech.surveysystem.constants.Page;
import com.grandviewtech.surveysystem.entity.bo.SurveySession;
import com.grandviewtech.surveysystem.service.utility.SurveySessionHolder;

@Controller
public class PageController
	{
		
		@RequestMapping(value = "/welcome")
		public String welcome()
			{
				return Page.PAGE_WELCOME;
			}
			
		@RequestMapping(value = "/home")
		public String home(@RequestParam("clientId") String clientId)
			{
				if ((clientId == null) || (clientId.trim().length() == 0))
					{
						//return Page.PAGE_ERROR;
						return "redirect:" + welcome();
					}
				SurveySession surveySession = SurveySessionHolder.getSession(clientId);
				if (surveySession == null)
					{
						//return Page.PAGE_ERROR;
						return "redirect:" + welcome();
					}
				return Page.PAGE_HOME;
			}
			
		@RequestMapping(value = "/blog")
		public String blog()
			{
				return Page.PAGE_BLOG;
			}
			
		@RequestMapping(value = "/index")
		public String index()
			{
				return Page.PAGE_INDEX;
			}
			
	}