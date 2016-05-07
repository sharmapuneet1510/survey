package com.grandviewtech.surveysystem.service.web;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.SettingDropDown;

@Service("uiWebService")
@Path("uiWebService")
public class UIWebService
	{
		@GET
		@Path("/getSettingsDropDown")
		@Consumes(value = MediaType.APPLICATION_JSON)
		@Produces(value = MediaType.APPLICATION_JSON)
		public List<SettingDropDown> getSettingDropDown(@QueryParam("clientId") String clientId)
			{
				List<SettingDropDown> settings = new LinkedList<SettingDropDown>();
				settings.add(new SettingDropDown(1, "Supplier's", "", "suppliers?clientId=" + clientId, false));
				settings.add(new SettingDropDown(2, "Catalog's", "", "catalogs?clientId=" + clientId, false));
				settings.add(new SettingDropDown(3, "separator", "divider", "", true));
				settings.add(new SettingDropDown(3, "User's", "disabled", "users?clientId=" + clientId, false));
				return settings;
			}
	}
