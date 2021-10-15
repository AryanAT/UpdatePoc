package com.flightBookingSystem.bookings.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightBookingSystem.bookings.model.BookingModel;
import com.flightBookingSystem.bookings.service.BookingServicesInterface;

@RestController
@RequestMapping("/bookings")
public class BookingResource {

	@Autowired
	private BookingServicesInterface bookingServicesInterface;

	@PostMapping("/addBooking")
	public BookingModel addBooking(@RequestBody BookingModel booking) {
		return bookingServicesInterface.addBooking(booking);
	}

	@GetMapping("/getBookingById/{bookingId}")
	public BookingModel getBookingById(@PathVariable("bookingId") int bookingId) {
		return bookingServicesInterface.getBookingById(bookingId);
	}

}
