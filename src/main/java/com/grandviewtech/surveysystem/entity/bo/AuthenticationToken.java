package com.grandviewtech.surveysystem.entity.bo;

public class AuthenticationToken
	{
		private String	key;
		private String	token;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 25-Dec-2015 <br>
		 * @createdTime : 8:28:29 pm <br>
		 * @methodName : getKey <br>
		 * @Description : <br>
		 * @return the key
		 */
		public String getKey()
			{
				return key;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 25-Dec-2015 <br>
		 * @createdTime : 8:28:29 pm <br>
		 * @methodName : setKey <br>
		 * @Description : <br>
		 * @param key
		 *            the key to set
		 */
		public void setKey(String key)
			{
				this.key = key;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 25-Dec-2015 <br>
		 * @createdTime : 8:28:29 pm <br>
		 * @methodName : getToken <br>
		 * @Description : <br>
		 * @return the token
		 */
		public String getToken()
			{
				return token;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 25-Dec-2015 <br>
		 * @createdTime : 8:28:29 pm <br>
		 * @methodName : setToken <br>
		 * @Description : <br>
		 * @param token
		 *            the token to set
		 */
		public void setToken(String token)
			{
				this.token = token;
			}

		public AuthenticationToken(String key, String token)
			{
				super();
				this.key = key;
				this.token = token;
			}

		public AuthenticationToken()
			{
				super();
			}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString()
			{
				return "AuthenticationKey [key=" + key + ", token=" + token + "]";
			}

	}
