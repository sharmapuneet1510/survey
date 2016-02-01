package com.grandviewtech.surveysystem.service.business.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.User;
import com.grandviewtech.surveysystem.service.business.UserService;
import com.grandviewtech.surveysystem.service.dao.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService
	{
		@Autowired
		private UserRepository userRepository;

		@Override
		public User save(User user)
			{
				return userRepository.save(user);
			}

		@Override
		public User findByEmailAddress(String emailaddress)
			{
				return userRepository.findByEmailAddress(emailaddress);
			}
	}
