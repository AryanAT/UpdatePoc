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
		adminRepository.save(admin);
	}

	@Override
	public List<UsersModel> getAllPassengers() {
		return userRepository.findAll();
	}

	@Override
	public void delUser(int userId) {
		userRepository.deleteById(userId);

	}

	@Override
	public void addFlight(@RequestBody FlightsData flightData) {
		flightsRepository.save(flightData);

	}

	@Override
	public void removeFlight(int flightId) {
		flightsRepository.deleteById(flightId);
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
		UsersModel user = getUserById(userId);
		user.setUserFirstName(firstName);
		userRepository.save(user);

	}

}
