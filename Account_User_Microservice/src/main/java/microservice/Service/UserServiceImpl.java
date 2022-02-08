package microservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import microservice.Interface.UserInterface;
import microservice.Request.UpdateAccountResponse;
import microservice.entities.Client;
import microservice.security.UserModel;

@Service
public class UserServiceImpl implements UserInterface {

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Autowired
	MongoOperations mongoOperations;
	
	
	
//	@Override
//	public Client FindAccountById(String id) {
//		Query query=new Query();
////		query.addCriteria(Criteria.where("id").is(username));
////		UserModel result = mongoTemplate.findOne(query, UserModel.class);
//		Client result = mongoTemplate.findById(id, Client.class);
//		return result;
//
//	}



	@Override
	public void UpdateAccount(UserModel client) {
		
	
//			Query query = new Query();
//			query.addCriteria(Criteria.where("id").is(client.getId()));
//
//			Client userTest1 =mongoTemplate.findOne(query, Client.class);

		//	System.out.println("userTest1 - " + userTest1);

			//modify and update with save()
//			client.setCIN(client.getCIN());
//			mongoOperations.update(Client.class);
			mongoTemplate.save(client);

	}
	
	
		
		
		
}
