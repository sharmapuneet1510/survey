package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Response implements Serializable
	{
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 25-Dec-2015 <br>
		 * @createdTime : 10:45:43 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID	= -1528515553654303826L;
		private Map<String, Object>	keyValue			= new LinkedHashMap<String, Object>();
														
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 25-Dec-2015 <br>
		 * @createdTime : 10:46:13 pm <br>
		 * @methodName : getKeyValue <br>
		 * @Description : <br>
		 * @return the keyValue
		 */
		public Map<String, Object> getKeyValue()
			{
				return keyValue;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 25-Dec-2015 <br>
		 * @createdTime : 10:46:13 pm <br>
		 * @methodName : setKeyValue <br>
		 * @Description : <br>
		 * @param keyValue
		 *            the keyValue to set
		 */
		public void addKeyValue(String key, Object value)
			{
				this.keyValue.put(key, value);
			}
			
	}
