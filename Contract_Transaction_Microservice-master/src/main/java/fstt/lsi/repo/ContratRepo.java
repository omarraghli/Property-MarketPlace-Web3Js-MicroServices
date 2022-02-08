package fstt.lsi.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import fstt.lsi.Entities.Contrat;

public interface ContratRepo extends MongoRepository<Contrat, String> {

}
