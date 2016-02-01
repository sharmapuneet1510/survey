package com.grandviewtech.surveysystem.entity.bo;

public class SurveySession
	{
		private User		user;
		private Credential	credential;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 16-Jan-2016 <br>
		 * @createdTime : 12:43:31 pm <br>
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
		 * @createdDate : 16-Jan-2016 <br>
		 * @createdTime : 12:43:31 pm <br>
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
		 * @createdTime : 8:06:03 pm <br>
		 * @methodName : getCredential <br>
		 * @Description : <br>
		 * @return the credential
		 */
		public Credential getCredential()
			{
				return credential;
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Jan-2016 <br>
		 * @createdTime : 8:06:03 pm <br>
		 * @methodName : setCredential <br>
		 * @Description : <br>
		 * @param credential
		 *            the credential to set
		 */
		public void setCredential(Credential credential)
			{
				this.credential = credential;
			}

	}
