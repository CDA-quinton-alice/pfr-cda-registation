package fr.afpa.projetregistation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.UserTestEntity;

@Repository
public interface IUserTestDao extends CrudRepository<UserTestEntity , Integer> {

}
