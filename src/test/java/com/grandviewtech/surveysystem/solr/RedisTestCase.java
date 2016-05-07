package com.grandviewtech.surveysystem.solr;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTestCase
	{
		@Test
		public void redisPutOnTest()
			{
				Jedis jedis = null;
				try
					{
						jedis = new Jedis("localhost");
						jedis.set("test1", "Puneet Sharma");
						System.out.println("Connection to server sucessfully");
						System.out.println("Server is running: " + jedis.ping());
					}
				catch (Exception exception)
					{
						exception.printStackTrace();
					}
				finally
					{
						if (jedis != null)
							{
								jedis.close();
							}
					}
			}

		@Test
		public void redisGetOnTest()
			{
				Jedis jedis = null;
				try
					{
						jedis = new Jedis("localhost");
						System.out.println("Data " + jedis.get("test1"));
					}
				catch (Exception exception)
					{
						exception.printStackTrace();
					}
				finally
					{
						if (jedis != null)
							{
								jedis.close();
							}
					}
			}
	}
