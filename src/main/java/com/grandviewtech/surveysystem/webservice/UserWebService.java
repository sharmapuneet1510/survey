package com.grandviewtech.surveysystem.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.User;

@Service
@Path("userWebService")
public class UserWebService
	{
		@Path("/getAllUser")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public List<User> getAllUser()
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
	}
