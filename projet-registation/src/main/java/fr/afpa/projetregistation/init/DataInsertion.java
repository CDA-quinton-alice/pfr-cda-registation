package fr.afpa.projetregistation.init;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IDocumentDao;
import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.dto.EvenementDto;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.entity.UtilisateurEntity;
import fr.afpa.projetregistation.service.IDocumentService;
import fr.afpa.projetregistation.service.IEvenementService;
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
	IUtilisateurDao udao;

	@Autowired
	IDocumentDao documentDao;

	@Autowired
	IDocumentService documentService;
	
	@Autowired
	IEvenementService eserv;

	@PostConstruct
	public void cdaInit() {

		this.insertionMateriel();
		this.insertionUtilisateurs();

		Date dateAjoutDoc = new Date();
		Date dateDerniereModificationdoc = new Date();
		DocumentDto doc = new DocumentDto("facture entretien cuve n°3", "facture", dateAjoutDoc,
				dateDerniereModificationdoc, "facture qui correspond au dernier entretien de la cuve n°3.",
				"rien à signaler, fonctionnement de la cuve n°3 ok.");
		documentService.ajouterDocument(doc);

//		Date date = new Date();
//		DocumentDto documentt = new DocumentDto("nom", "categorie", date, date, "description", "commentaire");
//		documentService.ajouterDocument(documentt);
//		DocumentDto documentt2 = new DocumentDto("nom2", "categorie2", date, date, "description2", "commentaire2");
//		documentService.ajouterDocument(documentt2);
//		DocumentDto documentt3 = new DocumentDto("nom3", "categorie3", date, date, "description3", "commentaire3");
//		documentService.ajouterDocument(documentt3);
//		DocumentDto documentt4 = new DocumentDto("nom4", "categorie4", date, date, "description4", "commentaire4");
//		documentService.ajouterDocument(documentt4);
//		DocumentDto documentt5 = new DocumentDto("nom5", "categorie5", date, date, "description5", "commentaire5");
//		documentService.ajouterDocument(documentt5);
//		DocumentDto documentt6 = new DocumentDto("nom6", "categorie6", date, date, "description6", "commentaire6");
//		documentService.ajouterDocument(documentt6);
//		DocumentDto documentt7 = new DocumentDto("nom7", "categorie7", date, date, "description7", "commentaire7");
//		documentService.ajouterDocument(documentt7);
//		DocumentDto documentt8 = new DocumentDto("nom8", "categorie8", date, date, "description8", "commentaire8");
//		documentService.ajouterDocument(documentt8);
//		DocumentDto documentt9 = new DocumentDto("nom9", "categorie9", date, date, "description9", "commentaire9");
//		documentService.ajouterDocument(documentt9);
//		DocumentDto documentt10 = new DocumentDto("nom10", "categorie10", date, date, "description10", "commentaire10");
//		documentService.ajouterDocument(documentt10);
//		DocumentDto documentt11 = new DocumentDto("nom11", "categorie11", date, date, "description11", "commentaire11");
//		documentService.ajouterDocument(documentt11);

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
		
		
		//Ajout de 2 évènements
		insertionEvenements();

	}

	public void insertionMateriel() {
		// Ajout de trois matériels.

		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date achat = null;
		try {
			achat = simpleDateFormat.parse("15-01-1989");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MaterielDto materiel = new MaterielDto("P001", "Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
		materielService.create(materiel);
		MaterielDto materiel2 = new MaterielDto("C001", "Neptune", "Cuve3000", 2000, "emplacement1", 1, achat, "cuve");
		materielService.create(materiel2);
		MaterielDto materiel3 = new MaterielDto("P002", "Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
		materielService.create(materiel3);
		MaterielDto materiel4 = new MaterielDto("P003", "Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
		materielService.create(materiel4);
		MaterielDto mat3 = new MaterielDto("MC001", "Mars", "Cafe3000", 200, "allée 1", 1, achat, "MACHINE A CAFE");
		materielService.create(mat3);
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
		UtilisateurDto utilisateur = new UtilisateurDto("EMP001", "pwd1", "nomEMP", "prenomEMP", dateNaissanceTest,
				2000.0, "employe@gmail.com", "06.06.06.06.06", false, 1, "rue de l'employé", "complément1", "59000",
				"LILLE", "France");
		utilisateurService.create(utilisateur);

		utilisateur = new UtilisateurDto("RESP001", "pwd2", "nomRESP", "prenomRESP", dateNaissanceTest, 2500.0,
				"responsable@gmail.com", "07.07.07.07.07", true, 10, "rue du responsable", "complément2", "59100",
				"ROUBAIX", "France");
		utilisateurService.create(utilisateur);

	}
	
	public void insertionEvenements() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String d1 = "30-08-2020";
		String d2 = "01-09-2020";
		Date date1 = null;
		Date date2 = null;
		int diff = 0;
		
		try {
			date1 = sdf.parse(d1);
			date2 = sdf.parse(d2);
			long mse = date2.getTime()-date1.getTime();
			diff = (int)TimeUnit.SECONDS.convert(mse, TimeUnit.MILLISECONDS); 
		}catch(ParseException e) {
			log.warn("Erreur lors du parsing des dates lors du test unitaire !");
		}

		Optional<UtilisateurEntity> optUser = udao.findById("EMP001");
		
		if(optUser.isPresent()) {
			UtilisateurEntity user = optUser.get();
			log.debug(user.getMatricule());
			EvenementDto ee = EvenementDto.builder().type("Révision")
					.description("test1")
					.date_debut(date1)
					.date_fin(date2)
					.duree(diff)
					.user(user).build();
			 
			if(eserv.getByType("Révision") == null) {
				ee = eserv.create(ee);
			}else {
				log.info("Révision n'a été ajouté !");
			}
		}
		
		String d3 = "01-09-2020";
		String d4 = "05-09-2020";
		Date date3 = null;
		Date date4 = null;
		diff = 0;
		
		try {
			date3 = sdf.parse(d3);
			date4 = sdf.parse(d4);
			long mse = date4.getTime()-date3.getTime();
			diff = (int)TimeUnit.SECONDS.convert(mse, TimeUnit.MILLISECONDS); 
		}catch(ParseException e) {
			log.warn("Erreur lors du parsing des dates lors du test unitaire !");
		}
		
		if(optUser.isPresent()) {
			UtilisateurEntity user = optUser.get();
			EvenementDto ee = EvenementDto.builder().type("Inspection")
					.description("test2")
					.date_debut(date3)
					.date_fin(date4)
					.duree(diff)
					.user(user).build();
			
			if(eserv.getByType("Inspection") == null) {
				ee = eserv.create(ee);
			}else {
				log.info("Inspection n'a été ajouté !");
			}
		}  
	}

}
