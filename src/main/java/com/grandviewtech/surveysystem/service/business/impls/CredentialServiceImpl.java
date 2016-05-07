package com.grandviewtech.surveysystem.service.business.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.Credential;
import com.grandviewtech.surveysystem.service.business.CredentialService;
import com.grandviewtech.surveysystem.service.dao.CredentialRepository;

@Service("credentialService")
public class CredentialServiceImpl implements CredentialService
	{
		//private final static org.slf4j.Logger	logger	= org.slf4j.LoggerFactory.getLogger(CredentialService.class);
		
		@Autowired
		private CredentialRepository credentialRepository;
		
		@Override
		public Credential save(Credential credential)
			{
				
				// TODO Auto-generated method stub
				// Step No 1  : validate Username
				Credential duplicateUser = credentialRepository.findByUsernameIgnoreCase(credential.getUsername());
				if (duplicateUser != null)
					{
						// Exception
					}
				return credentialRepository.save(credential);
				
			}
			
		@Override
		public Credential findByUsername(String username)
			{
				return credentialRepository.findByUsernameIgnoreCase(username);
			}
			
	}
