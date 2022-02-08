package fstt.lsi.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Data
@Document(collection = "Users")
public class Client {
	
	@Id
	protected String Id;
	protected String username;
	protected String CIN;
	protected String Address;
	protected String Email;
	private String password;
	
}
