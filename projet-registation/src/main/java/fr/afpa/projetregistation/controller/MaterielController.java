package fr.afpa.projetregistation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.afpa.projetregistation.service.IMaterielService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class MaterielController {

	@Autowired
	IMaterielService materielService;

	@GetMapping("/accueil")
	public String accueil(Model model) {
		log.debug("appel materiel registation");

		model.addAttribute("materiel", materielService.getAll());

		return "accueil";
	}
}
