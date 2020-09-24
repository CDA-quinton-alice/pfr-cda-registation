package fr.afpa.projetregistation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.projetregistation.dao.IDocumentTestDao;
import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.entity.DocumentTestEntity;
import fr.afpa.projetregistation.service.IDocumentService;
import lombok.extern.slf4j.Slf4j;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class DocumentControllerTest {

	@Autowired
	IDocumentService documentService;



	@GetMapping("/documenttest")
    public List<DocumentDto> getDocuments() {
		List<DocumentDto> documentsListe = documentService.getAllDocuments(1);
        return documentsListe;
    }

    @PostMapping("/documenttest")
    void addDocument(@RequestBody DocumentDto document) {
    	documentService.ajouterDocument(document);
    }


}
