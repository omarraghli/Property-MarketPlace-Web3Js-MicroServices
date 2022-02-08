package microservice.security;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Document(collection = "Users")
public class UserModel {
    
	@Id
	private String Id;
	
	
    private String username;
    private String CIN;
    private String Address;
    private String Email;
    private String password;
}
