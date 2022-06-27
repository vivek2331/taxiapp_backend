package com.example.project2.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project2.dto.AuthCredentialsRequest;
import com.example.project2.entity.OrderDetails;
import com.example.project2.entity.User;
import com.example.project2.payload.SignUpRequest;
import com.example.project2.payload.TestRequest;
import com.example.project2.payload.createOrderRequest;
import com.example.project2.repository.Order_Details_Repository;
import com.example.project2.repository.UserRespository;
import com.example.project2.util.JwtUtil;
import com.example.project2.web.payload.CreateOrderResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	Order_Details_Repository order_Details_Repository;
	
	@GetMapping("/")
	public String index() {
		return "test string";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request){
		try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

            User user = (User) authenticate.getPrincipal();
            user.setPassword(null);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(user))
                    .body(user);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
	}
	
	@GetMapping("/getString")
	public String getString(@Valid @RequestBody TestRequest testRequest ){
		
		String a = testRequest.getName();
		String b = testRequest.getPlace();
		return a + b;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignUpRequest signUpRequest){
		
		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(signUpRequest.getPassword());
		user.setCity(signUpRequest.getCity());
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userRespository.save(user);
		
		return ResponseEntity.ok(user);
		
	}
	
	//  http://localhost:8080/api/auth/validate?token=blahblahblah
	@GetMapping("/validate")
	public ResponseEntity<?> validateToken(@RequestParam String token, @AuthenticationPrincipal User user){
		boolean isTokenValid = jwtUtil.validateToken(token, user);
		return ResponseEntity.ok(isTokenValid);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createOrder(@RequestBody createOrderRequest createorderrequest){
		String Restaurantname = createorderrequest.getRestaurantname();
		String Restaurantlocation = createorderrequest.getRestaurantlocation();
		String Customerlocation = createorderrequest.getCustomer_location();
		String Customername = createorderrequest.getCustomer_name();
		
		OrderDetails order = new OrderDetails(Restaurantname, Restaurantlocation, Customerlocation, Customername );
		order_Details_Repository.save(order);
		
		return ResponseEntity.ok(new CreateOrderResponse(true, "New Order created", order));
	}

}
