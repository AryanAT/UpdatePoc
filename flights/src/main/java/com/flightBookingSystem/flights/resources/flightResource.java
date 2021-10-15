package com.flightBookingSystem.flights.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightBookingSystem.flights.models.FlightsData;
import com.flightBookingSystem.flights.service.FlightServicesInterface;

@RestController
@RequestMapping("/flights")
public class flightResource {

	@Autowired
	FlightServicesInterface flightServiceInterface;

	@GetMapping("/{flightId}")
	public FlightsData findFlightById(@PathVariable("flightId") int flightId) {
		return flightServiceInterface.findFlightById(flightId);
	}

//	@GetMapping("/{flightId}")
//	public flightsData someSpecificFlight(@PathVariable String flightId) {
//		
//		return;
//	}
}
