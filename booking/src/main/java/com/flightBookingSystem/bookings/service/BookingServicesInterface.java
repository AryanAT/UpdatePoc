package com.flightBookingSystem.bookings.service;

import com.flightBookingSystem.bookings.model.BookingModel;

public interface BookingServicesInterface {

	BookingModel addBooking(BookingModel booking);

	BookingModel getBookingById(int bookingId);

}
