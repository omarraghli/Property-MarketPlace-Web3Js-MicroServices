package microservice.Repository;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import microservice.entities.UserModel;

@Repository
public interface userRepository extends MongoRepository<UserModel,String>{
	
	UserModel findByUsername(String username);

}
