package com.grandviewtech.surveysystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grandviewtech.surveysystem.entity.bo.User;

@RestController
public class UserController
	{
		@ResponseBody
		@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET, consumes = { "application/json" }, produces = { "application/json" }, headers = { "Content-Type" })
		public List<User> getAllUsers()
			{
				List<User> users = new ArrayList<User>();
				for (int i = 0; i < 10; i++)
					{
						User user = new User();
						user.setId(UUID.randomUUID().toString());
						user.setUserId("userId_" + UUID.randomUUID());
						user.setEmailAddress(System.currentTimeMillis() + "@gmail.com");
						if ((i % 2) == 0)
							{
								user.setProfilePic("http://localhost:8080/surveySystem/pg/images/female.png");
							}
						else
							{
								user.setProfilePic("http://localhost:8080/surveySystem/pg/images/male.png");
							}
						user.setPassword("**********");
						users.add(user);
					}
				return users;
			}
			
		@ResponseBody
		@RequestMapping(value = "/getUser", method = RequestMethod.GET, consumes = { "application/json" }, produces = { "application/json" })
		public User getUser()
			{
				User user = new User();
				user.setId(UUID.randomUUID().toString());
				user.setUserId("userId_" + UUID.randomUUID());
				user.setEmailAddress(System.currentTimeMillis() + "@gmail.com");
				user.setProfilePic("http://localhost:8080/surveySystem/pg/images/male.png");
				user.setPassword("**********");
				return user;
			}
			
	}
