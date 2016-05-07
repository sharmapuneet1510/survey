package com.grandviewtech.surveysystem.service.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.impl.ResponseBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.Credential;
import com.grandviewtech.surveysystem.entity.bo.SurveySession;
import com.grandviewtech.surveysystem.entity.bo.User;
import com.grandviewtech.surveysystem.entity.bo.UserLoginInfo;
import com.grandviewtech.surveysystem.service.business.CredentialService;
import com.grandviewtech.surveysystem.service.business.UserService;
import com.grandviewtech.surveysystem.service.utility.RedisSession;
import com.grandviewtech.surveysystem.service.utility.SurveySessionHolder;
import com.grandviewtech.surveysystem.service.utility.Util;
import com.grandviewtech.surveysystem.service.utility.ValidationService;

@Path("userWebService")
@Service("userWebService")
@PropertySource("classpath:application.properties")
public class UserWebService
	{

		@Value("${surveySystemFileRepos}")
		private String					surveySystemFileRepos;

		@Value("${serverImageUrl}")
		private String					serverImageUrl;

		final static org.slf4j.Logger	logger	= org.slf4j.LoggerFactory.getLogger(UserWebService.class);

		@Autowired
		private CredentialService		credentialService;

		@Autowired
		private UserService				userService;

		@Autowired
		private RedisSession			redisSession;

		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 10-Jan-2016 <br>
		 * @createdTime : 2:22:07 pm <br>
		 * @methodName : registerUser <br>
		 * @methodPackage : com.grandviewtech.surveysystem.service.web <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param user
		 *            <br>
		 * @return
		 */
		@POST
		@Path("/registerUser")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response registerUser(User user)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				user = ValidationService.validateUser(user);
				String username = user.getEmailAddress();
				Credential credential = credentialService.findByUsername(username);
				if (credential == null)
					{
						user.setUserId(Util.getUUID("userId"));
						user = userService.save(user);
						credential = new Credential();
						credential.setPassword(user.getPassword());
						credential.setUsername(username);
						credential.setUser(user);
						credentialService.save(credential);
						Map<String, String> objects = new LinkedHashMap<String, String>();
						String sessionId = SurveySessionHolder.getSessionId();
						SurveySession surveySession = new SurveySession();
						surveySession.setUser(user);
						SurveySessionHolder.putSession(sessionId, surveySession);
						redisSession.put(sessionId, surveySession);
						objects.put("clientId", sessionId);
						responseBuilder.entity(objects);
						responseBuilder.status(Status.OK);
					}
				else
					{
						responseBuilder.status(Status.CONFLICT);
					}
				return responseBuilder.build();
			}

		@GET
		@Path("getUser")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response getUser(@QueryParam("clientId") String sessionId)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				SurveySession surveySession = SurveySessionHolder.getSession(sessionId);
				if (surveySession != null)
					{
						String emailAddress = surveySession.getCredential().getUsername();
						User user = userService.findByEmailAddress(emailAddress);
						responseBuilder.entity(user);
						responseBuilder.status(Status.OK);
						return responseBuilder.build();
					}
				responseBuilder.status(Status.UNAUTHORIZED);
				return responseBuilder.build();
			}

		@GET
		@Path("getHomeScreenDropDrow")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response getHomeScreenDropDrow(@QueryParam("clientId") String sessionId)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				SurveySession surveySession = SurveySessionHolder.getSession(sessionId);
				if (surveySession != null)
					{
						Map<String, Object> homeScreenMenu = new LinkedHashMap<String, Object>();
						List<String> userAccountOption = new ArrayList<String>();
						User user = surveySession.getUser();
						homeScreenMenu.put("user", user);
						userAccountOption.add("My Account");
						userAccountOption.add("Subscription Plan");
						homeScreenMenu.put("accountOption", userAccountOption);
						responseBuilder.entity(homeScreenMenu);
						responseBuilder.status(Status.OK);
						return responseBuilder.build();
					}
				responseBuilder.status(Status.UNAUTHORIZED);
				return responseBuilder.build();
			}

		@POST
		@Path("login")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response login(Credential credential)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if (credential == null)
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				String username = credential.getUsername();
				String password = credential.getPassword();
				Map<String, String> error = new LinkedHashMap<String, String>();
				if ((username == null) || (username.trim().length() == 0) || (password == null) || (username.trim().length() == 0))
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				credential = credentialService.findByUsername(username);
				if (credential == null)
					{
						error.put("error", "Invalid Username !! ");
						responseBuilder.entity(error);
						responseBuilder.status(Status.UNAUTHORIZED);
						return responseBuilder.build();
					}
				if (credential.isAccountLocked() == true)
					{
						error.put("error", "User Account Locked !! ");
						responseBuilder.entity(error);
						responseBuilder.status(Status.UNAUTHORIZED);
						return responseBuilder.build();
					}
				String existingPassword = credential.getPassword();
				if (existingPassword.trim().equals(password.trim()))
					{
						credential.setNumberOfInvalidAttempt(0);
						credentialService.save(credential);
						Map<String, String> objects = new LinkedHashMap<String, String>();
						String sessionId = SurveySessionHolder.getSessionId();
						SurveySession surveySession = new SurveySession();
						surveySession.setCredential(credential);
						surveySession.setUser(credential.getUser());
						SurveySessionHolder.putSession(sessionId, surveySession);
						redisSession.put(sessionId, surveySession);
						objects.put("clientId", sessionId);
						responseBuilder.entity(objects);
						responseBuilder.status(Status.OK);
						return responseBuilder.build();
					}
				else
					{
						int numberOfInvalidAttempt = credential.getNumberOfInvalidAttempt() + 1;
						if (numberOfInvalidAttempt >= 5)
							{
								credential.setAccountLocked(true);
							}
						credential.setNumberOfInvalidAttempt(numberOfInvalidAttempt);
						credentialService.save(credential);
						error.put("error", "Invalid password !! ");
						responseBuilder.entity(error);
						responseBuilder.status(Status.UNAUTHORIZED);
						return responseBuilder.build();
					}
			}

		@POST
		@Path("logout")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response logout(@QueryParam("clientId") String sessionId)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				SurveySession surveySession = SurveySessionHolder.getSession(sessionId);

				if (surveySession != null)
					{
						Credential credential = surveySession.getCredential();
						credential.setLastLogin(new Date());
						credentialService.save(credential);
					}

				if (SurveySessionHolder.remove(sessionId) == true)
					{
						redisSession.deleteKey(sessionId);
						responseBuilder.status(Status.OK);
						return responseBuilder.build();
					}
				else
					{
						responseBuilder.status(Status.EXPECTATION_FAILED);
						return responseBuilder.build();
					}
			}

		@GET
		@Path("getUserLoginInfo")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response getUserLoginInfo(@QueryParam("clientId") String sessionId)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				SurveySession surveySession = SurveySessionHolder.getSession(sessionId);
				if (surveySession != null)
					{
						Credential credential = surveySession.getCredential();
						User user = surveySession.getUser();
						UserLoginInfo userLoginInfo = new UserLoginInfo();
						userLoginInfo.setFirstName(user.getFirstName());
						userLoginInfo.setEmailAddress(user.getEmailAddress());
						userLoginInfo.setLastName(user.getLastName());
						Date lastLogin = credential.getLastLogin();
						if (lastLogin != null)
							{
								userLoginInfo.setLastLogin(lastLogin.toString());
							}
						responseBuilder.entity(userLoginInfo);
						responseBuilder.encoding("UTF-8");
						responseBuilder.status(Status.OK);
						return responseBuilder.build();
					}
				responseBuilder.status(Status.UNAUTHORIZED);
				return responseBuilder.build();
			}

		@POST
		@Path("/updateUser")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateUser(@QueryParam("clientId") String sessionId, User user)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				SurveySession surveySession = SurveySessionHolder.getSession(sessionId);
				if (surveySession != null)
					{
						String emailAddress = surveySession.getUser().getEmailAddress();
						User existingUser = userService.findByEmailAddress(emailAddress);
						if ((existingUser.getUserId() == null) || (existingUser.getUserId().trim().length() == 0))
							{
								existingUser.setUserId(Util.getUUID("userId"));
							}
						existingUser.setFirstName(user.getFirstName());
						existingUser.setLastName(user.getLastName());
						existingUser.setMiddleName(user.getMiddleName());
						existingUser = userService.save(existingUser);
						SurveySessionHolder.udpate(sessionId, existingUser);
						responseBuilder.entity(existingUser);
						responseBuilder.status(Status.OK);
						return responseBuilder.build();
					}
				responseBuilder.status(Status.UNAUTHORIZED);
				return responseBuilder.build();
			}

		@POST
		@Path("/uploadProfilePic")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		public Response uploadFile(@QueryParam("clientId") String sessionId, List<Attachment> attachments, @Context HttpServletRequest request)
			{
				ResponseBuilder responseBuilder = new ResponseBuilderImpl();
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						responseBuilder.status(Status.PRECONDITION_FAILED);
						return responseBuilder.build();
					}
				SurveySession surveySession = SurveySessionHolder.getSession(sessionId);
				if (surveySession != null)
					{
						for (Attachment attachment : attachments)
							{
								DataHandler handler = attachment.getDataHandler();
								try
									{
										InputStream stream = handler.getInputStream();
										MultivaluedMap<String, String> header = attachment.getHeaders();
										String userId = surveySession.getUser().getUserId();
										String fileName = surveySystemFileRepos + File.separator + userId;
										File file = new File(fileName);
										if (file.exists() == false)
											{
												file.mkdirs();
											}
										String imageName = getFileName(header);
										String finalPath = fileName + File.separator + imageName;
										File img = new File(finalPath);
										if (img.exists())
											{
												img.delete();
											}
										OutputStream out = new FileOutputStream(img);
										int read = 0;
										byte[] bytes = new byte[1024];
										while ((read = stream.read(bytes)) != -1)
											{
												out.write(bytes, 0, read);
											}
										stream.close();
										out.flush();
										out.close();
										String imageUrl = serverImageUrl + File.separator + userId + File.separator + imageName;
										String emailAddress = surveySession.getUser().getEmailAddress();
										User user = userService.findByEmailAddress(emailAddress);
										user.setProfilePic(imageUrl);
										user = userService.save(user);
										responseBuilder.entity(user);
										SurveySessionHolder.udpate(sessionId, user);
									}
								catch (Exception e)
									{
										e.printStackTrace();
									}

							}
						responseBuilder.status(Status.OK);
						return responseBuilder.build();
					}
				responseBuilder.status(Status.UNAUTHORIZED);
				return responseBuilder.build();
			}

		private String getFileName(MultivaluedMap<String, String> header)
			{
				String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
				for (String filename : contentDisposition)
					{
						if ((filename.trim().startsWith("name")))
							{
								String[] name = filename.split("=");
								String exactFileName = name[1].trim().replaceAll("\"", "");
								return exactFileName;
							}
					}
				return "unknown";
			}

	}
