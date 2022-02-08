package fstt.lsi.serviceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstt.lsi.Entities.Contrat;
import fstt.lsi.repo.ContratRepo;
import fstt.lsi.serviceImpl.ContratInterface;




@Service
public class ContratServiceImpl implements ContratInterface{
	@Autowired
	ContratRepo Repo;

	@Override
	public Contrat insertContrat(Contrat Cntrt) {
		return Repo.insert(Cntrt);
	}

	@Override
	public List<Contrat> allContrat() {
		return Repo.findAll();
	}

}
