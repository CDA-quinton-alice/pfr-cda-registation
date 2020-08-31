package fr.afpa.projetregistation.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Il s'agit de la classe permettant d'avoir toutes les infos possible d'un évènement 
 * 
 * @author Samuel
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "evenement")
public class EvenementEntity {

	/**
	 * Identifiant unique d'un évènement
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Type d'évènement parmis les 4 possibles :
	 *  - Autre
	 *  - Panne
	 *  - Révision
	 *  - Inspection
	 */
	private String type;
	
	/**
	 * Description détaillé de l'évènement
	 */
	private String description;
	
	/**
	 * Date de debut de l'évènement
	 */
	private Date date_debut;
	
	/**
	 * Date de fin de l'évènement
	 */
	private Date date_fin;
	
	/**
	 * Durée de l'évènement exprimé en seconde
	 */
	private int duree;
	
//	@ManyToOne
//	@JoinColumn(name="ref")
//	private int refMateriel;
}
