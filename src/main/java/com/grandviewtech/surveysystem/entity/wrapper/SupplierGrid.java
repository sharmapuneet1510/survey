package com.grandviewtech.surveysystem.entity.wrapper;

import java.io.Serializable;
import java.util.List;

import com.grandviewtech.surveysystem.entity.bo.Supplier;

public class SupplierGrid implements Serializable
	{
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:35:53 pm <br>
		 * @Description :
		 */
		private static final long	serialVersionUID	= 4664693530249038596L;
		private Supplier			supplier;
		private List<String>		supplierActions;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:35:34 pm <br>
		 * @methodName : getSupplier <br>
		 * @Description : <br>
		 * @return the supplier
		 */
		public Supplier getSupplier()
			{
				return supplier;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:35:34 pm <br>
		 * @methodName : setSupplier <br>
		 * @Description : <br>
		 * @param supplier
		 *            the supplier to set
		 */
		public void setSupplier(Supplier supplier)
			{
				this.supplier = supplier;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:35:34 pm <br>
		 * @methodName : getSupplierAction <br>
		 * @Description : <br>
		 * @return the supplierAction
		 */
		public List<String> getSupplierActions()
			{
				return supplierActions;
			}

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 24-Apr-2016 <br>
		 * @createdTime : 7:35:34 pm <br>
		 * @methodName : setSupplierAction <br>
		 * @Description : <br>
		 * @param supplierAction
		 *            the supplierAction to set
		 */
		public void setSupplierActions(List<String> supplierActions)
			{
				this.supplierActions = supplierActions;
			}

	}
