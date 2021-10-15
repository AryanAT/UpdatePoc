package com.flightBookingSystem.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightBookingSystem.admin.models.AdminModel;

@Repository

public interface AdminRepository extends MongoRepository<AdminModel, Integer> {
	@Query("{adminId:?0}")
	public AdminModel getAdminById(int adminId);
}
