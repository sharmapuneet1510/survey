package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "user")
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable
	{

		private static final long	serialVersionUID	= -5670860671364444820L;

		@Id
		private String				id;
		private String				userId;
		private String				emailAddress;
		private String				password;
		private String				firstName;
		private String				middleName;
		private String				lastName;
		private String				profilePic;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
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
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
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
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
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
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
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
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
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
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
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
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
		 * @methodName : getFirstName <br>
		 * @Description : <br>
		 * @return the firstName
		 */
		public String getFirstName()
			{
				return firstName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
		 * @methodName : setFirstName <br>
		 * @Description : <br>
		 * @param firstName
		 *            the firstName to set
		 */
		public void setFirstName(String firstName)
			{
				this.firstName = firstName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
		 * @methodName : getMiddleName <br>
		 * @Description : <br>
		 * @return the middleName
		 */
		public String getMiddleName()
			{
				return middleName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
		 * @methodName : setMiddleName <br>
		 * @Description : <br>
		 * @param middleName
		 *            the middleName to set
		 */
		public void setMiddleName(String middleName)
			{
				this.middleName = middleName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
		 * @methodName : getLastName <br>
		 * @Description : <br>
		 * @return the lastName
		 */
		public String getLastName()
			{
				return lastName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
		 * @methodName : setLastName <br>
		 * @Description : <br>
		 * @param lastName
		 *            the lastName to set
		 */
		public void setLastName(String lastName)
			{
				this.lastName = lastName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
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
		 * @createdDate : 14-Jan-2016 <br>
		 * @createdTime : 12:04:54 pm <br>
		 * @methodName : setProfilePic <br>
		 * @Description : <br>
		 * @param profilePic
		 *            the profilePic to set
		 */
		public void setProfilePic(String profilePic)
			{
				this.profilePic = profilePic;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Jan-2016 <br>
		 * @createdTime : 10:49:03 pm <br>
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
		 * @createdDate : 26-Jan-2016 <br>
		 * @createdTime : 10:49:03 pm <br>
		 * @methodName : setUserId <br>
		 * @Description : <br>
		 * @param userId
		 *            the userId to set
		 */
		public void setUserId(String userId)
			{
				this.userId = userId;
			}

	}
