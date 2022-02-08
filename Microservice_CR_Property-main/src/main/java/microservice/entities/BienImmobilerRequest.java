package microservice.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;

@Data
public class BienImmobilerRequest {
	@DBRef
	protected Client Owner;
	protected String TypeOfProprety="";
	protected String Adresse;
	protected int Area;
    protected String Titre;
	
	

}
