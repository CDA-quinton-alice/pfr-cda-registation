package fr.afpa.projetregistation.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import fr.afpa.projetregistation.entity.UtilisateurEntity;

public interface IUtilisateurDao extends PagingAndSortingRepository<UtilisateurEntity, String> {

}
