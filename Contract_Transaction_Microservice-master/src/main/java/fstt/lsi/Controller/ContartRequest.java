package fstt.lsi.Controller;

import org.springframework.data.mongodb.core.mapping.DBRef;

import fstt.lsi.Entities.BienImmobilier;
import fstt.lsi.Entities.Client;
import lombok.Data;

@Data
public class ContartRequest {

	private String Seller;
	private String Buyer;
	private BienImmobilier BienImmobilier;
	private int prix;
}
