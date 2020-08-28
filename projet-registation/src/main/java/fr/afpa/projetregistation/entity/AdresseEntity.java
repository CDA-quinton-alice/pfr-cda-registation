package fr.afpa.projetregistation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe permet de définir les attributs de l'adresse
 * 
 * @author Mathieu
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AdresseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdresse;
	private int numero;
	private String rue;
	private String complement;
	private int codePostal;
	private String ville;
	private String pays;

}