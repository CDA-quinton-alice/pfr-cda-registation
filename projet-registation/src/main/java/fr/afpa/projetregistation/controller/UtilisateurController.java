package fr.afpa.projetregistation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.service.IUtilisateurService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UtilisateurController {

	@Autowired
	IUtilisateurDao utilisateurDao;

	@Autowired
	IUtilisateurService utilisateurService;

	@RequestMapping(value = "/responsable/accueil", method = { RequestMethod.POST, RequestMethod.GET })
	protected ModelAndView connexion() {
		ModelAndView mv = new ModelAndView();

		// Récupération du context Spring Security
		Authentication authentification = SecurityContextHolder.getContext().getAuthentication();

		String userConnecte = authentification.getName();
		UtilisateurDto vUserDto = utilisateurService.getUtilisateurByMatricule(userConnecte);

		log.info(authentification.toString());

		log.info("Acces page test Responsable");

		mv.addObject("utilisateur", utilisateurDao.findAll());
		mv.addObject("session", "Utilisateur Par Nom");

//		mv.addObject("utilisateur", utilisateurService.getUtilisateurByMatricule(authentification.getName()));

		mv.addObject("infoUtilisateur", vUserDto);

		mv.setViewName("accueil");
		return mv;
	}

}
