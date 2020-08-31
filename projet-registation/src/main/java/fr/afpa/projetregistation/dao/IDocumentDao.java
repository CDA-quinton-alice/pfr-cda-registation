package fr.afpa.projetregistation.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.DocumentEntity;

@Repository
public interface IDocumentDao extends PagingAndSortingRepository<DocumentEntity, Integer> {

@Query(value="SELECT ch.matricule FROM Utilisateur ch order by matricule desc LIMIT 1", nativeQuery=true)
public int getMaxId();





//public int getMaxId();

}
