package com.grandviewtech.surveysystem.service.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.grandviewtech.surveysystem.entity.bo.Supplier;

@Repository("supplierRepository")
public interface SupplierRepository extends MongoRepository<Supplier, String>
	{
		Supplier findBySupplierNameIgnoreCase(String supplierName);

		Supplier findBySupplierId(String supplierId);

	}
