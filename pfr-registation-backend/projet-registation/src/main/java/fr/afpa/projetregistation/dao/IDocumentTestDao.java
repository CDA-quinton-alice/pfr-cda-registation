package fr.afpa.projetregistation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.DocumentTestEntity;

@Repository
public interface IDocumentTestDao extends CrudRepository<DocumentTestEntity, Integer> {

}
