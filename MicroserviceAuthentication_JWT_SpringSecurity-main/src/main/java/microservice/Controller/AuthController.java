package microservice.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.Repository.userRepository;
import microservice.security.AuthenticationRequest;
import microservice.security.AuthenticationResponse;
import microservice.security.UserModel;
import microservice.security.UserService;
import microservice.security.jwtutil;

@RestController
@RequestMapping("connexion")
public class AuthController {

	@Autowired
	private userRepository UserRepository;
	

	@Autowired
	private UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager ;
	

	@Autowired
	private jwtutil jwtUtil ;
	
	
	@PostMapping("/subs")
	private ResponseEntity<?> subscribe (@RequestBody AuthenticationRequest authenticationRequest){
		
		String username = authenticationRequest.getUsername();
		String CIN = authenticationRequest.getCIN();
		String Address= authenticationRequest.getAddress();
		String email=authenticationRequest.getEmail();
		String password = authenticationRequest.getPassword();

	
		UserModel userModel = new UserModel();
		userModel.setUsername(username);
		userModel.setCIN(CIN);
		userModel.setAddress(Address);
		userModel.setEmail(email);
		userModel.setPassword(passwordEncoder.encode(password));
		
		try {
			UserRepository.save(userModel);
			
		} catch (Exception e) {

			return ResponseEntity.ok(new AuthenticationResponse("erreur"));
		}
	
		
		
		return ResponseEntity.ok(new AuthenticationResponse("Success subscribtion"));
	}
	
	@GetMapping("/save")
	public Optional<UserModel> GetById(@RequestBody UserModel userModel) {
	 
		
		return UserRepository.findById(userModel.getId());
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "hello everyone";
	}
	

	@PostMapping("/getId")
	public String GetIdByPerson(@RequestBody AuthenticationRequest  authenticationRequest) {
		String username2 = authenticationRequest.getUsername();
		String password2 = authenticationRequest.getPassword();
		
		UserModel foundeduser = UserRepository.findByUsername(username2);
		
		String idLoaded=foundeduser.getId();
		return idLoaded;
	}
	
	
	@PostMapping("/auth")
    private String authentification (@RequestBody AuthenticationRequest  authenticationRequest){
		
		
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (Exception e) {

			return "Erreur authentication";
		}
		
		UserDetails loadedUser = userService.loadUserByUsername(username);
		
        String generetedToken= jwtUtil.generateToken(loadedUser);
		
		return generetedToken;
	}
}
