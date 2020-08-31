package fr.afpa.projetregistation.init;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.service.IUtilisateurService;

@Component
public class DataInsertion {

	@Autowired
	IMaterielDao materielDao;

	@Autowired
	IMaterielService materielService;

	@Autowired
	IUtilisateurService utilisateurService;

	@PostConstruct
	public void cdaInit() {

//		materielDao
//				.save(MaterielEntity.builder().marque("Neptune").modele("p500").localisation("emplacement 1").build());

		Date achat = new Date();
		MaterielDto materiel = new MaterielDto("Orion", "starXL3", 1500, "pompe numéro 4", 1, achat, "pompe");
		materielService.create(materiel);
//		materielDao.save(MaterielEntity.builder().marque("Orion").modele("starXL").localisation("pompe numéro 3")
//				.etat(1).dateAchat(achat).prix(2200.00).build());

		UtilisateurDto utilisateur = new UtilisateurDto("ABC001", "pwd", "AMB", "Aug", achat, 2000.0, "aug@gmail.com",
				"06.09.08.09.09", true);
		utilisateurService.create(utilisateur);

	}

}
