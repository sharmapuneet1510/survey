package com.grandviewtech.surveysystem.entity.enums;

public enum ExceptionCode
	{

		ExceptionCode101("E101", "Duplicate User");

		private String	code;
		private String	message;

		private ExceptionCode(String code, String message)
			{
				this.code = code;
				this.message = message;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:29:27 am <br>
		 * @methodName : getCode <br>
		 * @Description : <br>
		 * @return the code
		 */
		public String getCode()
			{
				return code;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Dec-2015 <br>
		 * @createdTime : 8:29:27 am <br>
		 * @methodName : getMessage <br>
		 * @Description : <br>
		 * @return the message
		 */
		public String getMessage()
			{
				return message;
			}

	}
