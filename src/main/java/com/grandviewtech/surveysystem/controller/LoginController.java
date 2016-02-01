package com.grandviewtech.surveysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grandviewtech.surveysystem.constants.Page;
import com.grandviewtech.surveysystem.entity.bo.Credential;
import com.grandviewtech.surveysystem.entity.bo.User;
import com.grandviewtech.surveysystem.service.business.CredentialService;
import com.grandviewtech.surveysystem.service.business.UserService;
import com.grandviewtech.surveysystem.service.utility.ValidationService;
import com.grandviewtech.surveysystem.service.web.UserWebService;

@Controller
@RequestMapping(value = "/authenticate")
public class LoginController
	{

		final static org.slf4j.Logger	logger	= org.slf4j.LoggerFactory.getLogger(UserWebService.class);

		@Autowired
		private UserService				userService;

		@Autowired
		private CredentialService		credentialService;

		@RequestMapping(value = "/register", method = RequestMethod.POST)
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
				return Page.PAGE_HOME;
			}

	}
