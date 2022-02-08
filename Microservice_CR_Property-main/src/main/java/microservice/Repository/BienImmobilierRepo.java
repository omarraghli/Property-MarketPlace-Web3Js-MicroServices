package microservice.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import microservice.entities.BienImmobilier;

@Repository
public interface BienImmobilierRepo extends MongoRepository<BienImmobilier, String> {
}
