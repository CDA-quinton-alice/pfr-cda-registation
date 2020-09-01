package fr.afpa.projetregistation.service.impl.test;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afpa.projetregistation.service.IDocumentService;
import fr.afpa.projetregistation.service.IUtilisateurService;

public class TestDocumentServiceImpl {

	@Autowired
	private IUtilisateurService utilisateurService;

	@Autowired
	private IDocumentService documentService;

//	@Test
//	@Order(1)
//	public void testAjouterDocument() throws Exception {
//
//		DocumentDto document = new DocumentDto(Constantes.STRING_TEST, Constantes.STRING_TEST, Constantes.DATE_TEST, Constantes.DATE_TEST, Constantes.STRING_TEST, Constantes.STRING_TEST);
//
//		document = documentService.ajouterDocument(document);
//
//		assertNotNull(document);
//		assertEquals(Constantes.STRING_TEST, document.getNomDocument());
//		assertEquals(Constantes.STRING_TEST, document.getCategorieDocument());
//		assertEquals(Constantes.DATE_TEST, document.getDateAjoutDocument());
//		assertEquals(Constantes.DATE_TEST, document.getDateDerniereModificationDocument());
//		assertEquals(Constantes.STRING_TEST, document.getDescriptionDocument());
//		assertEquals(Constantes.STRING_TEST, document.getCommentairesDocument());
//}
}