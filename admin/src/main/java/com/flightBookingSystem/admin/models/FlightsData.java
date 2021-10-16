package com.flightBookingSystem.admin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlightsData")

public class FlightsData {
	@Id
	private int flightId;
	private String airlineName;
	private String source;
	private String destination;
	private int fare;
	private String date;
	private String time;

	public FlightsData(int flightId, String airlineName, String source, String destination, int fare, String date,
			String time) {

		this.flightId = flightId;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.date = date;
		this.time = time;
	}

	public FlightsData() {

	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
