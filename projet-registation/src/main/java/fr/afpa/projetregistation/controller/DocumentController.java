package fr.afpa.projetregistation.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class DocumentController {
//
//	@Autowired
//	IUtilisateurService utilisateurService;
//
//	@Autowired
//	IDocumentService documentService;
//
//
//	private ModelAndView modelDocument = new ModelAndView();
//
//
//
//	@RequestMapping(value = {"/document","/documents","listeDocuments","listeDesDocuments"}, method = {RequestMethod.POST, RequestMethod.GET})
//	protected ModelAndView listerDocuments(@RequestParam(value = "page", defaultValue = "1") int pageEnCours) {
//		log.info("liste des documents - Registation DocumentController");
//
//		List<DocumentDto> vListeDocuments = this.documentService.getAllDocuments(pageEnCours);
//
//		modelDocument.addObject("listeDocuments",vListeDocuments);
//		modelDocument.addObject("nombresElementsParPage", Constantes.ELEMENTS_PAR_PAGE);
//		modelDocument.addObject("pageEnCours", pageEnCours);
//
//		modelDocument.setViewName("document");
//
//		return modelDocument;
//	}
//
//
//
//@RequestMapping(value = { "/ajouterDocument"}, method = RequestMethod.POST)
//protected ModelAndView ajouterDocument(@RequestParam(value ="idDocument") int idDocument,
//		@RequestParam(value = "nomDocument") String nomDocument,
//		@RequestParam(value="categorieDocument") String categorieDocument,
//		@RequestParam(value="dateAjoutDocument") Date dateAjoutDocument,
//		@RequestParam(value="dateDerniereModificationDocument") Date dateDerniereModificationDocument,
//		@RequestParam(value="descriptionDocument") String descriptionDocument,
//		@RequestParam(value="commentairesDocument") String commentairesDocument){
//		log.info("ajouter un document - Registation DocumentController");
//
//	modelDocument.setViewName("forward:/index");
//
//	return modelDocument;
//
//}
//
//@RequestMapping(value = { "/majCategorieDocument"}, method = RequestMethod.POST)
//protected ModelAndView majCategorieDocument(@RequestParam(value="categorieDocument") String pCategorieDocument,@RequestParam(value="idDocument")int pIdDocument) {
//
//	log.info("mettre à jour la catégorie d'un document via une recherche de son iD - Registation DocumentController");
//
//	documentService.majCategorieDocument(pCategorieDocument,pIdDocument);
//	modelDocument.setViewName("forward:/index");
//
//	return modelDocument;
//
//}
//
//@RequestMapping(value = { "/majDateAjoutDocument"}, method = RequestMethod.POST)
//protected ModelAndView majDateAjoutDocument (@RequestParam(value="dateAjoutDocument") Date pDateAjoutDocument, @RequestParam(value="idDocument")int pIdDocument) {
//
//	log.info("mettre à jour la date d'ajout d'un document via une recherche de son iD - Registation DocumentController");
//
//	documentService.majDateAjoutDocument(pDateAjoutDocument, pIdDocument);
//	modelDocument.setViewName("forward:/index");
//
//	return modelDocument;
//}
//
//@RequestMapping(value = { "/majDateDerniereModificationDocument"}, method = RequestMethod.POST)
//protected ModelAndView majDateDerniereModificationDocument (@RequestParam(value="dateDerniereModificationDocument") Date pDateDerniereModificationDocument,
//		@RequestParam(value = "idDocument") int pIdDocument) {
//
//	log.info("mettre à jour la date de la dernière modification d'un document via une recherche de son iD - Registation DocumentController");
//
//	documentService.majDateDerniereModificationDocument(pDateDerniereModificationDocument, pIdDocument);
//	modelDocument.setViewName("forward:/index");
//
//	return modelDocument;
//
//}
//
//@RequestMapping(value = {"/majDescriptionDocument"}, method = RequestMethod.POST)
//protected ModelAndView majDescriptionDocument (@RequestParam(value = "descriptionDocument") String pDescriptionDocument,
//		@RequestParam(value = "idDocument") int pIdDocument) {
//
//	log.info("mettre à jour la description d'un document via une recherche de son iD - Registation DocumentController");
//
//	documentService.majDescriptionDocument(pDescriptionDocument, pIdDocument);
//	modelDocument.setViewName("forward:/index");
//
//	return modelDocument;
//}
//
//@RequestMapping(value = {"/majCommentairesDocument"}, method = RequestMethod.POST)
//protected ModelAndView majCommentairesDocument (@RequestParam(value = "CommentairesDocument") String pCommentairesDocument,
//		@RequestParam(value ="idDocument")int pIdDocument) {
//
//	log.info("mettre à jour les commentaires d'un document via une recherche de son iD - Registation DocumentController");
//
//	documentService.majCommentairesDocument(pCommentairesDocument, pIdDocument);
//	modelDocument.setViewName("forward:/index");
//
//	return modelDocument;
//}
//
//
//
//	@RequestMapping(value = { "/supprimerDocument"}, method = RequestMethod.POST)
//	protected ModelAndView supprimerDocument(@RequestParam(value="idDocument")int pIdDocument) {
//
//		log.info("supprimer un document via une recherche de son iD - Registation DocumentController");
//
//		documentService.supprimerDocument(pIdDocument);
//		modelDocument.setViewName("forward:/index");
//
//		return modelDocument;
//	}

}
