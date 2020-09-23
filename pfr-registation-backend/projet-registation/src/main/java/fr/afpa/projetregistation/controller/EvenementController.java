package fr.afpa.projetregistation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import fr.afpa.projetregistation.dto.EvenementDto;
import fr.afpa.projetregistation.service.IEvenementService;
import fr.afpa.projetregistation.service.IUtilisateurService;
import fr.afpa.projetregistation.utils.Calendrier;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EvenementController {
	
	@Autowired
	IUtilisateurService userv;
	
	@Autowired
	IEvenementService eserv;
	
	@GetMapping(value="/evenement/{year}/{month}/{action}")
	protected ResponseEntity<String> eventPost(@PathVariable(value="year") int annee, @PathVariable(value="month") int mois, @PathVariable(value="action") char action) {
		log.info("Accès à la page d'accueil");
		YearMonth ym = null;
		if(action=='p') {
			ym = Calendrier.getPrevYearMonth(YearMonth.of(annee,mois));
		}else if(action=='s') {
			ym = Calendrier.getNextYearMonth(YearMonth.of(annee,mois));
		}else if(action=='n'){
			ym = YearMonth.of(annee,mois);
		}else {
			return null;
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
		
		Gson gson = new Gson();
		Map<String,Object> res2 = new HashMap<>();
		res2.put("calendrier",cal);
		res2.put("titre",Calendrier.localizeMonth(ym.getMonthValue()));
		res2.put("event", listEvent);
		res2.put("current", ym);
		res2.put("success", 1);
		
		if(listEvent!=null) {
			log.debug(listEvent.toString());
		}else {
			log.debug("Liste NULL");
		}
		return ResponseEntity.ok(gson.toJson(res2));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/evenement/create")
	protected ResponseEntity<EvenementDto> creeEvenement(@RequestParam Map<String,String> params){
		log.debug(params.toString());
		
		return ResponseEntity.ok(new EvenementDto());
	}
}
