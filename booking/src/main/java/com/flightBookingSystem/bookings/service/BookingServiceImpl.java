package com.flightBookingSystem.bookings.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightBookingSystem.bookings.model.BookingModel;
import com.flightBookingSystem.bookings.model.UsersModel;
import com.flightBookingSystem.bookings.repository.BookingRepository;
import com.flightBookingSystem.bookings.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingServicesInterface {

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public BookingModel addBooking(BookingModel booking) {
		Random rand = new Random();

		UsersModel user = userRepository.findByUserId(booking.getUserId());
		booking.setBookingId(rand.nextInt(1000));
		user.setBookingId(booking.getBookingId());
		userRepository.save(user);
		return bookingRepository.save(booking);
	}

	@Override
	public BookingModel getBookingById(int bookingId) {
		BookingModel booking = bookingRepository.getBookingById(bookingId);
		if (booking != null) {
			return bookingRepository.getBookingById(bookingId);
		} else {
			System.out.println("There is no booking with this bookingId");
			return null;
		}
	}

}
