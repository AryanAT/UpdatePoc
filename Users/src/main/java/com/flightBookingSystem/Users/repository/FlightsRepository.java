package com.flightBookingSystem.Users.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightBookingSystem.Users.models.FlightsData;

@Repository
public interface FlightsRepository extends MongoRepository<FlightsData, Integer> {

	@Query("{source:?0,destination:?1}")
	public List<FlightsData> findFlightBySourceAndDestination(String source, String destination);

}
