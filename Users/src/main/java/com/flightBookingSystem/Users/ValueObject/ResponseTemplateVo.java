package com.flightBookingSystem.Users.ValueObject;

import com.flightBookingSystem.Users.models.FlightsData;
import com.flightBookingSystem.Users.models.UsersModel;

public class ResponseTemplateVo {
	private UsersModel userModel;
	private BookingModel bookingModel;
	private FlightsData flightModel;

	public ResponseTemplateVo() {

	}

	public ResponseTemplateVo(UsersModel userModel, BookingModel bookingModel, FlightsData flightModel) {
		this.userModel = userModel;
		this.bookingModel = bookingModel;
		this.flightModel = flightModel;

	}

	public UsersModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UsersModel userModel) {
		this.userModel = userModel;
	}

	public BookingModel getBookingModel() {
		return bookingModel;
	}

	public void setBookingModel(BookingModel bookingModel) {
		this.bookingModel = bookingModel;
	}

	public FlightsData getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(FlightsData flightModel) {
		this.flightModel = flightModel;
	}

}
