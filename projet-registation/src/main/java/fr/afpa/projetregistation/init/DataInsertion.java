package fr.afpa.projetregistation.init;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IDocumentDao;
import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.entity.DocumentEntity;
import fr.afpa.projetregistation.service.IDocumentService;
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

	@Autowired
	IDocumentDao documentDao;

	@Autowired
	IDocumentService documentService;

	@PostConstruct
	public void cdaInit() {

//		materielDao
//				.save(MaterielEntity.builder().marque("Neptune").modele("p500").localisation("emplacement 1").build());

		Date achat = new Date();
		MaterielDto materiel = new MaterielDto("Neptune", "Cuve3000", 2000, "emplacement1", 1, achat, "cuve");
		materielService.create(materiel);
//		MaterielDto materiel2 = new MaterielDto("Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
//		materielService.create(materiel2);
//		materielDao.save(MaterielEntity.builder().marque("Orion").modele("starXL").localisation("pompe numéro 3")
//				.etat(1).dateAchat(achat).prix(2200.00).build());

		// INSERTION DE 2 USER AVEC COUPLE CONNEXION ET ADRESSE
//		UtilisateurDto utilisateur = new UtilisateurDto("EMP001", "pwd", "nomEMP", "prenomEMP", achat, 2000.0,
//				"employe@gmail.com", "06.06.06.06.06", false, 1, "rue de l'employé", "complément1", "59000", "LILLE",
//				"France");
//		utilisateurService.create(utilisateur);
//
//		utilisateur = new UtilisateurDto("RESP001", "pwd", "nomRESP", "prenomRESP", achat, 2500.0,
//				"responsable@gmail.com", "07.07.07.07.07", true, 10, "rue du responsable", "complément2", "59100",
//				"ROUBAIX", "France");
//		utilisateurService.create(utilisateur);

		Date dateAjoutDoc = new Date();
		Date dateDerniereModificationdoc = new Date();
		DocumentDto doc = new DocumentDto("facture entretien cuve n°3", "facture", dateAjoutDoc, dateDerniereModificationdoc, "facture qui correspond au dernier entretien de la cuve n°3.", "rien à signaler, fonctionnement de la cuve n°3 ok.");
		documentService.ajouterDocument(doc);
		documentDao.save(DocumentEntity.builder().nomDocument("inventaire annuel magasin").categorieDocument("inventaire").dateAjoutDocument(dateAjoutDoc).dateDerniereModificationDocument(dateDerniereModificationdoc).descriptionDocument("inventaire du magasin avant réorganisation des rayons").commentairesDocument("inventaire effectué à 3 personnes en une journée").build());
	}

}
