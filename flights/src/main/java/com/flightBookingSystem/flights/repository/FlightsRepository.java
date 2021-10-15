package com.flightBookingSystem.flights.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightBookingSystem.flights.models.FlightsData;

@Repository
public interface FlightsRepository extends MongoRepository<FlightsData, Integer> {

	@Query("{flightId:?0}")
	public FlightsData findFlightById(int flightId);

}
