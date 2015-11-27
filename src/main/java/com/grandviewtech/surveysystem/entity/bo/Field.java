package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.grandviewtech.surveysystem.entity.enums.FieldType;

@Document(collection = "Field")
public class Field implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:20:52 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID	= -5719407035448796686L;

		private MetaData			metaData;

		private String				fieldUniqueName;

		private FieldType			fieldType;

		private FieldProperties		fieldProperties;
									
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : getMetaData <br>
		 * @Description : <br>
		 * @return the metaData
		 */
		public MetaData getMetaData()
			{
				return metaData;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : setMetaData <br>
		 * @Description : <br>
		 * @param metaData the metaData to set
		 */
		public void setMetaData(MetaData metaData)
			{
				this.metaData = metaData;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : getFieldUniqueName <br>
		 * @Description : <br>
		 * @return the fieldUniqueName
		 */
		public String getFieldUniqueName()
			{
				return fieldUniqueName;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : setFieldUniqueName <br>
		 * @Description : <br>
		 * @param fieldUniqueName the fieldUniqueName to set
		 */
		public void setFieldUniqueName(String fieldUniqueName)
			{
				this.fieldUniqueName = fieldUniqueName;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : getFieldType <br>
		 * @Description : <br>
		 * @return the fieldType
		 */
		public FieldType getFieldType()
			{
				return fieldType;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : setFieldType <br>
		 * @Description : <br>
		 * @param fieldType the fieldType to set
		 */
		public void setFieldType(FieldType fieldType)
			{
				this.fieldType = fieldType;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : getFieldProperties <br>
		 * @Description : <br>
		 * @return the fieldProperties
		 */
		public FieldProperties getFieldProperties()
			{
				return fieldProperties;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : setFieldProperties <br>
		 * @Description : <br>
		 * @param fieldProperties the fieldProperties to set
		 */
		public void setFieldProperties(FieldProperties fieldProperties)
			{
				this.fieldProperties = fieldProperties;
			}
			
		/**
		 * <br>
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:31:47 pm <br>
		 * @methodName : getSerialversionuid <br>
		 * @Description : <br>
		 * @return the serialversionuid
		 */
		public static long getSerialversionuid()
			{
				return serialVersionUID;
			}
			
	}
