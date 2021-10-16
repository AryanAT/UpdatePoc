package com.flightBookingSystem.admin.adminServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.flightBookingSystem.admin.models.AdminModel;
import com.flightBookingSystem.admin.models.FlightsData;
import com.flightBookingSystem.admin.models.UsersModel;
import com.flightBookingSystem.admin.repository.AdminRepository;
import com.flightBookingSystem.admin.repository.FlightsRepository;
import com.flightBookingSystem.admin.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminServiceInterface {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FlightsRepository flightsRepository;

	@Override
	public void addAdmin(@RequestBody AdminModel admin) {
		AdminModel admin1 = adminRepository.getAdminById((admin.getAdminId()));
		if (admin1 == null) {
			adminRepository.save(admin);
		} else {
			System.out.println("Admin already exists with this Id");
		}
	}

	@Override
	public List<UsersModel> getAllPassengers() {
		return userRepository.findAll();
	}

	@Override
	public void delUser(int userId) {
		UsersModel user = userRepository.getUserById(userId);
		if (user != null) {
			userRepository.deleteById(userId);
		} else {
			System.out.println("Can't Delete User that doesn't exists");
		}

	}

	@Override
	public void addFlight(@RequestBody FlightsData flightData) {
		FlightsData flight = flightsRepository.findFlightById(flightData.getFlightId());
		if (flight == null) {
			flightsRepository.save(flightData);
		} else {
			System.out.println("Flight Already Exists with this Id");
		}

	}

	@Override
	public void removeFlight(int flightId) {
		FlightsData flight = flightsRepository.findFlightById(flightId);
		if (flight != null) {
			flightsRepository.deleteById(flightId);
		} else {
			System.out.println("Can't Delete Flight that doesn't exists");
		}
	}

	@Override
	public AdminModel getAdminById(int adminId) {
		return adminRepository.getAdminById(adminId);
	}

	@Override
	public UsersModel getUserById(int userId) {
		return userRepository.getUserById(userId);
	}

	@Override
	public void updateUser(int userId, String firstName) {
		UsersModel user = userRepository.getUserById(userId);
		if (user != null) {
			UsersModel user1 = getUserById(userId);
			user1.setUserFirstName(firstName);
			userRepository.save(user1);
		} else {
			System.out.println("Can't Update User that doesn't exists");
		}

	}

}
