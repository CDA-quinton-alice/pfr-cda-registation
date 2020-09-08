package fr.afpa.projetregistation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.service.ITypeMaterielService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class MaterielController {

	@Autowired
	IMaterielService materielService;

	@Autowired
	ITypeMaterielService typeService;

	@GetMapping("/responsable/materiel")
	public String accueil(Model model) {

		log.debug("appel materiel registation");

//		model.addAttribute("materiel", materielService.getAllByType(2, "POMPE"));
//
		MaterielDto materiel = materielService.getMaterielById(3);
//
//
		model.addAttribute("materiel", typeService.getTypeByMateriel(materiel).toString());

		return "materiel";
	}
}
