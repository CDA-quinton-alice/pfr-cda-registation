package fr.afpa.projetregistation.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IPersonneDao;
import fr.afpa.projetregistation.entity.PersonneEntity;

@Component
public class DataInsertion {
	
	@Autowired
	IPersonneDao personneDao;
	
	@PostConstruct
	public void cdaInit() {
		for (int i = 0; i < 10; i++) {
			personneDao.save(PersonneEntity.builder().nom("nom"+i).prenom("prenom"+i).build());
		}
	}
	
}


