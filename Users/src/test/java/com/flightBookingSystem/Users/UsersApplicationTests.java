package com.flightBookingSystem.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightBookingSystem.Users.models.UsersModel;
import com.flightBookingSystem.Users.repository.UserRepository;
import com.flightBookingSystem.Users.services.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsersApplicationTests {

	@InjectMocks
	private UserServiceImpl service;
	// services

	@Mock
	private UserRepository repository;
	// repository

	@Test
	public void getUserByIdTest() {
		int userId = 1;
		when(repository.findByUserId(userId)).thenReturn(new UsersModel(1, "Aryan", "tripathi", "password", 1));

		UsersModel user = service.findByUserId(1);
		UsersModel user2 = service.findByUserId(1);

		// assertEquals(Excepted, actual);
		assertEquals(1, user.getUserId());
		assertEquals("Aryan", user.getUserFirstName());
		assertEquals("tripathi", user.getUserLastName());
		assertEquals("password", user.getUserPassword());
		assertEquals(1231, user.getBookingId());

		verify(repository, times(2)).findByUserId(userId);
	}

}
