package fr.afpa.projetregistation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.afpa.projetregistation.service.IPersonneService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PersonneController {

	@Autowired
	IPersonneService personneService;
	
	@GetMapping("/accueil")
	public String accueil(Model model) {
		log.debug("appel accueil registation");
		
		model.addAttribute("personnes", personneService.getAll());
		
		return "accueil";
	}
	
}
