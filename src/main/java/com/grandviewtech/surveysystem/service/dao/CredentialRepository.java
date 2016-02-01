package com.grandviewtech.surveysystem.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grandviewtech.surveysystem.entity.bo.Credential;

@Repository("credentialRepository")
public interface CredentialRepository extends MongoRepository<Credential, String>
	{
		Credential findByUsernameIgnoreCase(String username);
	}
