package fr.afpa.projetregistation.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.UtilisateurEntity;

@Repository
public interface IUtilisateurDao extends PagingAndSortingRepository<UtilisateurEntity, String> {

	
	Optional<UtilisateurEntity> findByNom(String pNom);

}
