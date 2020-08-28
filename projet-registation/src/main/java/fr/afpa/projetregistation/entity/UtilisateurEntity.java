package fr.afpa.projetregistation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Cette classe permet de définir les attributs de l'utilisateur
 * 
 * @author Mathieu
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UtilisateurEntity {

	@Id
	@Column(name = "matricule")
	private String matricule;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private double salaire;
	private String mail;
	private String tel;
	private ConnexionEntity connexion;
	private AdresseEntity adresse;

}
