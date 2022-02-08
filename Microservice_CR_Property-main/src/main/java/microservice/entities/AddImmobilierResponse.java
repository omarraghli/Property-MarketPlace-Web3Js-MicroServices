package microservice.entities;

import lombok.Data;

@Data
public class AddImmobilierResponse {

	
	private String response;

	public AddImmobilierResponse(String response) {
		super();
		this.response = response;
	}
	
}
