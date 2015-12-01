package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@XmlRootElement
public class User implements Serializable
	{
		
		private static final long	serialVersionUID	= -5670860671364444820L;
														
		private String				id;
		private String				userId;
		private String				emailAddress;
		private String				password;
		private String				profilePic;
									
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : getId <br>
		 * @Description : <br>
		 * @return the id
		 */
		public String getId()
			{
				return id;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : setId <br>
		 * @Description : <br>
		 * @param id
		 *            the id to set
		 */
		public void setId(String id)
			{
				this.id = id;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : getUserId <br>
		 * @Description : <br>
		 * @return the userId
		 */
		public String getUserId()
			{
				return userId;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : setUserId <br>
		 * @Description : <br>
		 * @param userId
		 *            the userId to set
		 */
		public void setUserId(String userId)
			{
				this.userId = userId;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : getEmailAddress <br>
		 * @Description : <br>
		 * @return the emailAddress
		 */
		public String getEmailAddress()
			{
				return emailAddress;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : setEmailAddress <br>
		 * @Description : <br>
		 * @param emailAddress
		 *            the emailAddress to set
		 */
		public void setEmailAddress(String emailAddress)
			{
				this.emailAddress = emailAddress;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : getPassword <br>
		 * @Description : <br>
		 * @return the password
		 */
		public String getPassword()
			{
				return password;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : setPassword <br>
		 * @Description : <br>
		 * @param password
		 *            the password to set
		 */
		public void setPassword(String password)
			{
				this.password = password;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : getProfilePic <br>
		 * @Description : <br>
		 * @return the profilePic
		 */
		public String getProfilePic()
			{
				return profilePic;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 30-Nov-2015 <br>
		 * @createdTime : 6:34:24 pm <br>
		 * @methodName : setProfilePic <br>
		 * @Description : <br>
		 * @param profilePic
		 *            the profilePic to set
		 */
		public void setProfilePic(String profilePic)
			{
				this.profilePic = profilePic;
			}
			
	}
