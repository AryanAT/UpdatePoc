package com.flightBookingSystem.flights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightBookingSystem.flights.models.FlightsData;
import com.flightBookingSystem.flights.repository.FlightsRepository;

@Service
public class FlightServicesImpl implements FlightServicesInterface {

	@Autowired
	private FlightsRepository flightsRepository;

	@Override
	public FlightsData findFlightById(int flightId) {
		FlightsData flight = flightsRepository.findFlightById(flightId);
		if (flight != null) {
			return flightsRepository.findFlightById(flightId);
		} else {
			System.out.println("There is no Flight for this flightId");
			return null;
		}
	}

}
