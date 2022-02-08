package microservice.Controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import microservice.Interface.UserInterface;
import microservice.Repository.UserUpdateRepo;
import microservice.Repository.updaterep;
import microservice.Request.UpdateAccountRequest;
import microservice.entities.Client;
import microservice.security.UserModel;

@RestController
@RequestMapping("UpdateAccount")
public class UpdateUserController {

	@Autowired
	UserInterface userInterface;
	
	@Autowired
	UserUpdateRepo userUpdateRepo;
	
	@Autowired
	updaterep updaterep;
	
	@Autowired
	 MongoTemplate mongoTemplate;
	
	@PostMapping("/UpdateUser")
	public void UpdateAccount(@RequestBody Client client) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("Id").is(id));
//        
//		//UserModel userModel = mongoTemplate.findOne(query, UserModel.class);
//		
//		Update updatequeru = new Update();
//		
//		updatequeru.set("cin", "hhhhh");
//		
//		mongoTemplate.updateFirst(query, updatequeru, UserModel.class);
		//userModel.setCIN("hh");
		
		//mongoTemplate.save(userModel);
		
//		Client client2 = new Client();
//		
//		client2=  userUpdateRepo.findById(id).get();
//		
//		client2.setId(id);
//		UserModel userModel = new UserModel();
//		
//		//userModel.setId(id);
//		userModel.setAddress(client2.getAddress());
//		userModel.setEmail(client2.getEmail());
//		userModel.setUsername(client2.getUsername());
//		userModel.setPassword(client2.getPassword());
//		userModel.setCIN(client.getCIN());
//	     
//		userUpdateRepo.save(client2);
//		updaterep.save(userModel);
		
		 mongoTemplate.save(client);
//		
	}
	
	
	@GetMapping("/update")
	public Client GetById(@PathParam(value = "id") String id) {
		
		return userUpdateRepo.findById(id).get();
	}
}
