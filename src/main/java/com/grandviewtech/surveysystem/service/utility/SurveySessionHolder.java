package com.grandviewtech.surveysystem.service.utility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.grandviewtech.surveysystem.entity.bo.SurveySession;
import com.grandviewtech.surveysystem.entity.bo.User;

public class SurveySessionHolder
	{

		private static Map<String, SurveySession> sessionId_userSession = new LinkedHashMap<String, SurveySession>();

		// Map with Old Session
		/**
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 16-Jan-2016 <br>
		 * @createdTime : 12:45:48 pm <br>
		 * @methodName : putSession <br>
		 * @methodPackage : com.grandviewtech.surveysystem.service.utility <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param sessionId
		 *            <br>
		 * @param surveySession
		 */
		public static void putSession(String sessionId, SurveySession surveySession)
			{
				sessionId = validateSessionId(sessionId);
				if (sessionId == null)
					{
						return;
					}
				sessionId_userSession.put(sessionId, surveySession);
			}

		/***
		 * <br>
		 *
		 * @Author : puneetsharma <br>
		 * @createdDate : 16-Jan-2016 <br>
		 * @createdTime : 12:45:43 pm <br>
		 * @methodName : getSession <br>
		 * @methodPackage : com.grandviewtech.surveysystem.service.utility <br>
		 * @Description : <br>
		 * @StepsWithExplanation : <br>
		 * @TODO : <br>
		 * @param sessionId
		 *            <br>
		 * @return
		 */
		public static SurveySession getSession(String sessionId)
			{
				sessionId = validateSessionId(sessionId);
				if (sessionId == null)
					{
						return null;
					}
				return sessionId_userSession.get(sessionId);
			}

		public static String getSessionId()
			{
				String sessionId = "sessionId_" + UUID.randomUUID().toString();//+ System.nanoTime();
				sessionId = sessionId.replaceAll("-", "");
				return sessionId;
			}

		private static String validateSessionId(String sessionId)
			{
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						return null;
					}
				return sessionId.trim().toLowerCase();
			}

		public static boolean isSessionValid(String sessionId)
			{
				sessionId = validateSessionId(sessionId);
				if (sessionId == null)
					{
						return false;
					}
				return (sessionId_userSession.containsKey(sessionId));
			}

		public synchronized static boolean remove(String sessionId)
			{
				sessionId = validateSessionId(sessionId);
				if (isSessionValid(sessionId) == true)
					{
						sessionId_userSession.remove(sessionId);
						return true;
					}
				return (false);
			}

		public synchronized static void udpate(String sessionId, User user)
			{
				sessionId = validateSessionId(sessionId);
				if (isSessionValid(sessionId) == true)
					{
						SurveySession surveySession = getSession(sessionId);
						surveySession.setUser(user);
						sessionId_userSession.remove(sessionId);
						putSession(sessionId, surveySession);
					}

			}
	}
