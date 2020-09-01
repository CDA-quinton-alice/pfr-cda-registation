package fr.afpa.projetregistation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dao.IDocumentDao;
import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.entity.DocumentEntity;
import fr.afpa.projetregistation.service.IDocumentService;
import fr.afpa.projetregistation.utils.Constantes;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *Cette classe implémente toutes les méthodes de service en lien avec les DocumentEntity en appelant les méthodes du IDocumentDao nécessaires.
 *
 * @author Alice Quinton
 * @version 1.0
 *
 */

@Slf4j
@Service
public class DocumentServiceImpl implements IDocumentService {

	@Autowired
	IDocumentDao documentDao;

	@Autowired
	IUtilisateurDao utilisateurDao;

	@Autowired
	private ModelMapper modelDocumentServiceImpl;


	@Override
	public DocumentDto ajouterDocument(DocumentDto document) {
		log.info("ajouter un document - Registation DocumentServiceImpl");
		/**
		 * @param Document Dto document : le document créé puis ajouté une fois la méthode exécutée
		 * @see DocumentEntity
		 * @see IDocumentDao
		 * @return document : Document Dto document : le document créé puis ajouté une fois la méthode exécutée
		 * Cette méthode va créer un nouveau DocumentEntity nommé document2 pour ensuite modifier
		 * tous ses attributs puis les récupérer dans document.
		 * document2 va se servir de l'interface IDocumentDao implémentée de
		 * PagingAndSortingRepository<DocumentEntity, Integer> pour sauver les informations
		 * en son sein.
		 * On va donc récupérer le fameux document via une recherche d'iD dans document2.
		 *
		 */

		// !!!! Vérifier présence en BDD.

		DocumentEntity document2 = new DocumentEntity();
//		document2.setIdDocument(document.getIdDocument());


		document2.setNomDocument(document.getNomDocument());
		document2.setCategorieDocument(document.getCategorieDocument());
		document2.setDateAjoutDocument(document.getDateAjoutDocument());
		document2.setDateDerniereModificationDocument(document.getDateDerniereModificationDocument());
		document2.setDescriptionDocument(document.getDescriptionDocument());
		document2.setCommentairesDocument(document.getCommentairesDocument());

//		document = this.modelDocumentServiceImpl.map(document2, DocumentDto.class);
		// toutes les lignes au dessus.

//		Optional<UtilisateurEntity> optionelUtilisateurEntity = utilisateurDao.findById(document.getIdDocument());
//		if (optionelUtilisateurEntity.isPresent()) {
//			document2.setUtilisateur(optionelUtilisateurEntity);
//		}
		document2 = documentDao.save(document2);

		document = this.getDocument(document2.getIdDocument());

		log.info("document ajouté avec succès - Registation DocumentServiceImpl");

		return document;

	}

