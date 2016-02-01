package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection = "credential")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Credential implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 16-Jan-2016 <br>
		 * @createdTime : 10:42:24 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID		= -8075013711307271254L;
		@Id
		private String				id;
		private String				username;
		private String				password;
		private User				user;
		private Date				lastLogin;
		private boolean				isAccountLocked;
		private int					numberOfInvalidAttempt	= 0;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:08:25 am <br>
		 * @methodName : getUsername <br>
		 * @Description : <br>
		 * @return the username
		 */
		public String getUsername()
			{
				return username;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:08:25 am <br>
		 * @methodName : setUsername <br>
		 * @Description : <br>
		 * @param username
		 *            the username to set
		 */
		public void setUsername(String username)
			{
				this.username = username;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:08:25 am <br>
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
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:08:25 am <br>
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
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:08:25 am <br>
		 * @methodName : getUser <br>
		 * @Description : <br>
		 * @return the user
		 */
		public User getUser()
			{
				return user;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:08:25 am <br>
		 * @methodName : setUser <br>
		 * @Description : <br>
		 * @param user
		 *            the user to set
		 */
		public void setUser(User user)
			{
				this.user = user;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:02:56 pm <br>
		 * @methodName : getLastLogin <br>
		 * @Description : <br>
		 * @return the lastLogin
		 */
		public Date getLastLogin()
			{
				return lastLogin;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:02:56 pm <br>
		 * @methodName : setLastLogin <br>
		 * @Description : <br>
		 * @param lastLogin
		 *            the lastLogin to set
		 */
		public void setLastLogin(Date lastLogin)
			{
				this.lastLogin = lastLogin;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 31-Jan-2016 <br>
		 * @createdTime : 2:43:00 pm <br>
		 * @methodName : isAccountLocked <br>
		 * @Description : <br>
		 * @return the isAccountLocked
		 */
		public boolean isAccountLocked()
			{
				return isAccountLocked;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 31-Jan-2016 <br>
		 * @createdTime : 2:43:00 pm <br>
		 * @methodName : setAccountLocked <br>
		 * @Description : <br>
		 * @param isAccountLocked
		 *            the isAccountLocked to set
		 */
		public void setAccountLocked(boolean isAccountLocked)
			{
				this.isAccountLocked = isAccountLocked;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 31-Jan-2016 <br>
		 * @createdTime : 2:43:00 pm <br>
		 * @methodName : getNumberOfInvalidAttempt <br>
		 * @Description : <br>
		 * @return the numberOfInvalidAttempt
		 */
		public int getNumberOfInvalidAttempt()
			{
				return numberOfInvalidAttempt;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 31-Jan-2016 <br>
		 * @createdTime : 2:43:00 pm <br>
		 * @methodName : setNumberOfInvalidAttempt <br>
		 * @Description : <br>
		 * @param numberOfInvalidAttempt
		 *            the numberOfInvalidAttempt to set
		 */
		public void setNumberOfInvalidAttempt(int numberOfInvalidAttempt)
			{
				this.numberOfInvalidAttempt = numberOfInvalidAttempt;
			}

	}
