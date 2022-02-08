package microservice.security;


import org.springframework.context.annotation.ComponentScan;

import lombok.Data;

@Data
public class AuthenticationRequest {

	
	private String username;
    private String CIN;
    private String Address;
    private String Email;
    private String password;

}
