package com.grandviewtech.surveysystem.entity.bo;

import java.io.Serializable;

public class FieldProperties implements Serializable
	{
		// TEXT
		private int	minLength;
		private int	maxLength;
		// NUMERIC
		private int	minValue;
		private int	maxValue;
		private int	decimalPrecision	= 0;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : getMinLength <br>
		 * @Description : <br>
		 * @return the minLength
		 */
		public int getMinLength()
			{
				return minLength;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : setMinLength <br>
		 * @Description : <br>
		 * @param minLength
		 *            the minLength to set
		 */
		public void setMinLength(int minLength)
			{
				this.minLength = minLength;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : getMaxLength <br>
		 * @Description : <br>
		 * @return the maxLength
		 */
		public int getMaxLength()
			{
				return maxLength;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : setMaxLength <br>
		 * @Description : <br>
		 * @param maxLength
		 *            the maxLength to set
		 */
		public void setMaxLength(int maxLength)
			{
				this.maxLength = maxLength;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : getMinValue <br>
		 * @Description : <br>
		 * @return the minValue
		 */
		public int getMinValue()
			{
				return minValue;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : setMinValue <br>
		 * @Description : <br>
		 * @param minValue
		 *            the minValue to set
		 */
		public void setMinValue(int minValue)
			{
				this.minValue = minValue;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : getMaxValue <br>
		 * @Description : <br>
		 * @return the maxValue
		 */
		public int getMaxValue()
			{
				return maxValue;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : setMaxValue <br>
		 * @Description : <br>
		 * @param maxValue
		 *            the maxValue to set
		 */
		public void setMaxValue(int maxValue)
			{
				this.maxValue = maxValue;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : getDecimalPrecision <br>
		 * @Description : <br>
		 * @return the decimalPrecision
		 */
		public int getDecimalPrecision()
			{
				return decimalPrecision;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 17-Dec-2015 <br>
		 * @createdTime : 10:36:19 pm <br>
		 * @methodName : setDecimalPrecision <br>
		 * @Description : <br>
		 * @param decimalPrecision
		 *            the decimalPrecision to set
		 */
		public void setDecimalPrecision(int decimalPrecision)
			{
				this.decimalPrecision = decimalPrecision;
			}

	}
