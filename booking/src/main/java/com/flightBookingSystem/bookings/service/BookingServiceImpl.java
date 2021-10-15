package com.flightBookingSystem.bookings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightBookingSystem.bookings.model.BookingModel;
import com.flightBookingSystem.bookings.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingServicesInterface {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public BookingModel addBooking(BookingModel booking) {

		return bookingRepository.save(booking);
	}

	@Override
	public BookingModel getBookingById(int bookingId) {
		return bookingRepository.getBookingById(bookingId);
	}

}
