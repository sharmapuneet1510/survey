package com.grandviewtech.surveysystem.service.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grandviewtech.surveysystem.entity.bo.SurveySession;

import redis.clients.jedis.Jedis;

@Service("redisSession")
public class RedisSession
	{

		private final static org.slf4j.Logger					logger			= org.slf4j.LoggerFactory.getLogger(RedisSession.class);

		@Autowired
		private Jedis											jedis;

		private static org.codehaus.jackson.map.ObjectMapper	objectMapper	= new org.codehaus.jackson.map.ObjectMapper();

		private static org.codehaus.jackson.map.ObjectWriter	objectWriter	= objectMapper.writerWithDefaultPrettyPrinter();

		private static org.codehaus.jackson.map.ObjectReader	objectReader	= objectMapper.reader(SurveySession.class);

		public void put(String sessionId, SurveySession surveySession)
			{

				if ((sessionId == null) || (sessionId.trim().length() == 0) || (surveySession == null))
					{
						return;
					}
				sessionId = sessionId.trim().toLowerCase();
				try
					{
						if (jedis != null)
							{
								String json = objectWriter.writeValueAsString(surveySession);
								jedis.set(sessionId, json);
							}
					}
				catch (Exception e)
					{
						logger.error(e.getMessage(), e);
						throw new RuntimeException(e);
					}
			}

		public SurveySession get(String sessionId)
			{
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						return null;
					}
				sessionId = sessionId.trim().toLowerCase();
				try
					{
						if (jedis != null)
							{
								String json = jedis.get(sessionId);
								if (json == null)
									{
										return null;
									}
								else
									{
										SurveySession surveySession = objectReader.readValue(json);
										return surveySession;
									}
							}
					}
				catch (Exception e)
					{
						logger.error(e.getMessage(), e);
						return null;
					}
				return null;
			}

		public void deleteKey(String sessionId)
			{
				if ((sessionId == null) || (sessionId.trim().length() == 0))
					{
						return;
					}
				sessionId = sessionId.trim().toLowerCase();
				if (jedis != null)
					{
						Long status = jedis.del(sessionId);
						if (status > 0)
							{
								logger.info("Multiple Key with Name : " + sessionId + " removed Successfully");
							}
						else if (status == 0)
							{
								logger.info("Key with Name : " + sessionId + " does not found");
							}
						else
							{
								logger.info("Key with Name : " + sessionId + " removed Successfully");
							}
					}
			}
	}
