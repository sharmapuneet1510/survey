package com.grandviewtech.surveysystem.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grandviewtech.surveysystem.entity.bo.Credential;
import com.grandviewtech.surveysystem.entity.bo.SurveySession;
import com.grandviewtech.surveysystem.entity.bo.User;
import com.grandviewtech.surveysystem.service.business.CredentialService;
import com.grandviewtech.surveysystem.service.business.UserService;
import com.grandviewtech.surveysystem.service.utility.RedisSession;
import com.grandviewtech.surveysystem.service.utility.ValidationService;

@Controller
public class PageController
	{
		private final static org.slf4j.Logger	logger	= org.slf4j.LoggerFactory.getLogger(PageController.class);
														
		@Value("${PAGE_BLOG}")
		public String							PAGE_BLOG;
												
		@Value("${PAGE_HOME}")
		public String							PAGE_HOME;
												
		@Value("${PAGE_ERROR}")
		public String							PAGE_ERROR;
												
		@Value("${PAGE_WELCOME}")
		public String							PAGE_WELCOME;
												
		@Value("${PAGE_WELCOME_1}")
		public String							PAGE_WELCOME_1;
												
		@Value("${PAGE_INDEX}")
		public String							PAGE_INDEX;
												
		@Value("${PAGE_DESIGNER}")
		public String							PAGE_DESIGNER;
												
		@Value("${PAGE_CATALOG}")
		public String							PAGE_CATALOG;
												
		@Value("${PAGE_SUPPLIER}")
		public String							PAGE_SUPPLIER;
												
		@Autowired
		private RedisSession					redisSession;
												
		@RequestMapping(value = "/welcome")
		public String welcome()
			{
				//return  PAGE_WELCOME;
				return PAGE_WELCOME;
			}
			
		@RequestMapping(value = "/home")
		public String home(@RequestParam("clientId") String clientId)
			{
				if ((clientId == null) || (clientId.trim().length() == 0))
					{
						return "redirect:" + welcome();
					}
				SurveySession surveySession = redisSession.get(clientId);
				if (surveySession == null)
					{
						logger.info("Invalid ClientId : " + clientId);
						return "redirect:" + welcome();
					}
				return PAGE_HOME;
			}
			
		@RequestMapping(value = "/suppliers")
		public String supplier(@RequestParam("clientId") String clientId)
			{
				if ((clientId == null) || (clientId.trim().length() == 0))
					{
						return "redirect:" + welcome();
					}
				SurveySession surveySession = redisSession.get(clientId);
				if (surveySession == null)
					{
						logger.info("Invalid ClientId : " + clientId);
						return "redirect:" + welcome();
					}
				return PAGE_SUPPLIER;
			}
			
		@RequestMapping(value = "/catalogs")
		public String catalog(@RequestParam("clientId") String clientId)
			{
				if ((clientId == null) || (clientId.trim().length() == 0))
					{
						return "redirect:" + welcome();
					}
				SurveySession surveySession = redisSession.get(clientId);
				if (surveySession == null)
					{
						logger.info("Invalid ClientId : " + clientId);
						return "redirect:" + welcome();
					}
				return PAGE_CATALOG;
			}
			
		@RequestMapping(value = "/blog")
		public String blog()
			{
				return PAGE_BLOG;
			}
			
		@RequestMapping(value = "/index")
		public String index()
			{
				return PAGE_INDEX;
			}
			
		@RequestMapping(value = "/designer")
		public String designer()
			{
				return PAGE_DESIGNER;
			}
			
		@Autowired
		private UserService			userService;
									
		@Autowired
		private CredentialService	credentialService;
									
		@RequestMapping(value = "authenticate/register", method = RequestMethod.POST)
		public @ResponseBody String register(@RequestBody User user)
			{
				user = ValidationService.validateUser(user);
				String username = user.getEmailAddress();
				Credential credential = credentialService.findByUsername(username);
				if (credential == null)
					{
						user = userService.save(user);
						credential = new Credential();
						credential.setPassword(user.getEmailAddress());
						credential.setUsername(username);
						credential.setUser(user);
						credentialService.save(credential);
					}
				return PAGE_HOME;
			}
			
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String home(Locale locale, Model model)
			{
				logger.info("Welcome home! The client locale is {}.", locale);
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				String formattedDate = dateFormat.format(new Date());
				model.addAttribute("serverTime", formattedDate);
				return PAGE_WELCOME;
			}
			
		@RequestMapping(value = "/null", method = RequestMethod.GET)
		public String welcome(Locale locale, Model model)
			{
				logger.info("Welcome home! The client locale is {}.", locale);
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				String formattedDate = dateFormat.format(new Date());
				model.addAttribute("serverTime", formattedDate);
				return PAGE_WELCOME;
			}
			
	}