package com.flightBookingSystem.Users.ValueObject;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlightsData")
public class FlightsData {

	private int flightId;
	private String airlineName;
	private String source;
	private String destination;
	private int fare;
	private Date date;

	public FlightsData() {

	}

	public FlightsData(int flightId, String airlineName, String source, String destination, int fare, Date date) {
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.date = date;
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

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
