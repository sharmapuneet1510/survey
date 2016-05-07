package com.grandviewtech.surveysystem.service.business.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.Credential;
import com.grandviewtech.surveysystem.service.business.CredentialService;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService

	{

		@Autowired
		private CredentialService credentialService;

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
			{
				Credential user = credentialService.findByUsername(username);
				return null;
			}

	}
