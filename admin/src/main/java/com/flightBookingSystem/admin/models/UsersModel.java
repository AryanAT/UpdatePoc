package com.flightBookingSystem.admin.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UsersData")
public class UsersModel {
	@Id
	private int userId;
	private String userFirstName;
	private String userLastName;
	private String email;
	private int bookingId;
	private String userPassword;

	public UsersModel() {
	}

	public UsersModel(int userId, String userFirstName, String userLastName, String email, int bookingId,
			String userPassword) {

		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.bookingId = bookingId;
		this.email = email;
		this.setUserPassword(userPassword);

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
