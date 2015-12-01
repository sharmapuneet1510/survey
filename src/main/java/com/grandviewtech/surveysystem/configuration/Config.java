package com.grandviewtech.surveysystem.configuration;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.grandviewtech.surveysystem" })
@EnableTransactionManagement
public class Config
	{

		private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Config.class);

		@PostConstruct
		public void startUpMessage()
			{
				String start = "\t\t*********************************************************************\n";
				String message = "\n" + start + "\t\tLoading Annotation Config" + "\n" + start;
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
	}
