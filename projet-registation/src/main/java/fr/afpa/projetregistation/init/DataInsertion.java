package fr.afpa.projetregistation.init;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afpa.projetregistation.dao.IDocumentDao;
import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.entity.DocumentEntity;
import fr.afpa.projetregistation.service.IDocumentService;
import fr.afpa.projetregistation.service.IMaterielService;

@Component
public class DataInsertion {

	@Autowired
	IMaterielDao materielDao;

	@Autowired
	IMaterielService materielService;

	@Autowired
	IDocumentDao documentDao;

	@Autowired
	IDocumentService documentService;

	@PostConstruct
	public void cdaInit() {

//		materielDao
//				.save(MaterielEntity.builder().marque("Neptune").modele("p500").localisation("emplacement 1").build());

//		Date achat = new Date();
//		MaterielDto materiel = new MaterielDto("Neptune", "Cuve3000", 2000, "emplacement1", 1, achat, "cuve");
//		materielService.create(materiel);
//		MaterielDto materiel2 = new MaterielDto("Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
//		materielService.create(materiel2);

		Date dateAjoutDoc = new Date();
		Date dateDerniereModificationdoc = new Date();
		DocumentDto doc = new DocumentDto("facture entretien cuve n°3", "facture", dateAjoutDoc,
				dateDerniereModificationdoc, "facture qui correspond au dernier entretien de la cuve n°3.",
				"rien à signaler, fonctionnement de la cuve n°3 ok.");
		documentService.ajouterDocument(doc);
		documentDao
				.save(DocumentEntity.builder().nomDocument("inventaire annuel magasin").categorieDocument("inventaire")
						.dateAjoutDocument(dateAjoutDoc).dateDerniereModificationDocument(dateDerniereModificationdoc)
						.descriptionDocument("inventaire du magasin avant réorganisation des rayons")
						.commentairesDocument("inventaire effectué à 3 personnes en une journée").build());

	}
}
