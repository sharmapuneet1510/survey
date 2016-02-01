package com.grandviewtech.surveysystem.service.business;

import com.grandviewtech.surveysystem.entity.bo.Credential;

public interface CredentialService
	{
		public Credential save(Credential credential);

		public Credential findByUsername(String username);
	}
