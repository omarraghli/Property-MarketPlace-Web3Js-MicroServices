package fstt.lsi.Security;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
