package fr.afpa.projetregistation.service.impl.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.service.IDocumentService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TestDocumentServiceImpl {

	@Autowired
	private IDocumentService documentService;

	private Date date = new Date();
	private DocumentDto document = new DocumentDto("nom", "categorie", date, date, "description", "commentaire");

	@Test
	@Order(1)
	public void testAjouterDocument() throws Exception {

		document = documentService.ajouterDocument(document);

		assertNotNull(document);
		assertEquals("nom ", document.getNomDocument());
		assertEquals("categorie", document.getCategorieDocument());
		assertEquals(date, document.getDateAjoutDocument());
		assertEquals(date, document.getDateDerniereModificationDocument());
		assertEquals("description", document.getDescriptionDocument());
		assertEquals("commentaire", document.getCommentairesDocument());
	}
}