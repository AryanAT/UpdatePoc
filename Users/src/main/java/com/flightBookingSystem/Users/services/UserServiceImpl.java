package com.flightBookingSystem.Users.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flightBookingSystem.Users.ValueObject.BookingModel;
import com.flightBookingSystem.Users.ValueObject.ResponseTemplateVo;
import com.flightBookingSystem.Users.models.FlightsData;
import com.flightBookingSystem.Users.models.UsersModel;
import com.flightBookingSystem.Users.repository.FlightsRepository;
import com.flightBookingSystem.Users.repository.UserRepository;

@Service

public class UserServiceImpl implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private FlightsRepository flightsRepository;

	@Override
	public UsersModel register(UsersModel user) {
		try {
			return userRepository.insert(user);
		} catch (org.springframework.dao.DuplicateKeyException e) {
			System.out.println("Duplicate Id");
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<FlightsData> Search(String source, String destination, String date) {
		return flightsRepository.findFlightBySourceAndDestination(source, destination, date);

	}
// Not Used
//	@Override
//	public String booking(int userId) {
//		return "userId" + userId + "has booked this flight with id" + userRepository.getBookingId(userId);
//	}

	@Override
	public ResponseTemplateVo getUserWithBookingId(int userId) {
		ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
		UsersModel user = userRepository.findByUserId(userId);
		BookingModel booking = restTemplate.getForObject(
				"http://Booking-Service/bookings/getBookingById/" + user.getBookingId(), BookingModel.class);
		FlightsData flight = restTemplate.getForObject("http://Flights-Service/flights/" + booking.getFlightId(),
				FlightsData.class);
		responseTemplateVo.setUserModel(user);
		responseTemplateVo.setBookingModel(booking);
		responseTemplateVo.setFlightModel(flight);
		return responseTemplateVo;
	}

	@Override
	public UsersModel findByUserId(int userId) {

		return userRepository.findByUserId(userId);
	}

}
