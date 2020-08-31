package fr.afpa.projetregistation.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dao.IConnexionDao;
import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.entity.ConnexionEntity;
import fr.afpa.projetregistation.entity.UtilisateurEntity;
import fr.afpa.projetregistation.service.IUtilisateurService;
import fr.afpa.projetregistation.utils.Securite;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	IConnexionDao connexionDao;
	
	@Autowired
	IUtilisateurDao utilisateurDao;
	
	@Override
	public UtilisateurDto create(UtilisateurDto pUtilisateur) {
		UtilisateurEntity utilisateur = new UtilisateurEntity();
		String matricule = pUtilisateur.getMatricule();
		String password = pUtilisateur.getPassword();
		
		Optional<ConnexionEntity> optiConnexion = connexionDao.findByMatricule(matricule);
		if (optiConnexion.isPresent()) {
			log.warn("Le matricule existe déjà");
			return null;
		}else {
			ConnexionEntity coupleConnexion = new ConnexionEntity(matricule , Securite.hashMD5(password));
			connexionDao.save(coupleConnexion);
			
			utilisateur = UtilisateurEntity.builder()
					.matricule(matricule)
					.prenom(pUtilisateur.getPrenom())
					.nom(pUtilisateur.getNom())
					.dateDeNaissance(pUtilisateur.getDateDeNaissance())
					.salaire(pUtilisateur.getSalaire())
					.mail(pUtilisateur.getMail())
					.tel(pUtilisateur.getTel())
					.responsable(pUtilisateur.isResponsable())
					.connexion(coupleConnexion)
					.build();
			utilisateurDao.save(utilisateur);
			return pUtilisateur;
		}
		
		
		
		
	
	}

}
