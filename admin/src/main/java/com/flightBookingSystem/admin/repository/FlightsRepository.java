package com.flightBookingSystem.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightBookingSystem.admin.models.FlightsData;

@Repository
public interface FlightsRepository extends MongoRepository<FlightsData, Integer> {

	@Query("{source:?0,destination:?1}")
	public FlightsData findFlightBySource(String source, String destination);

	@Query("{flightId:?0}")
	public FlightsData findFlightById(int flightId);

}
