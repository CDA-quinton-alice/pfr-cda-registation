package fr.afpa.projetregistation.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.PersonneEntity;

@Repository
public interface IPersonneDao extends CrudRepository<PersonneEntity, Integer> {
	List<PersonneEntity> findAll();
}
