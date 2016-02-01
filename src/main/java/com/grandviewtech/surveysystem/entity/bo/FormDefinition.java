package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FormDefinition")
public class FormDefinition implements Serializable
	{

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 26-Nov-2015 <br>
		 * @createdTime : 12:33:12 pm <br>
		 * @Description :
		 */
		private static final long		serialVersionUID	= -7126378321958195385L;

		private Status					status;

		private List<FieldDefinition>	fieldDefinitions	= new ArrayList<FieldDefinition>();

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:31:10 pm <br>
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
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:31:10 pm <br>
		 * @methodName : setStatus <br>
		 * @Description : <br>
		 * @param status
		 *            the status to set
		 */
		public void setStatus(Status status)
			{
				this.status = status;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:31:10 pm <br>
		 * @methodName : getFieldDefinitions <br>
		 * @Description : <br>
		 * @return the fieldDefinitions
		 */
		public List<FieldDefinition> getFieldDefinitions()
			{
				return fieldDefinitions;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:31:10 pm <br>
		 * @methodName : setFieldDefinitions <br>
		 * @Description : <br>
		 * @param fieldDefinitions
		 *            the fieldDefinitions to set
		 */
		public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions)
			{
				this.fieldDefinitions = fieldDefinitions;
			}

	}
