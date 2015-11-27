package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;
import java.util.Date;

public class MetaData implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:29:52 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID	= 6269597386380045825L;

		private String				tenantId;
		private String				userId;
		private Date				lastModifiedDate;
		private Date				createdDate;

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
		 * @methodName : getTenantId <br>
		 * @Description : <br>
		 * @return the tenantId
		 */
		public String getTenantId()
			{
				return tenantId;
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
		 * @methodName : setTenantId <br>
		 * @Description : <br>
		 * @param tenantId
		 *            the tenantId to set
		 */
		public void setTenantId(String tenantId)
			{
				this.tenantId = tenantId;
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
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
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
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
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
		 * @methodName : getLastModifiedDate <br>
		 * @Description : <br>
		 * @return the lastModifiedDate
		 */
		public Date getLastModifiedDate()
			{
				return lastModifiedDate;
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
		 * @methodName : setLastModifiedDate <br>
		 * @Description : <br>
		 * @param lastModifiedDate
		 *            the lastModifiedDate to set
		 */
		public void setLastModifiedDate(Date lastModifiedDate)
			{
				this.lastModifiedDate = lastModifiedDate;
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
		 * @methodName : getCreatedDate <br>
		 * @Description : <br>
		 * @return the createdDate
		 */
		public Date getCreatedDate()
			{
				return createdDate;
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
		 * @methodName : setCreatedDate <br>
		 * @Description : <br>
		 * @param createdDate
		 *            the createdDate to set
		 */
		public void setCreatedDate(Date createdDate)
			{
				this.createdDate = createdDate;
			}

		/**
		 * <br>
		 * 
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:06 pm <br>
		 * @methodName : getSerialversionuid <br>
		 * @Description : <br>
		 * @return the serialversionuid
		 */
		public static long getSerialversionuid()
			{
				return serialVersionUID;
			}

	}
