package com.javainuse.controllers;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.javainuse.service.RemoteCallService;

@Controller
public class ConsumerControllerClient {

	@Autowired
	private RemoteCallService loadBalancer;

	public void getEmployee() throws RestClientException, IOException {

		try {
			Employee emp = loadBalancer.getData();
			System.out.println("=========================="+emp.getEmpId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
