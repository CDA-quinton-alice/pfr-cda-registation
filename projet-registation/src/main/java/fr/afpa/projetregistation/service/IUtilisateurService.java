package fr.afpa.projetregistation.service;

import java.util.List;

import fr.afpa.projetregistation.dto.UtilisateurDto;

public interface IUtilisateurService {

	UtilisateurDto create(UtilisateurDto pUtilisateur);

	UtilisateurDto updateUtilisateur(UtilisateurDto pUtilisateur);

	UtilisateurDto getUtilisateurByMatricule(String pMatricule);

	UtilisateurDto getUtilisateurByName(String pNom);

	List<UtilisateurDto> getAllUtilisateurs();

	public void deleteUtilisateurByMatricule(String pMatricule);

}
