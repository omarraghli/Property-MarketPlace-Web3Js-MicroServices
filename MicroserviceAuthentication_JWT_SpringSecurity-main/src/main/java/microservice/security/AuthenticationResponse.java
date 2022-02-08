package microservice.security;

import org.springframework.context.annotation.ComponentScan;

import lombok.Data;

@Data
public class AuthenticationResponse {

	private String id;

	public AuthenticationResponse(String response) {
		super();
		this.id = response;
	}
	
	
}
