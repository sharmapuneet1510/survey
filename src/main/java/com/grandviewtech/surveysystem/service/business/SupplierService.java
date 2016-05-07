package com.grandviewtech.surveysystem.service.business;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.grandviewtech.surveysystem.entity.bo.Supplier;

public interface SupplierService
	{
		
		public void changeStatusOfSupplier(String supplierId, String status);

		public Supplier addSupplier(Supplier supplier);

		public Supplier findSupplierBySupplierName(String supplierName);

		public Supplier findSupplierBySupplierId(String supplierId);

		public void deleteSupplierBySupplierName(String supplierName);

		public void deleteSupplierBySupplierId(String supplierId);

		public void deleteAllSupplier();

		public Page<Supplier> findAll(Pageable pageable);
	}
