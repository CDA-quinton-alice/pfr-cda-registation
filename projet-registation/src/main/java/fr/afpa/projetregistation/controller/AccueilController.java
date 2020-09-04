package fr.afpa.projetregistation.controller;

import java.time.YearMonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.projetregistation.dao.IEvenementDao;
import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.utils.Calendrier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccueilController {
	
	@Autowired
	IUtilisateurDao udao;
	
	@Autowired
	IEvenementDao edao;
	
	@GetMapping(value="/evenement/accueil")
	protected ModelAndView eventAccueil() {
		log.info("Accès à la page d'accueil");
		ModelAndView mv = new ModelAndView();
		YearMonth now = YearMonth.now();
		
		mv.addObject("calendrier",Calendrier.getFullMonthOfStr(now.getYear(), now.getMonthValue()));
		
		
		mv.setViewName("accueil");
		return mv;
	}
	
}
