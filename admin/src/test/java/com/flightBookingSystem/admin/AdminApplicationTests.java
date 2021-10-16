package com.flightBookingSystem.admin;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightBookingSystem.admin.adminServices.AdminServiceImpl;
import com.flightBookingSystem.admin.models.AdminModel;
import com.flightBookingSystem.admin.models.FlightsData;
import com.flightBookingSystem.admin.models.UsersModel;
import com.flightBookingSystem.admin.repository.AdminRepository;
import com.flightBookingSystem.admin.repository.FlightsRepository;
import com.flightBookingSystem.admin.repository.UserRepository;

@SpringBootTest
class AdminApplicationTests {

	@InjectMocks
	private AdminServiceImpl adminServiceImpl;

	@Mock
	private UserRepository userRepository;

	@Mock
	private AdminRepository adminRepository;
	@Mock
	private FlightsRepository flightRepository;

	@Test
	public void addAdminTest() {
		AdminModel admin = new AdminModel(1, "adminFirstName", "adminLastName");
		when(adminRepository.save(admin)).thenReturn(admin);
		AdminModel testAdmin = adminRepository.save(admin);
		// assertObjects
		assertEquals(admin, testAdmin);
		verify(adminRepository, times(1)).save(admin);
	}

	@Test
	public void getAllPassengersTest() {
		UsersModel user1 = new UsersModel(1, "aryan", "tripathi", "notSoStrongPassword", 0, "aryanTripathi@gmail.com");
		UsersModel user2 = new UsersModel(2, "Nikhil", "singh", "alsoNotSoStrongPassword", 0,
				"aryanTripathi@gmail.com");
		List<UsersModel> listOfUsers = new ArrayList<UsersModel>();
		listOfUsers.add(user1);
		listOfUsers.add(user2);

		when(userRepository.findAll()).thenReturn(listOfUsers);
		List<UsersModel> testList = userRepository.findAll();

		assertEquals(testList, listOfUsers);
		assertEquals(user1, listOfUsers.get(0));
		assertEquals(user2, listOfUsers.get(1));

	}

	@Test
	public void delUserTest() {
		int userId = 1;
//		UsersModel user1 = new UsersModel(1, "aryan", "tripathi", "notSoStrongPassword");
//		UsersModel user2 = new UsersModel(1, "Nikhil", "singh", "alsoNotSoStrongPassword");
		userRepository.deleteById(userId);
		verify(userRepository, times(1)).deleteById(userId);
	}

	@Test
	public void addFlighttest() {
		FlightsData flight = new FlightsData(1, "indigo", "ranchi", "Delhi", 10000, "17-12-21", "1.2 Hours");
		flightRepository.save(flight);
		assertEquals(1, flight.getFlightId());
		assertEquals("indigo", flight.getAirlineName());
		assertEquals("ranchi", flight.getSource());
		assertEquals("Delhi", flight.getDestination());
		assertEquals("17-12-21", flight.getDate());

	}

	@Test
	public void removeFlightTest() {
		int flightId = 1;
		flightRepository.deleteById(flightId);
		verify(flightRepository, times(1)).deleteById(flightId);
	}

	@Test
	public void getAdminByIdTest() {
		int adminId = 1;
		AdminModel admin = new AdminModel(1, "adminFirstName", "adminLastName");
		when(adminRepository.getAdminById(adminId)).thenReturn(admin);
		AdminModel testAdmin = adminRepository.getAdminById(adminId);
		assertEquals(testAdmin, admin);
	}

	@Test
	public void getUserByIdTest() {
		int userId = 1;
		UsersModel user1 = new UsersModel(1, "aryan", "tripathi", "notSoStrongPassword", 0, "aryanTripathi@gmail.com");
		when(userRepository.getUserById(userId)).thenReturn(user1);
		UsersModel testUser = userRepository.getUserById(userId);
		assertEquals(testUser, user1);
	}

	@Test
	public void updateUserTest() {
		UsersModel user1 = new UsersModel(1, "aryan", "tripathi", "notSoStrongPassword", 0, "aryanTripathi@gmail.com");

	}
}
