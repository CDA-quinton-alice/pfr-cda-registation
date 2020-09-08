package fr.afpa.projetregistation.utils;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * Il s'agit d'un outil nécessaire afin d'afficher les dates d'un système de Calendrier.
 * Le tout permet d'avoir un nombre "carré" de jour pour remplir toutes les cases
 * de Lundi à Vendredi sur 5/6 semaines en fonction du moment de l'année
 * 
 * @author Samuel
 *
 */
public class Calendrier {
	
	/**
	 * Récupère le premier jour d'un mois/année souhaité.
	 * Le premier jour est formaté grâce à {@link DataTimeFormatter}
	 * 
	 * @param year {@link Integer} : Correspond à l'année souhaitée
	 * @param month {@link Integer} : Valeur numérique du mois de l'année souhaitée
	 * @return {@link String} "EEEE-dd-MM-yyyy" : {@link String} formaté correspondant au jour complet du premier jour du mois
	 */
	public static String getFirstDayOf(int year, int month) {
		List<LocalDate> mois = getFullMonthOf(year, month);
		LocalDate dayone = mois.get(0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE-dd-MM-yyyy");
		return dayone.format(dtf);
		
	}
	
	/**
	 * Récupère le dernier jour d'un mois/année souhaité.
	 * Le dernier jour est formaté grâce à {@link DataTimeFormatter}
	 * 
	 * @param year {@link Integer} : Correspond à l'année souhaitée
	 * @param month {@link Integer} : Valeur numérique du mois de l'année souhaitée
	 * @return {@link String} "EEEE-dd-MM-yyyy" : {@link String} formaté correspondant au jour complet du dernier jour du mois
	 */
	public static String getLastDayOf(int year, int month) {
		List<LocalDate> mois = getFullMonthOf(year, month);
		LocalDate dayone = mois.get(mois.size()-1);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE-dd-MM-yyyy");
		return dayone.format(dtf);
		
	}
	
	/**
	 * Permet de récupérer le mois/année précédent d'un mois/année placé en paramètre
	 * 
	 * @param ym {@link YearMonth} : Année/Mois dont on veut le mois précédent
	 * @return {@link YearMonth} : L'année et le mois précédent à celui placé en paramètre
	 */
	public static YearMonth getPrevYearMonth(YearMonth ym) {
		if(ym.getMonthValue()>1) {
			return YearMonth.of(ym.getYear(), ym.getMonthValue()-1);
		}else {
			return YearMonth.of(ym.getYear()-1, 12);
		}
	}
	
	/**
	 * Permet de récupérer le mois/année suivant d'un mois/année placé en paramètre
	 * 
	 * @param ym {@link YearMonth} : Année/Mois dont on veut le mois suivant
	 * @return {@link YearMonth} : L'année et le mois suivant à celui placé en paramètre
	 */
	public static YearMonth getNextYearMonth(YearMonth ym) {
		if(ym.getMonthValue()<12) {
			return YearMonth.of(ym.getYear(), ym.getMonthValue()+1);
		}else {
			return YearMonth.of(ym.getYear()+1, 1);
		}
	}

	
	/**
	 * Outil de calcule du nombre de jour nécessaire pour compléter les jours avant le 1er du mois
	 * dans le calendrier
	 * 
	 * @param firstDay {@link String} : Le premier jour du mois formatté grâce au {@link DataTimeFormatter} "EEEE-dd-MM-yyyy"
	 * @return {@link Integer} Nombre de jour pour compléter le début du calendrier
	 */ 
	public static int getNbPrevJour(String firstDay) {
		
		String j = StringUtils.capitalize(firstDay.split("\\-")[0]);


		int nbJourPrev = 0;
		switch (j) {
		case "Mardi":
			nbJourPrev = 1;
			break;
		case "Mercredi":
			nbJourPrev = 2;
			break;
		case "Jeudi":
			nbJourPrev = 3;
			break;
		case "Vendredi":
			nbJourPrev = 4;
			break;
		case "Samedi":
			nbJourPrev = 5;
			break;
		case "Dimanche":
			nbJourPrev = 6;
			break;
		}
		return nbJourPrev;
	}
	
	/**
	 * Outil de calcule du nombre de jour nécessaire pour compléter les jours après le dernier jour du mois
	 * dans le calendrier
	 * 
	 * @param firstDay {@link String} : Le dernier jour du mois formatté grâce au {@link DataTimeFormatter} "EEEE-dd-MM-yyyy"
	 * @return {@link Integer} Nombre de jour pour compléter la fin du calendrier
	 */ 
	public static int getNbNextJour(String lastDay) {
		String j = StringUtils.capitalize(lastDay.split("\\-")[0]);

		int nbJourNext = 0;
		switch (j) {
		case "Lundi":
			nbJourNext = 6;
			break;
		case "Mardi":
			nbJourNext = 5;
			break;
		case "Mercredi":
			nbJourNext = 4;
			break;
		case "Jeudi":
			nbJourNext = 3;
			break;
		case "Vendredi":
			nbJourNext = 2;
			break;
		case "Samedi":
			nbJourNext = 1;
			break;
		}
		return nbJourNext;
	}

	/**
	 * Permet d'avoir une {@link List}<{@link LocalDate}> correspondant au mois complet de l'année placés en paramètre
	 * 
	 * @param year {@link Integer} : Correspond à l'année souhaitée
	 * @param month {@link Integer} : Valeur numérique du mois de l'année souhaitée
	 * @return {@link List}<{@link LocalDate}> : Liste de tous les jours du mois
	 */
	public static List<LocalDate> getFullMonthOf(int year, int month) {
		YearMonth curr = YearMonth.of(year, month);
		List<LocalDate> mois = new ArrayList<>();

		for (int i = 1; i < curr.lengthOfMonth() + 1; i++) {
			mois.add(curr.atDay(i));
		}
		return mois;
	}

	/**
	 * Dérivé de {@link getFullMonthOf} qui permet de spécifier des bornes à récupérer du mois
	 * 
	 * @param year {@link Integer} : Correspond à l'année souhaitée
	 * @param month {@link Integer} : Valeur numérique du mois de l'année souhaitée
	 * @param deb {@link Integer} : Borne de début
	 * @param fin {@link Integer} : Born de fin
	 * @return {@link List}<{@link LocalDate}> : Correspondant à l'intervale du mois
	 */
	public static List<LocalDate> getPartialMonthOf(int year, int month, int deb, int fin) {
		YearMonth curr = YearMonth.of(year, month);
		List<LocalDate> mois = new ArrayList<>();

		for (int i = deb; i < fin ; i++) {
			mois.add(curr.atDay(i));
		}
		return mois;
	}


	/**
	 * Fonction de formatage en {@link List}<{@link String}> d'un mois/année placé en paramètre
	 * La fonction fait appelle à {@link getFullMonthOf} et {@link getPartialMonthOf} pour avoir 
	 * la liste complète des jours d'un mois sur un Calendrier
	 * 
	 * @param year {@link Integer} : Correspond à l'année souhaitée
	 * @param month {@link Integer} : Valeur numérique du mois de l'année souhaitée
	 * @return {@link List}<{@link String}> : Liste formatée des jours du mois
	 */
	public static List<String> getFullMonthOfStr(int year, int month) {
		List<String> moisStr = new ArrayList<>();
		
		String firstDay = getFirstDayOf(year, month);
		int nbJourPrev = getNbPrevJour(firstDay);
		
		String lastDay = getLastDayOf(year, month);
		int nbJourNext = getNbNextJour(lastDay);
		
		YearMonth prev = getPrevYearMonth(YearMonth.of(year, month));
		YearMonth next = getNextYearMonth(YearMonth.of(year, month));
		
		List<LocalDate> moisPrev = getPartialMonthOf(prev.getYear(),prev.getMonthValue(),prev.lengthOfMonth()-nbJourPrev+1, prev.lengthOfMonth()+1);

		List<LocalDate> mois = getFullMonthOf(year, month);
		
		List<LocalDate> moisNext =  getPartialMonthOf(next.getYear(),next.getMonthValue(), 1, nbJourNext+1);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE-dd-MM-yyyy");

		moisPrev.stream().forEach(x -> moisStr.add(x.format(dtf)));
		mois.stream().forEach(x -> moisStr.add(x.format(dtf)));
		moisNext.stream().forEach(x -> moisStr.add(x.format(dtf)));
		List<String> mStr = new ArrayList<>();
		moisStr.stream().forEach(x -> mStr.add(StringUtils.capitalize(x)));
		
		return mStr;
	}
	
	/**
	 * Construction de {@link String} à localiser pour la France en fonction d'un 
	 * {@link Month} placé en paramètre
	 * @param m {@link Month} : mois à localiser en Français.
	 * @return {@link String} : mois en construit depuis l'objet en paramètre
	 */
	public static String localizeMonth(Month m) {
		int month = m.getValue();
		String str = "";
		switch(month){
		case 1:
			str = "Janvier";
			break;
		case 2:
			str = "Février";
			break;
		case 3:
			str = "Mars";
			break;
		case 4:
			str = "Avril";
			break;
		case 5:
			str = "Mai";
			break;
		case 6:
			str = "Juin";
			break;
		case 7:
			str = "Juillet";
			break;
		case 8:
			str = "Août";
			break;
		case 9:
			str = "Septembre";
			break;
		case 10:
			str = "Octobre";
			break;
		case 11:
			str = "Novembre";
			break;
		case 12:
			str = "Décembre";
			break;
		}
		
		return str;
	}
}
