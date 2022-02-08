package fstt.lsi.Entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "contrat")
@Data
public class Contrat {
	@Id
	private String Id;
	private Date ContractRealisationTime;
	private String Seller;
	private String Buyer;
	@DBRef
	private BienImmobilier BienImmobilier;
	private int prix ;
	
	
}
