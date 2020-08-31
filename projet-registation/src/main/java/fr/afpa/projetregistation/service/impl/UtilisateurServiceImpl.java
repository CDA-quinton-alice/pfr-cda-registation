package fr.afpa.projetregistation.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dao.IAdresseDao;
import fr.afpa.projetregistation.dao.IConnexionDao;
import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.entity.AdresseEntity;
import fr.afpa.projetregistation.entity.ConnexionEntity;
import fr.afpa.projetregistation.entity.UtilisateurEntity;
import fr.afpa.projetregistation.service.IUtilisateurService;
import fr.afpa.projetregistation.utils.Securite;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe qui implémente l'interface IUtilisateurService et permet de définir le
 * métier, les méthodes de l'utilisateur
 * 
 * @author Mathieu
 * @version 1.0
 */

@Slf4j
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	/**
	 * Instanciation de l'interface IAdresseDao
	 */
	@Autowired
	IAdresseDao adresseDao;

	/**
	 * Instanciation de l'interface IConnexion
	 */
	@Autowired
	IConnexionDao connexionDao;

	/**
	 * Instanciation de l'interface IUtilisateurDao
	 */
	@Autowired
	IUtilisateurDao utilisateurDao;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Crée un UtilisateurDto et sauvegarde un utilisateur en BDD en utilisant
	 * l'UtilisateurDao.
	 * 
	 * @see
	 * @param UtilisateurDao
	 * @return UtilisateurDao
	 */

	@Override
	public UtilisateurDto create(UtilisateurDto pUtilisateur) {
		UtilisateurEntity utilisateur = new UtilisateurEntity();
		String matricule = pUtilisateur.getMatricule();
		String password = pUtilisateur.getPassword();

		Optional<ConnexionEntity> optiConnexion = connexionDao.findByMatricule(matricule);
		if (optiConnexion.isPresent()) {
			log.warn("Ajout UTILISATEUR impossible - le matricule existe déjà");
			return null;
		} else {
			ConnexionEntity coupleConnexion = new ConnexionEntity(matricule, Securite.hashMD5(password));
			connexionDao.save(coupleConnexion);

			AdresseEntity adresse = AdresseEntity.builder().numero(pUtilisateur.getNumero()).rue(pUtilisateur.getRue())
					.complement(pUtilisateur.getComplement()).codePostal(pUtilisateur.getCodePostal())
					.ville(pUtilisateur.getVille()).pays(pUtilisateur.getPays()).build();
			adresseDao.save(adresse);

			utilisateur = UtilisateurEntity.builder().matricule(matricule).prenom(pUtilisateur.getPrenom())
					.nom(pUtilisateur.getNom()).dateDeNaissance(pUtilisateur.getDateDeNaissance())
					.salaire(pUtilisateur.getSalaire()).mail(pUtilisateur.getMail()).tel(pUtilisateur.getTel())
					.responsable(pUtilisateur.isResponsable()).connexion(coupleConnexion).adresse(adresse).build();
			utilisateurDao.save(utilisateur);
			log.info("UTILISATEUR ajouté avec succès");
			return pUtilisateur;
		}

	}

	/**
	 * Supprime un Utilisateur récupéré de la BDD en utilisant le matricule (unique)
	 * de l'utilisateur à supprimer.
	 * 
	 * Utilisation de l'Optional, test d'abord si l'utilisateur est bien présent en
	 * BDD.
	 * 
	 * @see
	 * @param pMatricule String utilisé pour récupérer l'utilisateur
	 * 
	 */
	@Override
	public void deleteUtilisateurByMatricule(String pMatricule) {
		Optional<UtilisateurEntity> optiUtilisateur = utilisateurDao.findById(pMatricule);
		if (!optiUtilisateur.isPresent()) {
			log.warn("UTILISATEUR delete - impossible de supprimer une personne qui n'existe pas !");
		} else {
			utilisateurDao.deleteById(pMatricule);
		}
	}

	@Override
	public UtilisateurDto updateUtilisateur(UtilisateurDto pUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UtilisateurDto getUtilisateurByMatricule(String pMatricule) {
		Optional<UtilisateurEntity> optiUtilisateur = utilisateurDao.findById(pMatricule);
		UtilisateurDto userDto = null;
		if (!optiUtilisateur.isPresent()) {
			log.info("UTILISATEUR findByMatricule - Cette personne n'existe pas");
		} else {
			UtilisateurEntity utilisateur = optiUtilisateur.get();
			userDto = modelMapper.map(utilisateur, UtilisateurDto.class);
			log.info("UTILISATEUR findByMatricule - Utilisateur récup --> "+userDto);
		}
		return userDto;
	}

	@Override
	public UtilisateurDto getUtilisateurByName(String pNom) {
		Optional<UtilisateurEntity> optiUtilisateur = utilisateurDao.findByNom(pNom);
		UtilisateurDto userDto = null;
		if (!optiUtilisateur.isPresent()) {
			log.info("UTILISATEUR findByMatricule - Cette personne n'existe pas");
		} else {
			UtilisateurEntity utilisateur = optiUtilisateur.get();
			userDto = modelMapper.map(utilisateur, UtilisateurDto.class);
			log.info("UTILISATEUR findByMatricule - Utilisateur récup --> "+userDto);
		}
		return userDto;
	}

	@Override
	public List<UtilisateurDto> getAllUtilisateurs() {
		// TODO Auto-generated method stub
		return null;
	}

}
