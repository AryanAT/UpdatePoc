package com.flightBookingSystem.admin.adminServices;

import java.util.List;

import com.flightBookingSystem.admin.models.AdminModel;
import com.flightBookingSystem.admin.models.FlightsData;
import com.flightBookingSystem.admin.models.UsersModel;

public interface AdminServiceInterface {
	void addAdmin(AdminModel admin);

	List<UsersModel> getAllPassengers();

	AdminModel getAdminById(int adminId);

	void delUser(int userId);

	void addFlight(FlightsData flightData);

	void removeFlight(int flightId);

	void updateUser(int userId, String firstName);

	UsersModel getUserById(int userId);

}
