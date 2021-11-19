package com.mindmap.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
	
	@Autowired
	private DiscoveryClient discoveryClient; //
	
	public String getCustomerfromStaffService() {
		
		
		List<ServiceInstance> instances=discoveryClient.getInstances("STAFF-SERVICE");
		ServiceInstance serviceInstance=instances.get(0);
		
		String baseUrl=serviceInstance.getUri().toString();
				baseUrl=baseUrl+"/staffservice";
		System.out.println(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		String response=null;
		
		
		response=restTemplate.getForObject(baseUrl,String.class);
		
		
		System.out.println("============"+response);
	
		
		return response;
		
	}

}
