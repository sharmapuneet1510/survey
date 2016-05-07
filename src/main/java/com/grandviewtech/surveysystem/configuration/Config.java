package com.grandviewtech.surveysystem.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.grandviewtech.surveysystem.entity.exception.RedisServerException;
import com.mongodb.MongoClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter
	{
		
		private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Config.class);
		
		@Bean
		public WebMvcConfigurer corsConfigurer()
			{
				return new WebMvcConfigurerAdapter()
					{
						@Override
						public void addCorsMappings(CorsRegistry registry)
							{
								registry.addMapping("/surveySystem/ws/rest/*").allowedOrigins("http://localhost:8080");
							}
					};
			}
			
		@Bean
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
			{
				return new PropertySourcesPlaceholderConfigurer();
			}
			
		@Value("${mongoDBServerUrl}")
		
		private String	mongoDBServerUrl;
						
		@Value("${mongoDBDatabaseName}")
		private String	mongoDBDatabaseName;
						
		public @Bean MongoDbFactory mongoDbFactory() throws Exception
			{
				return new SimpleMongoDbFactory(new MongoClient(mongoDBServerUrl), mongoDBDatabaseName);
			}
			
		public @Bean MongoTemplate mongoTemplate() throws Exception
			{
				MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
				return mongoTemplate;
			}
			
		@Bean
		public MongoMappingContext mappingContext()
			{
				return new MongoMappingContext();
			}
			
		private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		@Scheduled(fixedRate = 5000)
		public void scheduling()
			{
				System.out.println("The time is now " + dateFormat.format(new Date()));
			}
			
		@Value("${redisHost}")
		private String		redisHost;
							
		@Value("${redisPort}")
		private String		redisPort;
							
		@Value("${redisTimeOut}")
		private String		redisTimeOut;
							
		@Value("${keyTimeOut}")
		private String		keyTimeOut;
							
		//private long		timeOut		= 300000;
		
		private JedisPool	jedisPool	= null;
										
		@Bean(name = "jedis", autowire = Autowire.BY_NAME) //destroyMethod = "destoryRedisPool")
		public Jedis getJedisConnection()
			{
				try
					{
						JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
						jedisPoolConfig.setMaxTotal(1000);
						jedisPoolConfig.setMaxIdle(10);
						jedisPoolConfig.setMinIdle(1);
						jedisPoolConfig.setMaxWaitMillis(30000);
						jedisPool = new JedisPool(jedisPoolConfig, redisHost, Integer.parseInt(redisPort), Integer.parseInt(redisTimeOut));
						//timeOut = Long.parseLong(keyTimeOut);
						Jedis jedis = jedisPool.getResource();
						if (jedis == null)
							{
								String error = "Could not establish Redis connection. Redis Configuration => Host : " + redisHost + " , Port : " + redisHost + " , timeOut : " + redisTimeOut + "If Configuration is RIGHT then Is the Redis Server Up & running?";
								logger.error(error);
								throw new RedisServerException(error);
							}
						if (jedis.ping().toUpperCase().equals("PONG") == false)
							{
								String error = "Could not establish Redis connection ,Ping Failed. Redis Configuration => Host : " + redisHost + " , Port : " + redisHost + " , timeOut : " + redisTimeOut + "If Configuration is RIGHT then Is the Redis Server Up & running?";
								logger.error(error);
								System.exit(-1);
								throw new RedisServerException(error);
								
							}
						//jedis.flushAll();
						return jedis;
					}
				catch (Exception exception)
					{
						String error = "Could not establish Redis connection. Redis Configuration => Host : " + redisHost + " , Port : " + redisHost + " , timeOut : " + redisTimeOut + "If Configuration is RIGHT then Is the Redis Server Up & running?";
						error += "\n Message : " + exception.getLocalizedMessage();
						logger.error(error, exception);
						System.exit(-1);
						throw new RedisServerException(exception.getLocalizedMessage(), exception);
					}
			}
			
		public void destoryRedisPool()
			{
				if (jedisPool != null)
					{
						jedisPool.close();
					}
			}
			
		@Autowired
		private UserDetailsService userDetailsService;
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
			{
				authenticationManagerBuilder.userDetailsService(userDetailsService);
			}
			
		@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception
			{
				httpSecurity.authorizeRequests().anyRequest().authenticated().and().formLogin();
			}
	}
