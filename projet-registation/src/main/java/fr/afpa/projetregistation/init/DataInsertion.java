package fr.afpa.projetregistation.init;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dao.IPersonneDao;
import fr.afpa.projetregistation.entity.MaterielEntity;
import fr.afpa.projetregistation.entity.PersonneEntity;

@Component
public class DataInsertion {

	@Autowired
	IPersonneDao personneDao;

	@Autowired
	IMaterielDao materielDao;

	@PostConstruct
	public void cdaInit() {
		for (int i = 0; i < 10; i++) {
			personneDao.save(PersonneEntity.builder().nom("nom" + i).prenom("prenom" + i).build());
		}

		materielDao
				.save(MaterielEntity.builder().marque("Neptune").modele("p500").localisation("emplacement 1").build());
		materielDao
				.save(MaterielEntity.builder().marque("Orion").modele("starXL").localisation("pompe numéro 3").build());

	}

}
