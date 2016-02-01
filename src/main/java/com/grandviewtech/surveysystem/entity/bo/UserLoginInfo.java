package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserLoginInfo implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:13:02 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID	= -2642274921821625198L;
		private String				firstName;
		private String				lastName;
		private String				emailAddress;
		private List<String>		roles				= new ArrayList<String>();
		private List<String>		tabs				= new ArrayList<String>();
		private String				lastLogin;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:54:15 pm <br>
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
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:54:15 pm <br>
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
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:11:55 pm <br>
		 * @methodName : getRoles <br>
		 * @Description : <br>
		 * @return the roles
		 */
		public List<String> getRoles()
			{
				return roles;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:11:55 pm <br>
		 * @methodName : setRoles <br>
		 * @Description : <br>
		 * @param roles
		 *            the roles to set
		 */
		public void setRoles(List<String> roles)
			{
				this.roles = roles;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:11:55 pm <br>
		 * @methodName : getTabs <br>
		 * @Description : <br>
		 * @return the tabs
		 */
		public List<String> getTabs()
			{
				return tabs;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:11:55 pm <br>
		 * @methodName : setTabs <br>
		 * @Description : <br>
		 * @param tabs
		 *            the tabs to set
		 */
		public void setTabs(List<String> tabs)
			{
				this.tabs = tabs;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:11:55 pm <br>
		 * @methodName : getLastLogin <br>
		 * @Description : <br>
		 * @return the lastLogin
		 */
		public String getLastLogin()
			{
				return lastLogin;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:11:55 pm <br>
		 * @methodName : setLastLogin <br>
		 * @Description : <br>
		 * @param lastLogin
		 *            the lastLogin to set
		 */
		public void setLastLogin(String lastLogin)
			{
				this.lastLogin = lastLogin;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 10:11:01 pm <br>
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
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 10:11:01 pm <br>
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
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 10:12:41 pm <br>
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
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 10:12:41 pm <br>
		 * @methodName : setEmailAddress <br>
		 * @Description : <br>
		 * @param emailAddress
		 *            the emailAddress to set
		 */
		public void setEmailAddress(String emailAddress)
			{
				this.emailAddress = emailAddress;
			}

	}
