package fstt.lsi.Controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.Entities.*;
import fstt.lsi.repo.ContratRepo;
import fstt.lsi.serviceImpl.ContratInterface;

@RestController
@RequestMapping("Contrat")
public class ContratController {

	@Autowired
	ContratInterface CntrtInt;

	@Autowired
	private ContratRepo contratRepo;

//	@PostMapping("/saveContrat")
//	public ResponseEntity<Response> SaveContrat(Contrat contrat) {
//		return ResponseEntity.ok(
//				Response
//				.builder()
//				.timeStamp(LocalDateTime.now())
//				.data(Map.of("Contrat", CntrtInt.insertContrat(contrat)))
//				.message("Contract Added")
//				.status(HttpStatus.CREATED)
//				.statusCode(HttpStatus.CREATED.value())
//				.build()
//				);
//	}

	@GetMapping("/All")
	public ResponseEntity<Response> DisplayContracts() {
		return ResponseEntity
				.ok(Response.builder().timeStamp(LocalDateTime.now()).data(Map.of("Contrats", CntrtInt.allContrat()))
						.message("ServerRetrieve").status(HttpStatus.OK).statusCode(HttpStatus.OK.value()).build()

				);
	}

	@PostMapping("/SaveContart")
	public ResponseEntity<?> saveContart(@RequestBody ContartRequest contrat) {

		Date date = new Date();

		String seller = contrat.getSeller();
		String buyer = contrat.getBuyer();
		BienImmobilier bienImmobilier = contrat.getBienImmobilier();
		int prix = contrat.getPrix();
		Contrat contrat2 = new Contrat();

		contrat2.setContractRealisationTime(date);
		contrat2.setSeller(seller);
		contrat2.setBuyer(buyer);
		contrat2.setBienImmobilier(bienImmobilier);
		contrat2.setPrix(prix);

		try {
			contratRepo.save(contrat2);

		} catch (Exception e) {

			return ResponseEntity.ok(new SaveContartResponse("erreur"));
		}

		return ResponseEntity.ok(new SaveContartResponse("success"));

	}

}
