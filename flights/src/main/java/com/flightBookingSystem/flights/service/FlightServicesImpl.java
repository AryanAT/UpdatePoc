package com.flightBookingSystem.flights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightBookingSystem.flights.models.FlightsData;
import com.flightBookingSystem.flights.repository.FlightsRepository;

@Service
public class FlightServicesImpl implements FlightServicesInterface {

	@Autowired
	FlightsRepository flightsRepository;

	@Override
	public FlightsData findFlightById(int flightId) {
		return flightsRepository.findFlightById(flightId);
	}

}
