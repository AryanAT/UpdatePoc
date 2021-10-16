package com.flightBookingSystem.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightBookingSystem.Users.models.FlightsData;
import com.flightBookingSystem.Users.models.UsersModel;
import com.flightBookingSystem.Users.repository.FlightsRepository;
import com.flightBookingSystem.Users.repository.UserRepository;
import com.flightBookingSystem.Users.services.UserServiceImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest
class UsersApplicationTests {

	@InjectMocks
	private UserServiceImpl service;
	// services

	@Mock
	private UserRepository userRepository;

	@Mock
	private FlightsRepository flightsRepository;
	// repository

	@Test
	public void getUserByIdTest() {
		int userId = 1;
		when(userRepository.findByUserId(userId))
				.thenReturn(new UsersModel(1, "Aryan", "tripathi", "password", 1, "aryanTripathi@gmail.com"));

		UsersModel user = service.findByUserId(1);
		UsersModel user2 = service.findByUserId(1);

		// assertEquals(Excepted, actual);
		assertEquals(1, user.getUserId());
		assertEquals("Aryan", user.getUserFirstName());
		assertEquals("tripathi", user.getUserLastName());
		assertEquals("password", user.getUserPassword());
		assertEquals(1, user.getBookingId());

		verify(userRepository, times(2)).findByUserId(userId);
	}

	@Test
	public void registerUserTest() {
		UsersModel user = new UsersModel(12, "Palak", "Shrivastav", "password12", 101, "PalakTripathi@gmail.com");
		when(userRepository.insert(user))
				.thenReturn(new UsersModel(12, "Palak", "Shrivastav", "password12", 101, "PalakTripathi@gmail.com"));
		UsersModel userTest = userRepository.insert(user);
		assertEquals(12, userTest.getUserId());
		assertEquals("Palak", userTest.getUserFirstName());
		assertEquals("Shrivastav", userTest.getUserLastName());
		assertEquals("password12", userTest.getUserPassword());
		assertEquals(101, userTest.getBookingId());
	}

	@Test
	public void findFlightBySourceAndDestinationTest() {
		FlightsData flight1 = new FlightsData(1, "airbnb", "Bhopal", "Delhi", 10291, "17-12-21", "1.2 Hours");
		FlightsData flight2 = new FlightsData(2, "indigo", "Bhutan", "Japan", 11091, "18-12-21", "1.3 Hours");
		List<FlightsData> listOfFlights = new ArrayList<FlightsData>();
		listOfFlights.add(flight1);
		listOfFlights.add(flight2);

		flightsRepository.saveAll(listOfFlights);
		when(flightsRepository.findFlightBySourceAndDestination("Bhopal", "Delhi", "17-12-21"))
				.thenReturn(listOfFlights);
		List<FlightsData> listOfFlights1 = flightsRepository.findFlightBySourceAndDestination("Bhopal", "Delhi",
				"17-12-21");
		assertEquals(flight1.getFlightId(), listOfFlights1.get(0).getFlightId());
		assertEquals(flight2, listOfFlights1.get(1));

	}

//	@Test
//	public void bookingTest() {
//		UsersModel user2 = new UsersModel(12, "Palak", "Shrivastav", "password12", 10);
//		//when(userRepository.getFlightId(user2.getUserId())).thenReturn(user2.getBookingId());
//		when(service.booking(user2.getUserId()))
//				.thenReturn("userId" + user2.getUserId() + "has booked this flight with id" + user2.getBookingId());
//
//		assertEquals(service.booking(user2.getUserId()), "userId" + 12 + "has booked this flight with id" + 10);
//	}

}
