package com.flightBookingSystem.home.resources;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightBookingSystem.home.models.flightsData;


@RestController
@RequestMapping("/home")
public class HomeResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/allFlights")
	public List<flightsData> getAllFlights(){
		String url = "http://localhost:8082/flight/allFlights";
		flightsData[] flightsdata = restTemplate.getForObject(url, flightsData[].class);
		return Arrays.asList(flightsdata);
	}
	
	@GetMapping("/login")
	public String home() {
		return "Welcome to the home page use/admin/login on port 8084 on to get to admin login page and "
				+ "/user/login on port 8083 for user login page";
	}
}
