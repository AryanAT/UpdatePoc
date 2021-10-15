package com.flightBookingSystem.bookings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BookingData")
public class BookingModel {
	@Id
	private int bookingId;
	private int userId;
	private int flightId;

	public BookingModel() {

		// TODO Auto-generated constructor stub
	}

	public BookingModel(int bookingId, int userId, int flightId) {

		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

}
