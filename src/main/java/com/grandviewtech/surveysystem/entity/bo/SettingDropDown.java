package com.grandviewtech.surveysystem.entity.bo;

public class SettingDropDown
	{
		private int		id;
		private String	labelName;
		private String	className;
		private String	url;
		private boolean	separator	= false;
									
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:48:15 pm <br>
		 * @methodName : getLabelName <br>
		 * @Description : <br>
		 * @return the labelName
		 */
		public String getLabelName()
			{
				return labelName;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:48:15 pm <br>
		 * @methodName : setLabelName <br>
		 * @Description : <br>
		 * @param labelName
		 *            the labelName to set
		 */
		public void setLabelName(String labelName)
			{
				this.labelName = labelName;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:48:15 pm <br>
		 * @methodName : getClassName <br>
		 * @Description : <br>
		 * @return the className
		 */
		public String getClassName()
			{
				return className;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:48:15 pm <br>
		 * @methodName : setClassName <br>
		 * @Description : <br>
		 * @param className
		 *            the className to set
		 */
		public void setClassName(String className)
			{
				this.className = className;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:48:15 pm <br>
		 * @methodName : getUrl <br>
		 * @Description : <br>
		 * @return the url
		 */
		public String getUrl()
			{
				return url;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:48:15 pm <br>
		 * @methodName : setUrl <br>
		 * @Description : <br>
		 * @param url
		 *            the url to set
		 */
		public void setUrl(String url)
			{
				this.url = url;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:54:58 pm <br>
		 * @methodName : isSeparator <br>
		 * @Description : <br>
		 * @return the separator
		 */
		public boolean isSeparator()
			{
				return separator;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 1:54:58 pm <br>
		 * @methodName : setSeparator <br>
		 * @Description : <br>
		 * @param separator
		 *            the separator to set
		 */
		public void setSeparator(boolean separator)
			{
				this.separator = separator;
			}
			
		public SettingDropDown()
			{
				super();
				// TODO Auto-generated constructor stub
			}
			
		public SettingDropDown(int id, String labelName, String className, String url, boolean separator)
			{
				super();
				this.id = id;
				this.labelName = labelName;
				this.className = className;
				this.url = url;
				this.separator = separator;
				if (className.equalsIgnoreCase("disabled"))
					{
						this.url = "#";
					}
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 2:09:59 pm <br>
		 * @methodName : getId <br>
		 * @Description : <br>
		 * @return the id
		 */
		public int getId()
			{
				return id;
			}
			
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 2:09:59 pm <br>
		 * @methodName : setId <br>
		 * @Description : <br>
		 * @param id
		 *            the id to set
		 */
		public void setId(int id)
			{
				this.id = id;
			}
			
	}
