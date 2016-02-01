package com.grandviewtech.surveysystem.service.utility;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

public class Util
	{
		public static String getUUID(String keyword)
			{
				if ((keyword == null) || (keyword.trim().length() == 0))
					{
						keyword = "UUID";
					}
				String uuid = keyword + "_" + System.nanoTime() + "_" + getRandomNumber();
				return uuid.trim().toLowerCase();
			}

		public static String getRandomNumber()
			{
				String uuid = "" + UUID.randomUUID();
				if (uuid.contains("-"))
					{
						uuid = uuid.replaceAll("-", "");
					}
				return uuid + "_" + RandomStringUtils.randomAlphanumeric(10);
			}
	}
