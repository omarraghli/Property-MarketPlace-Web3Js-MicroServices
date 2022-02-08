package microservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import microservice.Interface.BienImmobilierInterface;
import microservice.Repository.BienImmobilierRepo;
import microservice.entities.BienImmobilier;

@Service
public class BienImmobilierServiceImpl implements BienImmobilierInterface {

	@Autowired
	BienImmobilierRepo Repo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public BienImmobilier insertBienImmobilier(BienImmobilier BI) {
		return Repo.insert(BI);
	}

	@Override
	public List<BienImmobilier> allBienImmobilier() {
		return Repo.findAll();
	}

	@Override
	public BienImmobilier findByAgeAndProjectName(String titre) {

		Query query = new Query();
		query.addCriteria(Criteria.where("Titre").is(titre));
		BienImmobilier result = mongoTemplate.findOne(query, BienImmobilier.class);
		return result;
	}

	@Override
	public BienImmobilier getBienImoByTitre(String Titre) {
		Query query = new Query();
		query.addCriteria(Criteria.where("Titre").is(Titre));
		BienImmobilier result = mongoTemplate.findOne(query, BienImmobilier.class);
		return result;
	}

}
