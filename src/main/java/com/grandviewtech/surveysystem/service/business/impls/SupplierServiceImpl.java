package com.grandviewtech.surveysystem.service.business.impls;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.Supplier;
import com.grandviewtech.surveysystem.entity.enums.Status;
import com.grandviewtech.surveysystem.service.business.SupplierService;
import com.grandviewtech.surveysystem.service.dao.SupplierRepository;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService
	{
		@Autowired
		private SupplierRepository supplierRepository;

		@Override
		public Supplier addSupplier(Supplier supplier)
			{
				String supplierName = supplier.getSupplierName();
				String supplierId = supplier.getSupplierId();
				Supplier exitingSupplier = null;
				boolean isSupplierById = false;
				if ((supplierId != null) && (supplierId.trim().length() > 0))
					{
						exitingSupplier = findSupplierBySupplierId(supplierId);
						isSupplierById = true;
					}
				else
					{
						supplierId = UUID.randomUUID().toString();
						exitingSupplier = findSupplierBySupplierName(supplierName);
					}
				if (exitingSupplier != null)
					{
						if (isSupplierById)
							{
								exitingSupplier.setSupplierName(supplierName);
							}
						else
							{
								exitingSupplier.setSupplierId(supplierId);
							}
						exitingSupplier.setDescription(supplier.getDescription());
						exitingSupplier.setDisplayName(supplier.getDisplayName());
						exitingSupplier.setIndustry(supplier.getIndustry());
						exitingSupplier.setSuplierWebSite(supplier.getSuplierWebSite());
						if (supplier.getStatus() != null)
							{
								exitingSupplier.setStatus(supplier.getStatus());
							}
						return supplierRepository.save(exitingSupplier);
					}
				else
					{
						supplier.setSupplierId(supplierId);
						supplier.setCreatedDate(new Date());
						return supplierRepository.save(supplier);
					}

			}

		@Override
		public Supplier findSupplierBySupplierName(String supplierName)
			{
				return supplierRepository.findBySupplierNameIgnoreCase(supplierName);
			}

		@Override
		public Supplier findSupplierBySupplierId(String supplierId)
			{
				return supplierRepository.findBySupplierId(supplierId);
			}

		@Override
		public void deleteSupplierBySupplierName(String supplierName)
			{
				Supplier supplier = findSupplierBySupplierName(supplierName);
				supplierRepository.delete(supplier.getSupplierId());
			}

		@Override
		public void deleteSupplierBySupplierId(String supplierId)
			{
				Supplier supplier = findSupplierBySupplierId(supplierId);
				supplierRepository.delete(supplier.getSupplierId());
			}

		@Override
		public void deleteAllSupplier()
			{
				List<Supplier> suppliers = supplierRepository.findAll();
				supplierRepository.delete(suppliers);
			}

		@Override
		public Page<Supplier> findAll(Pageable pageable)
			{
				Page<Supplier> page = supplierRepository.findAll(pageable);
				return page;
			}

		@Override
		public void changeStatusOfSupplier(String supplierId, String status)
			{
				Status updatedStatus = null;
				if (status.trim().equalsIgnoreCase(Status.ACTIVE.getStatus().trim()))
					{
						updatedStatus = Status.ACTIVE;
					}
				else if (status.trim().equalsIgnoreCase(Status.INACTIVE.getStatus().trim()))
					{
						updatedStatus = Status.INACTIVE;
					}
				Supplier exitingSupplier = findSupplierBySupplierId(supplierId);
				exitingSupplier.setStatus(updatedStatus);
				supplierRepository.save(exitingSupplier);
			}

	}
