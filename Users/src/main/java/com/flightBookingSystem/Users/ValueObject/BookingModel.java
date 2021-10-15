package com.flightBookingSystem.Users.ValueObject;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BookingData")
public class BookingModel {
	private int bookingId;
	private int userId;
	private int flightId;

	public BookingModel(int bookingId, int userId, int flightId) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
	}

	public BookingModel() {
		super();
		// TODO Auto-generated constructor stub
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
