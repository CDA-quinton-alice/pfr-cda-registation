package fr.afpa.projetregistation.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.DocumentEntity;

@Repository
public interface IDocumentDao extends PagingAndSortingRepository<DocumentEntity, Integer> {

//@Query("SELECT ch.matricule FROM Utilisateur ch order by matricule desc limit 1")

//public int getMaxId();

}
