package microservice.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import microservice.Interface.BienImmobilierInterface;
import microservice.Repository.BienImmobilierRepo;
import microservice.entities.AddImmobilierResponse;
import microservice.entities.BienImmobilerRequest;
import microservice.entities.BienImmobilier;
import microservice.entities.Client;
import microservice.entities.Response;
import microservice.entities.SharingPropertyInformation;

@RestController
@RequestMapping("Property")
public class BienImmobilierController {

	@Autowired
	private BienImmobilierRepo bienImmobilierRepo;

	@Autowired
	BienImmobilierInterface BII;
	// Should passe

	@GetMapping("/GetInfoProperty")
	public SharingPropertyInformation GetInfoProperty(@RequestParam String titre) {

		BienImmobilier bienImmobilier = new BienImmobilier();
		bienImmobilier = BII.findByAgeAndProjectName(titre);

		SharingPropertyInformation sharingPropertyInformation = new SharingPropertyInformation();

		sharingPropertyInformation.setTypeOfProprety(bienImmobilier.getTypeOfProprety());
		sharingPropertyInformation.setArea(bienImmobilier.getArea());
		sharingPropertyInformation.setAdresse(bienImmobilier.getAdresse());
		return sharingPropertyInformation;

	}

	@GetMapping("/getPropertyByTitre")
	public BienImmobilier getPropertyByTitre(@RequestParam String Titre) {

		return BII.getBienImoByTitre(Titre);

	}

	@GetMapping("/home")
	public String home() {
		return "hello everyone";
	}

	@GetMapping("/All")
	public ResponseEntity<Response> allAdresse() {
		return ResponseEntity.ok(

				Response.builder().timeStamp(LocalDateTime.now()).data(Map.of("Proprities", BII.allBienImmobilier()))
						.message("ServerRetrieve").status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build());

	}

	@PostMapping("/saveBienImmobilier")
	public ResponseEntity<?> insertappartement(@RequestBody BienImmobilerRequest bienImmobilerRequest) {

		Client owner = bienImmobilerRequest.getOwner();
		String typeofproperty = bienImmobilerRequest.getTypeOfProprety();
		String address = bienImmobilerRequest.getAdresse();
		int area = bienImmobilerRequest.getArea();
		String Titre = bienImmobilerRequest.getTitre();

		BienImmobilier bienImmobilier = new BienImmobilier();
		bienImmobilier.setOwner(owner);
		bienImmobilier.setTypeOfProprety(typeofproperty);
		bienImmobilier.setAdresse(address);
		bienImmobilier.setTitre(Titre);
		bienImmobilier.setArea(area);

		try {
			bienImmobilierRepo.save(bienImmobilier);

		} catch (Exception e) {

			return ResponseEntity.ok(new AddImmobilierResponse("erreur"));
		}

		return ResponseEntity.ok(new AddImmobilierResponse("success"));

	}

}
