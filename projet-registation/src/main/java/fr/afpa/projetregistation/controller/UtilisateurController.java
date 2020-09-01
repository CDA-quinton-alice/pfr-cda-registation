package fr.afpa.projetregistation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class UtilisateurController {

	@Autowired
	IUtilisateurDao utilisateurDao;
	
	@GetMapping(value="/testmat")
	protected ModelAndView connexion() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("utilisateur" , utilisateurDao.findAll());
		mv.setViewName("testmat");
		log.info("Acces page de connexion");
		return mv;
	}
	
}
