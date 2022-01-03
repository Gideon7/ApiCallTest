package com.apitest.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAsync
public class ApiCallTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCallTestApplication.class, args);
	}
	public WebMvcConfigurer corsConfigurer() { 
		   return new WebMvcConfigurer() {
		      @Override
		      public void addCorsMappings(CorsRegistry registry) {
		         registry.addMapping("/**").allowedHeaders("*");
		      }    
		   };
		}
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}


}
