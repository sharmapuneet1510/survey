package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.grandviewtech.surveysystem.entity.enums.Status;

@Document(collection = "Supplier")
public class Supplier implements Serializable
	{
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:39 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID	= 1447501574084317338L;
		@Id
		private String				id;

		private String				supplierId;

		@Indexed
		private String				supplierName;

		private String				suplierWebSite;

		private String				displayName;

		private String				description;

		private String				industry;

		private Status				status;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
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
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
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
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : getSupplierName <br>
		 * @Description : <br>
		 * @return the supplierName
		 */
		public String getSupplierName()
			{
				return supplierName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : setSupplierName <br>
		 * @Description : <br>
		 * @param supplierName
		 *            the supplierName to set
		 */
		public void setSupplierName(String supplierName)
			{
				this.supplierName = supplierName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : getSuplierWebSite <br>
		 * @Description : <br>
		 * @return the suplierWebSite
		 */
		public String getSuplierWebSite()
			{
				return suplierWebSite;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : setSuplierWebSite <br>
		 * @Description : <br>
		 * @param suplierWebSite
		 *            the suplierWebSite to set
		 */
		public void setSuplierWebSite(String suplierWebSite)
			{
				this.suplierWebSite = suplierWebSite;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : getDisplayName <br>
		 * @Description : <br>
		 * @return the displayName
		 */
		public String getDisplayName()
			{
				return displayName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : setDisplayName <br>
		 * @Description : <br>
		 * @param displayName
		 *            the displayName to set
		 */
		public void setDisplayName(String displayName)
			{
				this.displayName = displayName;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : getDescription <br>
		 * @Description : <br>
		 * @return the description
		 */
		public String getDescription()
			{
				return description;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : setDescription <br>
		 * @Description : <br>
		 * @param description
		 *            the description to set
		 */
		public void setDescription(String description)
			{
				this.description = description;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : getIndustry <br>
		 * @Description : <br>
		 * @return the industry
		 */
		public String getIndustry()
			{
				return industry;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Apr-2016 <br>
		 * @createdTime : 4:27:27 pm <br>
		 * @methodName : setIndustry <br>
		 * @Description : <br>
		 * @param industry
		 *            the industry to set
		 */
		public void setIndustry(String industry)
			{
				this.industry = industry;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Apr-2016 <br>
		 * @createdTime : 1:33:37 pm <br>
		 * @methodName : getSupplierId <br>
		 * @Description : <br>
		 * @return the supplierId
		 */
		public String getSupplierId()
			{
				return supplierId;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Apr-2016 <br>
		 * @createdTime : 1:33:37 pm <br>
		 * @methodName : setSupplierId <br>
		 * @Description : <br>
		 * @param supplierId
		 *            the supplierId to set
		 */
		public void setSupplierId(String supplierId)
			{
				this.supplierId = supplierId;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Apr-2016 <br>
		 * @createdTime : 2:42:38 pm <br>
		 * @methodName : getStatus <br>
		 * @Description : <br>
		 * @return the status
		 */
		public Status getStatus()
			{
				return status;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 23-Apr-2016 <br>
		 * @createdTime : 2:42:38 pm <br>
		 * @methodName : setStatus <br>
		 * @Description : <br>
		 * @param status
		 *            the status to set
		 */
		public void setStatus(Status status)
			{
				this.status = status;
			}

		public Date createdDate;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:43:09 pm <br>
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
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:43:09 pm <br>
		 * @methodName : setCreatedDate <br>
		 * @Description : <br>
		 * @param createdDate
		 *            the createdDate to set
		 */
		public void setCreatedDate(Date createdDate)
			{
				this.createdDate = createdDate;
			}

	}
