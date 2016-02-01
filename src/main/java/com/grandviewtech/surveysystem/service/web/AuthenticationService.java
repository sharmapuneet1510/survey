package com.grandviewtech.surveysystem.service.web;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;

import com.grandviewtech.surveysystem.entity.bo.AuthenticationToken;
import com.grandviewtech.surveysystem.entity.bo.Credential;

@Path("auth")
public class AuthenticationService
	{
		static Map<String, String> userId_authKey = new LinkedHashMap<String, String>();
		
		@POST
		@Path("/login")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response login(Credential credential)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				return responseBuilder.build();
			}
			
		@GET
		@Path("/getAuthKey")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAuthenticationKey(@QueryParam("key") String key)
			{
				String token = userId_authKey.get(key);
				if (token != null)
					{
						userId_authKey.remove(key);
					}
				token = UUID.randomUUID().toString();
				userId_authKey.put(key, token);
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				responseBuilder.status(Status.OK);
				responseBuilder.entity(new AuthenticationToken(key, token));
				return responseBuilder.build();
			}
			
		@GET
		@Path("/getAuthKeys")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAuthenticationKeyList(@QueryParam("accessKey") String accessKey)
			{
				com.grandviewtech.surveysystem.entity.bo.Response response = new com.grandviewtech.surveysystem.entity.bo.Response();
				Status status = Status.UNAUTHORIZED;
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((accessKey != null) && (accessKey.trim().length() > 0))
					{
						accessKey = accessKey.trim();
						if (accessKey.equals("3aefa438-fa3a-4453-85bb-27d799da040d"))
							{
								status = Status.OK;
								responseBuilder.status(status);
								responseBuilder.entity(userId_authKey);
								return responseBuilder.build();
							}
						else
							{
								status = Status.UNAUTHORIZED;
								responseBuilder.status(status);
								response.addKeyValue("exception", "invalid access key");
								response.addKeyValue("status", status.getReasonPhrase());
								response.addKeyValue("statusCode", status.getStatusCode() + "");
								responseBuilder.entity(response);
								return responseBuilder.build();
							}
					}
				else
					{
						status = Status.UNAUTHORIZED;
						responseBuilder.status(status);
						response.addKeyValue("exception", "invalid access key");
						response.addKeyValue("status", status.getReasonPhrase());
						response.addKeyValue("statusCode", status.getStatusCode() + "");
						responseBuilder.entity(response);
						return responseBuilder.build();
					}
			}
			
	}
