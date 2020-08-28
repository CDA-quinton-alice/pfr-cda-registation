package fr.afpa.projetregistation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.service.IDocumentService;
import fr.afpa.projetregistation.service.IUtilisateurService;
import fr.afpa.projetregistation.utils.Constantes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class DocumentController {

	@Autowired
	IUtilisateurService utilisateurService;

	@Autowired
	IDocumentService documentService;

	@Autowired
	ModelAndView modelDocument;



	@RequestMapping(value = {"/document","/documents","listeDocuments","listeDesDocuments"}, method = {RequestMethod.POST, RequestMethod.GET})
	protected ModelAndView listerDocuments(@RequestParam(value = "page", defaultValue = "1") int pageEnCours) {
		log.debug("liste des documents - Registation");

		List<DocumentDto> vListeDocuments = this.documentService.getAllDocuments(pageEnCours);

		modelDocument.addObject("listeDocuments",vListeDocuments);
		modelDocument.addObject("nombresElementsParPage", Constantes.ELEMENTS_PAR_PAGE);
		modelDocument.addObject("count", this.documentService.count());
		modelDocument.addObject("pageEnCours", pageEnCours);

		modelDocument.setViewName("document");

		return modelDocument;
	}



@RequestMapping(value = { "/ajouterDocument"}, method = RequestMethod.POST)
protected ModelAndView ajouterDocument(@RequestParam(value ="idDocument") int idDocument,
		@RequestParam(value = "nomDocument") String nomDocument,
		@RequestParam(value="categorieDocument") String categorieDocument,
		@RequestParam(value="dateAjoutDocument") Date dateAjoutDocument,
		@RequestParam(value="dateDerniereModificationDocument") Date dateDerniereModificationDocument,
		@RequestParam(value="descriptionDocument") String descriptionDocument,
		@RequestParam(value="commentairesDocument") String commentairesDocument){

	modelDocument.setViewName("forward:/accueil");

	return modelDocument;

}

@RequestMapping(value = { "/majCategorieDocument"}, method = RequestMethod.POST)
protected ModelAndView majCategorieDocument(@RequestParam(value="categorieDocument") String pCategorieDocument,@RequestParam(value="idDocument")int pIdDocument) {

	documentService.majCategorieDocument(pCategorieDocument,pIdDocument);
	modelDocument.setViewName("forward:/accueil");

	return modelDocument;

}

@RequestMapping(value = { "/majDateAjoutDocument"}, method = RequestMethod.POST)
protected ModelAndView majDateAjoutDocument (@RequestParam(value="dateAjoutDocument") Date pDateAjoutDocument, @RequestParam(value="idDocument")int pIdDocument) {

	documentService.majDateAjoutDocument(pDateAjoutDocument, pIdDocument);
	modelDocument.setViewName("forward:/accueil");

	return modelDocument;
}

@RequestMapping(value = { "/majDateDerniereModificationDocument"}, method = RequestMethod.POST)
protected ModelAndView majDateDerniereModificationDocument (@RequestParam(value="dateDerniereModificationDocument") Date pDateDerniereModificationDocument,
		@RequestParam(value = "idDocument") int pIdDocument) {

	documentService.majDateDerniereModificationDocument(pDateDerniereModificationDocument, pIdDocument);
	modelDocument.setViewName("forward:/accueil");

	return modelDocument;

}

@RequestMapping(value = {"/majDescriptionDocument"}, method = RequestMethod.POST)
protected ModelAndView majDescriptionDocument (@RequestParam(value = "descriptionDocument") String pDescriptionDocument,
		@RequestParam(value = "idDocument") int pIdDocument) {

	documentService.majDescriptionDocument(pDescriptionDocument, pIdDocument);
	modelDocument.setViewName("forward:/accueil");


	return modelDocument;
}

@RequestMapping(value = {"/majCommentairesDocument"}, method = RequestMethod.POST)
protected ModelAndView majCommentairesDocument (@RequestParam(value = "CommentairesDocument") String pCommentairesDocument,
		@RequestParam(value ="idDocument")int pIdDocument) {

	documentService.majCommentairesDocument(pCommentairesDocument, pIdDocument);
	modelDocument.setViewName("forward:/accueil");


	return modelDocument;
}



	@RequestMapping(value = { "/supprimerDocument"}, method = RequestMethod.POST)
	protected ModelAndView supprimerDocument(@RequestParam(value="idDocument")int pIdDocument) {

		documentService.supprimerDocument(pIdDocument);
		modelDocument.setViewName("forward:/accueil");

		return modelDocument;



	}







}
