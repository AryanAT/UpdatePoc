package com.flightBookingSystem.bookings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightBookingSystem.bookings.model.BookingModel;
import com.flightBookingSystem.bookings.repository.BookingRepository;
import com.flightBookingSystem.bookings.service.BookingServiceImpl;

@SpringBootTest
class BookingApplicationTests {

	@Mock
	private BookingServiceImpl bookingServiceImpl;
	@Mock
	private BookingRepository bookingRepository;

	@Test
	public void addBookingTest() {
		BookingModel booking = new BookingModel(1, 101, 101);
		when(bookingServiceImpl.addBooking(booking)).thenReturn(booking);

		BookingModel bookingTest = bookingServiceImpl.addBooking(booking);
		assertEquals(1, bookingTest.getBookingId());
		assertEquals(101, bookingTest.getUserId());
		assertEquals(101, bookingTest.getFlightId());

	}

	@Test
	public void getBookingTest() {

		int bookingId = 1;
		when(bookingServiceImpl.getBookingById(bookingId)).thenReturn(new BookingModel(1, 101, 101));

		BookingModel testBooking1 = bookingServiceImpl.getBookingById(1);
		assertEquals(1, testBooking1.getBookingId());
		assertEquals(101, testBooking1.getUserId());
		assertEquals(101, testBooking1.getFlightId());

	}

}
