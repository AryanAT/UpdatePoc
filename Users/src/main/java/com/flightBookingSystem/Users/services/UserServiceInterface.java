package com.flightBookingSystem.Users.services;

import java.util.List;

import com.flightBookingSystem.Users.ValueObject.ResponseTemplateVo;
import com.flightBookingSystem.Users.models.FlightsData;
import com.flightBookingSystem.Users.models.UsersModel;

public interface UserServiceInterface {
	UsersModel register(UsersModel user);

	List<FlightsData> Search(String source, String destination);

	String booking(int userId, int flightId);

	ResponseTemplateVo getUserWithBookingId(int userId);

	UsersModel findByUserId(int userId);

}
