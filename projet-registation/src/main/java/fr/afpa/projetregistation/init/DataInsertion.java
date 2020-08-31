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
		MaterielDto materiel = new MaterielDto("Orion", "pisto3000", 1000, "pompe numéro 4", 1, achat, "pompe");
		materielService.create(materiel);
//		materielDao.save(MaterielEntity.builder().marque("Orion").modele("starXL").localisation("pompe numéro 3")
//				.etat(1).dateAchat(achat).prix(2200.00).build());

		// INSERTION DE 2 USER AVEC COUPLE CONNEXION ET ADRESSE
		UtilisateurDto utilisateur = new UtilisateurDto("EMP001", "pwd", "nomEMP", "prenomEMP", achat, 2000.0,
				"employe@gmail.com", "06.06.06.06.06", false, 1, "rue de l'employé", "complément1", "59000", "LILLE",
				"France");
		utilisateurService.create(utilisateur);

		utilisateur = new UtilisateurDto("RESP001", "pwd", "nomRESP", "prenomRESP", achat, 2500.0,
				"responsable@gmail.com", "07.07.07.07.07", true, 10, "rue du responsable", "complément2", "59100",
				"ROUBAIX", "France");
		utilisateurService.create(utilisateur);

	}

}
