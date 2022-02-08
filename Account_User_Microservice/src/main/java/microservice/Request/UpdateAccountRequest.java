package microservice.Request;

import lombok.Data;

@Data
public class UpdateAccountRequest {

	private String Id;
	private String username;
    private String CIN;
    private String Address;
    private String Email;

}
