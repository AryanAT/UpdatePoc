package com.flightBookingSystem.Users.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightBookingSystem.Users.models.FlightsData;
import com.flightBookingSystem.Users.models.UsersModel;

@Repository
public interface UserRepository extends MongoRepository<UsersModel, Integer> {
	@Query("{source:?0,destination:?1}")
	List<FlightsData> search(String source, String desitnation);

	@Query("{userId:?0}")
	UsersModel findByUserId(int userId);
}
