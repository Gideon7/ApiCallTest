package com.apitest.application.service;

import java.util.Arrays;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiCallService {
	
	@Autowired
	RestTemplate restTemp;
	@Autowired
	WebClient.Builder webClient;
	
	public boolean callApiWithAsyncHttpClient() {
		log.info("Testing Api Call With Async Http Client");
		try {
			AsyncHttpClient client = new DefaultAsyncHttpClient();
			client.prepare("GET", "	https://api.coindesk.com/v1/bpi/currentprice.json")
				.execute()
				.toCompletableFuture()
				.thenAccept(System.out::println)
				.join();

			client.close();
			return true;
		}catch(Exception e) {
			log.error(""+e.getMessage());
			return false;
		}
	}
	
	public boolean callApiWithRestTemplate() {
		log.info("Testing Api Call With Rest Template");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			
			ResponseEntity<String> result = restTemp.exchange("	https://api.coindesk.com/v1/bpi/currentprice.json", HttpMethod.GET, entity,
					String.class);
			
			String response = result.getBody();
			System.out.println("RESPONSE### : "+response);
			return true;
		}catch(Exception e) {
			log.error(""+e.getMessage());
			return false;
		}
		
	}
	
	public boolean callApiWithWebClient() {
		log.info("Api Rest Call With Web Client");
		try {
			
		        String result =webClient
		            .build()
		            .get()
		            .uri("https://api.coindesk.com/v1/bpi/currentprice.json")
		            .retrieve()
		            .bodyToMono(String.class)
		            .block();
		        System.out.println("Result: "+result);           
			return true;
		}catch(Exception e) {
			log.error(""+e.getMessage());
			return false;
		}
	}
}
