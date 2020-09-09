package fr.afpa.projetregistation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.afpa.projetregistation.dto.EvenementDto;
import fr.afpa.projetregistation.service.IEvenementService;
import fr.afpa.projetregistation.service.IUtilisateurService;
import fr.afpa.projetregistation.utils.Calendrier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccueilController {
	
	@Autowired
	IUtilisateurService userv;
	
	@Autowired
	IEvenementService eserv;
	
	@GetMapping(value="/evenement/accueil")
	protected ModelAndView eventGet() {
		log.info("Accès à la page d'accueil");
		
		ModelAndView mv = new ModelAndView();
		YearMonth now = YearMonth.now();
		List<String> cal = Calendrier.getFullMonthOfStr(now.getYear(), now.getMonthValue());
		SimpleDateFormat dtf = new SimpleDateFormat("EEEE-dd-MM-yyyy",Locale.FRENCH);
		Date deb = null;
		Date fin = null;
		
		try {
			deb = dtf.parse(cal.get(0));
			fin = dtf.parse(cal.get(cal.size()-1));
			log.debug(deb.toString());
			log.debug(fin.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<EvenementDto> listEvent = eserv.getByDate(deb, fin);
		mv.addObject("calendrier",cal);
//		mv.addObject("titre",Calendrier.localizeMonth(now.getMonthValue()));
//		mv.addObject("event",listEvent);
//		mv.addObject("current", YearMonth.now());
		mv.setViewName("calendrier");
		return mv;
	}
	
	@PostMapping(value="/evenement/accueil")
	@ResponseBody
	protected ResponseEntity<String> eventPost(@RequestParam("year") int annee, @RequestParam("month") int mois, @RequestParam("action") char action) {
		log.info("Accès à la page d'accueil");
		YearMonth ym = null;
		if(action=='p') {
			ym = Calendrier.getPrevYearMonth(YearMonth.of(annee,mois));
		}else if(action=='s') {
			ym = Calendrier.getNextYearMonth(YearMonth.of(annee,mois));
		}else if(action=='n'){
			ym = YearMonth.of(annee,mois);
		}
		log.debug(ym.toString());
		
		List<String> cal = Calendrier.getFullMonthOfStr(ym.getYear(), ym.getMonthValue());
		SimpleDateFormat dtf = new SimpleDateFormat("EEEE-dd-MM-yyyy",Locale.FRENCH);
		Date deb = null;
		Date fin = null;
		
		try {
			deb = dtf.parse(cal.get(0));
			fin = dtf.parse(cal.get(cal.size()-1));
			log.debug(deb.toString());
			log.debug(fin.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List<EvenementDto> listEvent = eserv.getByDate(deb, fin);
		String res = "{"
				+ "\"calendrier\":\""+cal+"\","
				+ "\"titre\":\""+Calendrier.localizeMonth(ym.getMonthValue())+"\","
				+ "\"event\":\""+listEvent+"\","
				+ "\"current\":\""+ym+"\","
				+ "\"success\":1"
				+ "}";
		if(listEvent!=null) {
			log.debug(listEvent.toString());
		}else {
			log.debug("Liste NULL");
		}
		return ResponseEntity.ok(res);
	}
}
