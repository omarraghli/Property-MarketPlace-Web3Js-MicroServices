package microservice.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import microservice.entities.Client;
import microservice.security.UserModel;

@Repository
public interface UserUpdateRepo extends MongoRepository<Client,String>{

}
