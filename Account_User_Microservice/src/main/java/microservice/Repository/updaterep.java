package microservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import microservice.security.UserModel;

@Repository
public interface updaterep extends MongoRepository<UserModel,String>{

}
