package com.flightBookingSystem.admin.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightBookingSystem.admin.adminServices.AdminServiceInterface;
import com.flightBookingSystem.admin.models.AdminModel;
import com.flightBookingSystem.admin.models.FlightsData;
import com.flightBookingSystem.admin.models.UsersModel;

@RestController
@RequestMapping("/admin")
public class AdminResources {
	@Autowired
	AdminServiceInterface adminServiceInterface;

	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody AdminModel admin) {
		adminServiceInterface.addAdmin(admin);
		return "If adminId was unique admin Added, Check Console for Confirmation";
	}

	@GetMapping("getAdmin/{adminId}")
	public AdminModel getAdminByAdminId(@PathVariable("adminId") int adminId) {
		try {
			return adminServiceInterface.getAdminById(adminId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println();
			return null;
		}
	}

	@GetMapping("/getAllPassengers")
	public List<UsersModel> getAllPassengers() {
		return adminServiceInterface.getAllPassengers();
	}

	@DeleteMapping("/delUser/{userId}")
	public void delUser(@PathVariable("userId") int userId) {
		adminServiceInterface.delUser(userId);
	}

	@PutMapping("/updateUser/{userId}+{firstName}")
	public void updateUser(@PathVariable("userId") int userId, @PathVariable("firstName") String firstName) {
//		UsersModel user;
//		user = UserRepository.getUserById(userId);
		adminServiceInterface.updateUser(userId, firstName);
	}

	@PostMapping("/addFlight")
	public void addFlight(@RequestBody FlightsData flightData) {
		adminServiceInterface.addFlight(flightData);
	}

	@DeleteMapping("/delteFlight/{flightId}")
	public void removeFlight(@PathVariable("flightId") int flightId) {
		adminServiceInterface.removeFlight(flightId);
	}

}
