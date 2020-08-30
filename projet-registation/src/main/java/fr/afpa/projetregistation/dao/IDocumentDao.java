package fr.afpa.projetregistation.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.DocumentEntity;

@Repository
public interface IDocumentDao extends PagingAndSortingRepository<DocumentEntity, Integer> {

@Query("SELECT coalesce(max(ch.id), 0) FROM Utilisateur ch")

public Long getMaxId();






}