	@Override
	public void supprimerDocument(int vIdDocument) {
		log.info("supprimer un document - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document qui va être supprimé
		 * @see IDocumentDao documentDao
		 * Cette méthode fait appel à l'interface IDocumentDao nommée ici documentDao implémentée de
		 * PagingAndSortingRepository<DocumentEntity, Integer> en faisant appel à la méthode deleteById
		 * qui fait une recherche par identifiant/valeur, puis supprime sa clé, donc le document qui s'y ratache.
		 */

		documentDao.deleteById(vIdDocument);
		log.info("document supprimé avec succès - Registation DocumentServiceImpl");
	}

	@Override
	public void majCategorieDocument(String vCategorieDocument, int vIdDocument) {
		log.info("Mettre à jour la catégorie d'un document - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document qui va être mis à jour
		 * @param String vCategorieDocument : c'est la catégorie du document qui va être mise à
		 * jour
		 * @see DocumentEntity
		 * @see IDocumentDao documentDao
		 * Cette méthode met en place la classe Optional pour stocker une clé DocumentEntity
		 * puis fait appel à l'interface IDocumentDao (nommée ici documentDao) implémentée de
		 * PagingAndSortingRepository<DocumentEntity, Integer> qui fait appel à la méthode findById
		 * en ayant pour paramètre vIdDocument.
		 * On créée une nouvelle instance DocumentEntity document3 que l'on initialise à null.
		 * Si les étapes avant la création de la nouvelle instance document3 se sont bien déroulées,
		 * on peut retrouver optionelDocumentEntity via la méthode isPresent().
		 * Si c'est le cas
		 *
		 */

		Optional<DocumentEntity> optionelDocumentEntity = documentDao.findById(vIdDocument);
		DocumentEntity document3 = null;
		if (optionelDocumentEntity.isPresent()) {
			document3 = optionelDocumentEntity.get();
		}
		document3.setCategorieDocument(vCategorieDocument);
		documentDao.save(document3);
		log.info("catégorie du document mise à jour avec succès - Registation DocumentServiceImpl");
	}

	@Override
	public void majDateAjoutDocument(Date vDateAjoutDocument, int vIdDocument) {
		log.info("Mettre à jour la date d'ajout d'un document - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document dont la date d'ajout va être mise à jour
		 */

		Optional<DocumentEntity> optionelDocumentEntity = documentDao.findById(vIdDocument);
		DocumentEntity document3 = null;
		if (optionelDocumentEntity.isPresent()) {
			document3 = optionelDocumentEntity.get();
		}
		document3.setDateAjoutDocument(vDateAjoutDocument);
		documentDao.save(document3);

		log.info("Date d'ajout du document mise à jour avec succès - Registation DocumentServiceImpl");
	}

	@Override
	public void majDateDerniereModificationDocument(Date vDateDerniereModificationDocument, int vIdDocument) {
		log.info("Mettre à jour la date de la dernière modification d'un document - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document dont la dernière date de modification va être mise à jour
		 */

		Optional<DocumentEntity> optionelDocumentEntity = documentDao.findById(vIdDocument);
		DocumentEntity document3 = null;
		if (optionelDocumentEntity.isPresent()) {
			document3 = optionelDocumentEntity.get();
		}
		document3.setDateDerniereModificationDocument(vDateDerniereModificationDocument);
		documentDao.save(document3);

		log.info("Date de la dernière modification du document mise à jour avec succès - Registation DocumentServiceImpl");
	}

	@Override
	public void majDescriptionDocument(String vDescriptionDocument, int vIdDocument) {
		log.info("Mettre à jour la description d'un document - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document dont la description va être mise à jour
		 */


		Optional<DocumentEntity> optionelDocumentEntity = documentDao.findById(vIdDocument);
		DocumentEntity document3 = null;
		if (optionelDocumentEntity.isPresent()) {
			document3 = optionelDocumentEntity.get();
		}
		document3.setDescriptionDocument(vDescriptionDocument);
		documentDao.save(document3);

		log.info("Description du document mise à jour avec succès - Registation DocumentServiceImpl");
	}

	@Override
	public void majCommentairesDocument(String vCommentairesDocument, int vIdDocument) {
		log.info("Mettre à jour les commentaires d'un document - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document dont les commentaires vont être mis à jour
		 */

		Optional<DocumentEntity> optionelDocumentEntity = documentDao.findById(vIdDocument);
		DocumentEntity document3 = null;
		if (optionelDocumentEntity.isPresent()) {
			document3 = optionelDocumentEntity.get();
		}
		document3.setCommentairesDocument(vCommentairesDocument);
		documentDao.save(document3);

		log.info("Commentaires du document mis à jour avec succès - Registation DocumentServiceImpl");
	}

	@Override
	public DocumentDto getDocument(int vIdDocument) {
		log.info("récupérer un document via une recherche de son iD - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document qui va être récupéré
		 */
		Optional<DocumentEntity> optionelDocumentEntity = documentDao.findById(vIdDocument);
		DocumentDto document = null;
		if(optionelDocumentEntity.isPresent()) {
			DocumentEntity document3 = optionelDocumentEntity.get();
			document = new DocumentDto(document3.getIdDocument(),
					document3.getCategorieDocument(),
					document3.getNomDocument(),
					document3.getDateAjoutDocument(),
					document3.getDateDerniereModificationDocument(),
					document3.getDescriptionDocument(),
					document3.getCommentairesDocument());
		}

		log.info("document récupéré avec succès - Registation DocumentServiceImpl");
		return document;
	}

	@Override
	public List<DocumentDto> getAllDocuments(int vPageEnCours) {
		log.info(" récupérer la liste de tous les documents - pagination - Registation DocumentServiceImpl");
		/**
		 * @param int vPageEnCours : c'est la page sur laquelle les documents en question vont être récupérés
		 */
		List<DocumentDto> listeDocumentsDto = new ArrayList();
		PageRequest page = PageRequest.of(vPageEnCours -1, Constantes.ELEMENTS_PAR_PAGE);
		Page<DocumentEntity> documentsEntity = this.documentDao.findAll(page);
		for (DocumentEntity document : documentsEntity) {
			DocumentDto document2 = new DocumentDto(document.getIdDocument(),
					document.getCategorieDocument(),
					document.getNomDocument(),
					document.getDateAjoutDocument(),
					document.getDateDerniereModificationDocument(),
					document.getDescriptionDocument(),
					document.getCommentairesDocument());

			listeDocumentsDto.add(document2);
		}
		log.info("liste des documents récupérée avec succès - Registation DocumentServiceImpl");
		return listeDocumentsDto;
	}

//	@Override
//	public int getMaxid() {
//
//
//		return documentDao.getMaxId().intValue();
//	}

	@Override
	public boolean existById(int vIdDocument) {
		log.info("savoir si un document existe via une recherche de son iD - Registation DocumentServiceImpl");
		/**
		 * @param int vIdDocument : c'est l'identifiant du document qui va être recherché pour savoir s'il existe ou pas
		 */
		boolean verification = false;

		DocumentDto document = this.getDocument(vIdDocument);
		if (document == null) {
			verification = true;
			log.info("ce document existe - Registation DocumentServiceImpl");
		} log.info("ce document n'existe pas - Registation DocumentServiceImpl");

		return verification;
	}

}
