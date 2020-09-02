package fr.afpa.projetregistation.init;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IDocumentDao;
import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.service.IDocumentService;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.service.IUtilisateurService;
import lombok.extern.slf4j.Slf4j;

@Slf4j

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

		//A DECOMMENTER POUR INSERER 2 UTILISATEURS
//		insertionUtilisateurs();

//		Date achat = new Date();
//
//		DocumentDto doc1 = new DocumentDto("nom", "cat", achat, achat, "desc", "com");
//		documentService.ajouterDocument(doc1);
//		MaterielDto materiel2 = new MaterielDto("Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
//		materielService.create(materiel2);
//		MaterielDto materiel = new MaterielDto("Neptune", "Cuve3000", 2000, "emplacement1", 1, achat, "cuve");
//		materielService.create(materiel);
//		MaterielDto materiel3 = new MaterielDto("Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
//		materielService.create(materiel2);
//
//		// INSERTION DE 2 USER AVEC COUPLE CONNEXION ET ADRESSE
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

//
//		Date dateAjoutDoc2 = new Date();
//		Date dateDerniereModificationdoc2 = new Date();
//		DocumentDto doc2 = new DocumentDto("facture entretien cuve n°4", "facture", dateAjoutDoc2, dateDerniereModificationdoc2, "facture qui correspond au dernier entretien de la cuve n°3.", "rien à signaler, fonctionnement de la cuve n°3 ok.");
//		documentService.ajouterDocument(doc2);
//		documentDao.save(DocumentEntity.builder().nomDocument("inventaire annuel magasin 2").categorieDocument("inventaire").dateAjoutDocument(dateAjoutDoc2).dateDerniereModificationDocument(dateDerniereModificationdoc2).descriptionDocument("inventaire du magasin avant réorganisation des rayons").commentairesDocument("inventaire effectué à 3 personnes en une journée").build());
//
//		Date dateAjoutDoc3 = new Date();
//		Date dateDerniereModificationdoc3 = new Date();
//		DocumentDto doc3 = new DocumentDto("facture entretien cuve n°5", "facture", dateAjoutDoc3, dateDerniereModificationdoc3, "facture qui correspond au dernier entretien de la cuve n°3.", "rien à signaler, fonctionnement de la cuve n°3 ok.");
//		documentService.ajouterDocument(doc3);
//		documentDao.save(DocumentEntity.builder().nomDocument("inventaire annuel magasin 3").categorieDocument("inventaire").dateAjoutDocument(dateAjoutDoc3).dateDerniereModificationDocument(dateDerniereModificationdoc3).descriptionDocument("inventaire du magasin avant réorganisation des rayons").commentairesDocument("inventaire effectué à 3 personnes en une journée").build());
//
//		Date dateAjoutDoc4 = new Date();
//		Date dateDerniereModificationdoc4 = new Date();
//		DocumentDto doc4 = new DocumentDto("facture entretien cuve n°6", "facture", dateAjoutDoc4, dateDerniereModificationdoc4, "facture qui correspond au dernier entretien de la cuve n°3.", "rien à signaler, fonctionnement de la cuve n°3 ok.");
//		documentService.ajouterDocument(doc4);
//		documentDao.save(DocumentEntity.builder().nomDocument("inventaire annuel magasin 4").categorieDocument("inventaire").dateAjoutDocument(dateAjoutDoc4).dateDerniereModificationDocument(dateDerniereModificationdoc4).descriptionDocument("inventaire du magasin avant réorganisation des rayons").commentairesDocument("inventaire effectué à 3 personnes en une journée").build());
//
//		Date dateAjoutDoc5 = new Date();
//		Date dateDerniereModificationdoc5 = new Date();
//		DocumentDto doc5 = new DocumentDto("facture entretien cuve n°7", "facture", dateAjoutDoc5, dateDerniereModificationdoc5, "facture qui correspond au dernier entretien de la cuve n°3.", "rien à signaler, fonctionnement de la cuve n°3 ok.");
//		documentService.ajouterDocument(doc5);
//		documentDao.save(DocumentEntity.builder().nomDocument("inventaire annuel magasin 5").categorieDocument("inventaire").dateAjoutDocument(dateAjoutDoc5).dateDerniereModificationDocument(dateDerniereModificationdoc5).descriptionDocument("inventaire du magasin avant réorganisation des rayons").commentairesDocument("inventaire effectué à 3 personnes en une journée").build());
//
//		Date dateAjoutDoc6 = new Date();
//		Date dateDerniereModificationdoc6 = new Date();
//		DocumentDto doc6 = new DocumentDto("facture entretien cuve n°8", "facture", dateAjoutDoc6, dateDerniereModificationdoc6, "facture qui correspond au dernier entretien de la cuve n°3.", "rien à signaler, fonctionnement de la cuve n°3 ok.");
//		documentService.ajouterDocument(doc6);
//		documentDao.save(DocumentEntity.builder().nomDocument("inventaire annuel magasin 6").categorieDocument("inventaire").dateAjoutDocument(dateAjoutDoc6).dateDerniereModificationDocument(dateDerniereModificationdoc6).descriptionDocument("inventaire du magasin avant réorganisation des rayons").commentairesDocument("inventaire effectué à 3 personnes en une journée").build());

////		documentDao.deleteById(27);
//
//		documentService.majCategorieDocument("blabla",23);
//
//		documentService.majDateAjoutDocument(dateAjoutDoc6, 31);
//
//		documentService.majDateDerniereModificationDocument(dateDerniereModificationdoc6, 39);
//
//		documentService.majDescriptionDocument("blablablablablablablablabla", 43);
//
//		documentService.majCommentairesDocument("commentaires commentaires commentaires", 49);
//
//		documentService.getDocument(41);
//
//		List<DocumentDto> listeDocs = new ArrayList<>();
//		listeDocs = documentService.getAllDocuments(2);
//
//		log.info(listeDocs.toString());
//
//		documentService.existById(42);
//
//		documentService.existById(29);

	}

	public void insertionUtilisateurs() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date dateNaissanceTest = null;
		try {
			dateNaissanceTest = simpleDateFormat.parse("15-01-1989");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// INSERTION DE 2 USER AVEC COUPLE CONNEXION ET ADRESSE
		UtilisateurDto utilisateur = new UtilisateurDto("EMP001", "pwd", "nomEMP", "prenomEMP", dateNaissanceTest, 2000.0,
				"employe@gmail.com", "06.06.06.06.06", false, 1, "rue de l'employé", "complément1", "59000", "LILLE",
				"France");
		utilisateurService.create(utilisateur);

		utilisateur = new UtilisateurDto("RESP001", "pwd", "nomRESP", "prenomRESP", dateNaissanceTest, 2500.0,
				"responsable@gmail.com", "07.07.07.07.07", true, 10, "rue du responsable", "complément2", "59100",
				"ROUBAIX", "France");
		utilisateurService.create(utilisateur);

	}

}
