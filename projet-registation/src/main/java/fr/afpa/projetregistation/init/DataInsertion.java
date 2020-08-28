package fr.afpa.projetregistation.init;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.entity.MaterielEntity;

@Component
public class DataInsertion {

	@Autowired
	IMaterielDao materielDao;

	@PostConstruct
	public void cdaInit() {
		for (int i = 0; i < 10; i++) {

		}

		materielDao
				.save(MaterielEntity.builder().marque("Neptune").modele("p500").localisation("emplacement 1").build());
		materielDao
				.save(MaterielEntity.builder().marque("Orion").modele("starXL").localisation("pompe numéro 3").build());

	}

}
