package fr.afpa.projetregistation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonneDto {
	private int id;
	private String nom;
	private String prenom;
}
