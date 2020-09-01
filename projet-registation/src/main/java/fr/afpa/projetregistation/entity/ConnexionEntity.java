package fr.afpa.projetregistation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConnexionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConnexion;
	private String matricule;
	private String password;

	public ConnexionEntity(String matricule, String password) {
		super();
		this.matricule = matricule;
		this.password = password;
	}

}
