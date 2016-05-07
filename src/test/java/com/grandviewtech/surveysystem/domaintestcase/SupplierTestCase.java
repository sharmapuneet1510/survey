package com.grandviewtech.surveysystem.domaintestcase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.grandviewtech.surveysystem.entity.bo.Supplier;
import com.grandviewtech.surveysystem.entity.enums.Status;
import com.grandviewtech.surveysystem.service.business.SupplierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
@WebAppConfiguration
public class SupplierTestCase
	{
		@Autowired
		private SupplierService supplierService;

		@Test
		public void addSupplier()
			{
				Supplier supplier = new Supplier();
				supplier.setDisplayName("ACC Cement");
				supplier.setDescription("ACC Cement Supplier , Supplier Material for Real estate Development");
				supplier.setSuplierWebSite("www.acccement.com");
				supplier.setSupplierName("ACC Cement1");
				supplier.setIndustry("Construction");
				supplier.setStatus(Status.INACTIVE);
				supplierService.addSupplier(supplier);
			}

		@Test
		public void addUpdateSupplier()
			{
				Supplier supplier = new Supplier();
				supplier.setSupplierId("b421c180-80bb-4ac1-bd3a-1b6977d2d4db");
				supplier.setDisplayName("L & T");
				supplier.setDescription("L&T Supplier , Supplier Material for Real estate Development");
				supplier.setSuplierWebSite("www.lntinotect.com");
				supplier.setSupplierName("Larsen And Tubro");
				supplier.setIndustry("Construction");
				supplier.setStatus(Status.ACTIVE);
				supplierService.addSupplier(supplier);
			}

		@Test
		public void findSupplier()
			{
				String supplierName = "Larsen And Tubro";
				Supplier supplier = supplierService.findSupplierBySupplierName(supplierName);
				boolean result = false;
				if (supplier != null)
					{
						result = supplier.getSupplierName().trim().equalsIgnoreCase(supplierName.trim());
					}
				org.junit.Assert.assertTrue("Supplier with SupplierName : " + supplierName + " was not found.", result);
			}

		@Test
		public void deleteAllSupplier()
			{
				supplierService.deleteAllSupplier();
			}

		@Test
		public void addMultipleSupplier()
			{
				int m = 500;
				for (int i = 1; i <= m; i++)
					{
						Supplier supplier = new Supplier();
						supplier.setDisplayName("ACC Cement");
						supplier.setDescription("ACC Cement Supplier , Supplier Material for Real estate Development");
						supplier.setSuplierWebSite("www.acccement.com");
						supplier.setSupplierName("ACC Cement1 " + System.nanoTime());
						supplier.setIndustry("Construction");
						if ((i % 2) == 0)
							{
								supplier.setStatus(Status.INACTIVE);
							}
						else if ((i % 9) == 0)
							{
								supplier.setStatus(Status.INPROGRESS);
							}
						else
							{
								supplier.setStatus(Status.ACTIVE);
							}
						supplierService.addSupplier(supplier);
					}
			}

	}
