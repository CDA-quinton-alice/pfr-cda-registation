package fr.afpa.projetregistation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.dto.UtilisateurSimpleDto;
import fr.afpa.projetregistation.entity.UtilisateurEntity;
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

//	@RequestMapping(value = "/utilisateurtest", method = { RequestMethod.POST, RequestMethod.GET })
//	protected ModelAndView connexion() {
//		ModelAndView mv = new ModelAndView();
//
//		// Récupération du context Spring Security
//		Authentication authentification = SecurityContextHolder.getContext().getAuthentication();
//
//		String userConnecte = authentification.getName();
//		UtilisateurDto vUserDto = utilisateurService.getUtilisateurByMatricule(userConnecte);
//
//		log.info(authentification.toString());
//
//		log.info("Acces page test Responsable");
//
//		mv.addObject("utilisateur", utilisateurDao.findAll());
//		mv.addObject("session", "Utilisateur Par Nom");
//
////		mv.addObject("utilisateur", utilisateurService.getUtilisateurByMatricule(authentification.getName()));
//
//		mv.addObject("infoUtilisateur", vUserDto);
//
//		mv.setViewName("accueil");
//		return mv;
//	}
	
	@GetMapping("/utilisateurtest")
    public List<UtilisateurSimpleDto> findAll() {
        return (List<UtilisateurSimpleDto>) utilisateurService.getAllUtilisateurs(1);
    }

	@PostMapping("/utilisateurtest")
    public void addUser(@RequestBody UtilisateurDto pUtilisateur) {
		utilisateurService.create(pUtilisateur);       
    }	
	
}
