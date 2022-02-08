package microservice.Interface;

import java.beans.JavaBean;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;

import microservice.entities.BienImmobilier;




public interface BienImmobilierInterface {
	public BienImmobilier insertBienImmobilier(BienImmobilier BI);
	public List<BienImmobilier> allBienImmobilier();
	public BienImmobilier getBienImoByTitre(String Titre);
	public  BienImmobilier findByAgeAndProjectName(String titre);
}
