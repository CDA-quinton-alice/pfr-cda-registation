package fr.afpa.projetregistation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.projetregistation.dao.IDocumentTestDao;
import fr.afpa.projetregistation.entity.DocumentTestEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class DocumentControllerTest {

	@Autowired
	IDocumentTestDao documentDao;

	@GetMapping("/documenttest")
    public List<DocumentTestEntity> getDocuments() {
        return (List<DocumentTestEntity>) documentDao.findAll();
    }

    @PostMapping("/documenttest")
    void addDocument(@RequestBody DocumentTestEntity document) {
    	documentDao.save(document);
    }


}
