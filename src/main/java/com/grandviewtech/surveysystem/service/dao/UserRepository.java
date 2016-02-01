package com.grandviewtech.surveysystem.service.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grandviewtech.surveysystem.entity.bo.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, String>
	{
		User findByEmailAddress(String emailaddress);
	}
