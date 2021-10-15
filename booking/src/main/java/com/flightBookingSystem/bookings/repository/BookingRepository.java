package com.flightBookingSystem.bookings.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightBookingSystem.bookings.model.BookingModel;

@Repository
public interface BookingRepository extends MongoRepository<BookingModel, Integer> {
	@Query("{bookingId:?0}")
	BookingModel getBookingById(int bookingId);

}
