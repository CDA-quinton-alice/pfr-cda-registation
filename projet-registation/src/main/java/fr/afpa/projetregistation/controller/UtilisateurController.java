package fr.afpa.projetregistation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.service.IUtilisateurService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class UtilisateurController {

	@Autowired
	IUtilisateurDao utilisateurDao;
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@GetMapping(value="/responsable")
	protected ModelAndView connexion() {
		ModelAndView mv = new ModelAndView();
		
		log.info("Acces page test Responsable");
		
		mv.addObject("utilisateur" , utilisateurDao.findAll());
		mv.addObject("user" , utilisateurService.getUtilisateurByName("nomEMP"));
		
		mv.setViewName("responsable");
		return mv;
	}
	
}
