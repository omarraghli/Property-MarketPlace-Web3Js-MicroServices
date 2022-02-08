package microservice.entities;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "BienImobilier")
public class BienImmobilier {
	
	@Id
	protected String Id;
	@DBRef
	protected Client Owner;
	protected String TypeOfProprety="";
	protected String Adresse;
	protected int Area;
	protected String Titre;

	
	
	

}

