package fr.afpa.projetregistation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.MessageContactDto;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.dto.UtilisateurSimpleDto;
import fr.afpa.projetregistation.service.IUtilisateurService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

	@Autowired
	IUtilisateurDao utilisateurDao;

	@Autowired
	IUtilisateurService utilisateurService;

	@GetMapping("/utilisateurtest")
	public List<UtilisateurSimpleDto> findAll() {
		return (List<UtilisateurSimpleDto>) utilisateurService.getAllUtilisateurs(1);
	}

	@PostMapping("/utilisateurtest")
	public void addUser(@RequestBody UtilisateurDto pUtilisateur) {
		utilisateurService.create(pUtilisateur);
	}

	@DeleteMapping("/utilisateurtest/{matriculeToDelete}")
	public void supprimerUtilisateur(@PathVariable(value = "matriculeToDelete") String pMatriculeToDelete) {
		utilisateurService.deleteUtilisateurByMatricule(pMatriculeToDelete);
	}

//	@PostMapping("/utilisateurtest/contact")
//	public void contactUs(@RequestBody String pEmail) {
//		utilisateurService.contactUs(pEmail);
//	}
	
	@PostMapping("/utilisateurtest/contact")
	public void contactUs(@RequestBody String pEmail) {
		log.info("------> OK POST email reçu format JSON : "+pEmail);
		String[] tab = pEmail.split("\"");		
		String emailRecup = tab[3];
		utilisateurService.contactUs(emailRecup);
	}

}
