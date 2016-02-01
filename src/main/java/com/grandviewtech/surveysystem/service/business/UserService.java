package com.grandviewtech.surveysystem.service.business;

import com.grandviewtech.surveysystem.entity.bo.User;

public interface UserService
	{
		
		User save(User user);
		
		User findByEmailAddress(String emailAddress);
		
	}
