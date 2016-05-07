package com.grandviewtech.surveysystem.service.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.Supplier;
import com.grandviewtech.surveysystem.entity.wrapper.Page;
import com.grandviewtech.surveysystem.entity.wrapper.SupplierGrid;
import com.grandviewtech.surveysystem.service.business.SupplierService;

@Service("supplierWebService")
@Path("supplierWebService")
public class SupplierWebService
	{
		
		@Autowired
		private SupplierService supplierService;

		@POST
		@Path("/changeStatusOfSupplier")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public void changeStatusOfSupplier(@QueryParam("clientId") String clientId, @QueryParam("supplierId") String supplierId, @QueryParam("status") String status)
			{
				if (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("inactive"))
					{
						supplierService.changeStatusOfSupplier(supplierId, status);
					}
			}

		@GET
		@Path("/getSupplierBySupplierId")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Supplier getSupplierBySupplierId(@QueryParam("clientId") String clientId, @QueryParam("supplierId") String supplierId)
			{
				if ((supplierId == null) || (supplierId.trim().length() == 0))
					{
						return null;
					}
				return supplierService.findSupplierBySupplierId(supplierId);
			}

		@GET
		@Path("/getAllSupplier")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Page<SupplierGrid> getAllSupplier(@QueryParam("clientId") String clientId)
			{
				int currentPage = 1;
				int pageSize = 50;
				PageRequest pageRequest = new PageRequest(currentPage, pageSize);
				Page<SupplierGrid> gridPage = new Page<SupplierGrid>();
				org.springframework.data.domain.Page<Supplier> page = supplierService.findAll(pageRequest);
				List<SupplierGrid> supplierGrids = new ArrayList<SupplierGrid>();
				if (page.hasContent())
					{
						Iterator<Supplier> iterator = page.iterator();
						while (iterator.hasNext())
							{
								Supplier supplier = iterator.next();
								SupplierGrid supplierGrid = new SupplierGrid();
								List<String> supplierActions = new LinkedList<String>();
								if (supplier.getStatus() != null)
									{
										switch (supplier.getStatus())
											{
												case ACTIVE:
													{
														supplierActions.add("Edit");
														supplierActions.add("Add Catalog");
														supplierActions.add("Inactive");
														break;
													}
												case INACTIVE:
													{
														supplierActions.add("Active");
														break;
													}
												case INPROGRESS:
													{
														supplierActions.add("Notify");
														break;
													}
											}
									}
								supplierGrid.setSupplierActions(supplierActions);
								supplierGrid.setSupplier(supplier);
								supplierGrids.add(supplierGrid);
							}
						int pageNumber = currentPage;
						Set<Integer> pageNumbers = new LinkedHashSet<Integer>();
						while (pageNumber <= page.getTotalPages())
							{
								if (pageNumber <= (currentPage + 5))
									{
										pageNumbers.add(pageNumber);
									}
								if (pageNumber >= (page.getTotalPages() - 5))
									{
										pageNumbers.add(pageNumber);
									}
								pageNumber++;
							}
						gridPage.setPageNumbers(pageNumbers);
						gridPage.setPageSize(pageSize);
						gridPage.setPages(supplierGrids);
						gridPage.setHasNext(page.hasNext());
						gridPage.setCurrentPage(currentPage);
						gridPage.setStartIndex(((currentPage - 1) * pageSize) + 1);
						gridPage.setTotalPages(page.getTotalPages());
						return gridPage;
					}
				else
					{
						return gridPage;
					}
			}
	}
