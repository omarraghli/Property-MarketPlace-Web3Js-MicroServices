package microservice.Interface;



import org.springframework.http.ResponseEntity;

import microservice.entities.Client;
import microservice.security.UserModel;

public interface UserInterface {

	//public UserModel FindAccountById(String id);
	
	public void UpdateAccount(UserModel userModel);
}
