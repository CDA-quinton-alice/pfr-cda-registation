package fr.afpa.projetregistation.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dto permettant la transmission des évènements
 * 
 * @author Samuel
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvenementDto {
	
	private int id;
	private String type;
	private String description;
	private Date date_debut;
	private Date date_fin;
	private int duree;
//	private int idUtilisateur;
}
