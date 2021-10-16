package com.flightBookingSystem.flights;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightBookingSystem.flights.models.FlightsData;
import com.flightBookingSystem.flights.service.FlightServicesImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FlightsApplicationTests {
	@Mock
	private FlightServicesImpl flightServicesImpl;

	@Test
	public void findFlightByIdTest() {

		int flightId = 1;
		when(flightServicesImpl.findFlightById(flightId))
				.thenReturn(new FlightsData(1, "indigo", "Ranchi", "Delhi", 2500, "17-12-21", "1.2 Hours"));
		FlightsData testFlight = flightServicesImpl.findFlightById(flightId);
		assertEquals(1, testFlight.getFlightId());
		assertEquals("indigo", testFlight.getAirlineName());
		assertEquals("Ranchi", testFlight.getSource());
		assertEquals("Delhi", testFlight.getDestination());
		assertEquals(2500, testFlight.getFare());
		assertEquals("17-12-21", testFlight.getDate());

	}

}
