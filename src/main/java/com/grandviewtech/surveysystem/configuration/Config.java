package com.grandviewtech.surveysystem.configuration;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mongodb.MongoClient;

@EnableWebMvc
@Configuration
//@ComponentScan(basePackages = { "com.grandviewtech.surveysystem"/*"com.grandviewtech.surveysystem;.service.business", "com.grandviewtech.surveysystem.service.web"*/ })
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
//@EnableMongoRepositories(basePackages = { "com.grandviewtech.surveysystem.service.dao" })
public class Config
	{

		private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Config.class);

		@PostConstruct
		public void startUpMessage()
			{
				String start = "\t\t*********************************************************************\n";
				String message = "\n\n" + start + "\t\t\t\tLoading Annotation Config" + "\n" + start + "\n\n";
				logger.info(message);
			}

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
		public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException
			{
				PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
				Resource resource = new ClassPathResource("application.properties");
				Properties properties = new Properties();
				properties.load(resource.getInputStream());
				Set<Object> keySet = properties.keySet();
				if (keySet != null)
					{
						Iterator<Object> iterator = keySet.iterator();
						while (iterator.hasNext())
							{
								String key = (String) iterator.next();
								String value = (String) properties.get(key);
								ConfigProperties.setPropertyValue(key.trim().toLowerCase(), value.trim());
							}
					}
				return propertySourcesPlaceholderConfigurer;
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
	}
