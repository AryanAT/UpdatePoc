package com.flightBookingSystem.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightBookingSystem.admin.models.UsersModel;

@Repository

public interface UserRepository extends MongoRepository<UsersModel, Integer> {

	@Query("{userId:?0}")
	UsersModel getUserById(int userId);

	@Query("{userFirstName:?0}")
	void updateUserFirstName(String userFirstName);

}
