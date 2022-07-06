package com.example.TaxiProject.controller;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.example.TaxiProject.entities.Driver;
import com.example.TaxiProject.entities.RideDetails;
import com.example.TaxiProject.repository.DriverRepository;
import com.example.TaxiProject.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



import com.example.TaxiProject.entities.User;

import com.example.TaxiProject.repository.RideDetailsRepository;


@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private UserRespository repo;
	
	@Autowired
	RideDetailsRepository rideRepo;

	@Autowired
	DriverRepository driverRepo;

	@PostMapping("/newRide")
	public ResponseEntity<?> bookRide(@RequestBody RideDetails rideDetails, BindingResult result, Model model, @AuthenticationPrincipal User user){
		String pickupLoc = rideDetails.getPickupLoc();
		String destination = rideDetails.getDestination();
		String vehicleType = rideDetails.getVehicleType();
		long price = 100;
		if(pickupLoc != "Chennai"){
			price++;
		}

		RideDetails newRideDetails = new RideDetails();
		newRideDetails.setPickupLoc(pickupLoc);
		newRideDetails.setDestination(destination);
		newRideDetails.setVehicleType(vehicleType);
		newRideDetails.setPrice(price);
		newRideDetails.setUser(user);

		rideRepo.save(newRideDetails);
		return ResponseEntity.ok(newRideDetails);

	}

	@GetMapping("/rideDetails")
	public ResponseEntity<?> rideDetails(@AuthenticationPrincipal User user){

		List<RideDetails> rideDetails = rideRepo.findByUserId(user.getId());

		RideDetails max = rideDetails.stream().max(Comparator.comparingLong(RideDetails::getRideId))
				.get();

		return ResponseEntity.ok(max);
	}

	@GetMapping("/history")
	public ResponseEntity<?> bookingHistory(Principal principal, Model model) {
		String username = principal.getName();
		Optional<User> user = repo.findByUsername(username);

		List<RideDetails> rideDetails = rideRepo.findByUserId(user.get().getId());

		model.addAttribute("listRides", rideDetails);

		return ResponseEntity.ok(rideDetails);

	}

	@GetMapping("/edit")
	public ResponseEntity<?> showEditProductPage(Principal principal) {
		String email = principal.getName();
		Optional<User> user = repo.findByUsername(email);

		return ResponseEntity.ok(user.get());

	}


	@PostMapping("/update")
	public ResponseEntity<?> editProfile(@RequestBody User editRequest, @AuthenticationPrincipal User user) {
		user.setFirstName(editRequest.getFirstName());
		user.setLastName(editRequest.getLastName());
		user.setPassword(editRequest.getPassword());

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		repo.save(user);
		return ResponseEntity.ok(user);
	}
	@GetMapping("/driverDetails")
	public ResponseEntity<?> driverDetails(Model model){

		List<Driver> driver = driverRepo.findAll();

		model.addAttribute("listDrivers", driver);

		return ResponseEntity.ok(driver);
	}

	@PostMapping("/registerDriver")
	public ResponseEntity<?> registerDriver(@RequestBody Driver driver){
		String name = driver.getName();
		Long number = driver.getPhoneNumber();
		Long id = driver.getId();
		String status = driver.getStatus();

		Driver newDriver = new Driver(id, name, number, status);
		driverRepo.save(newDriver);

		return ResponseEntity.ok(newDriver);
	}
}
