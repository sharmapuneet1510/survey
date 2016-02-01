package com.grandviewtech.surveysystem.service.business.impls;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.Credential;
import com.grandviewtech.surveysystem.service.business.CredentialService;
import com.grandviewtech.surveysystem.service.dao.CredentialRepository;

@Service("credentialService")
//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
public class CredentialServiceImpl implements CredentialService
	{
		private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CredentialService.class);
		
		@PostConstruct
		public void UserWebServicePostConstruct()
			{
				String start = "\t\t*********************************************************************\n";
				String message = "\n\n" + start + "\t\t\t\tLoading CredentialService" + "\n" + start + "\n\n";
				logger.info(message);
			}
			
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
