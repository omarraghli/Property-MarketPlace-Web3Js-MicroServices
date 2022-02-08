package fstt.lsi.serviceImpl;

import java.util.List;

import fstt.lsi.Entities.Contrat;


public interface ContratInterface {
	public Contrat insertContrat(Contrat Cntrt);
	public List<Contrat> allContrat();
}
