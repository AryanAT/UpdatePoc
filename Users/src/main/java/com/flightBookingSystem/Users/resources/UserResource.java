package com.flightBookingSystem.Users.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightBookingSystem.Users.ValueObject.ResponseTemplateVo;
import com.flightBookingSystem.Users.models.FlightsData;
import com.flightBookingSystem.Users.models.UsersModel;
import com.flightBookingSystem.Users.services.UserServiceInterface;

//import com.flightBookingSystem.Users.models.UsersModel;
//import com.flightBookingSystem.home.resources.userModel;

@RestController
@RequestMapping("/Users")
public class UserResource {

	@Autowired
	private UserServiceInterface userServiceInterface;

	@PostMapping("/register")
	public UsersModel register(@RequestBody UsersModel user) {
		return userServiceInterface.register(user);
	}

	@GetMapping("/search/{source}+{destination}+{date}")
	public List<FlightsData> search(@PathVariable("source") String Source,
			@PathVariable("destination") String destination, @PathVariable("date") String date) {
		return userServiceInterface.Search(Source, destination, date);

	}

	@GetMapping("/{userId}")
	public ResponseTemplateVo getUserWithBookingId(@PathVariable("userId") int userId) {
		return userServiceInterface.getUserWithBookingId(userId);
	}

	@GetMapping("/userId/{userId}")
	public UsersModel getUserModelByUserId(@PathVariable("userId") int userId) {
		return userServiceInterface.findByUserId(userId);
	}
}
