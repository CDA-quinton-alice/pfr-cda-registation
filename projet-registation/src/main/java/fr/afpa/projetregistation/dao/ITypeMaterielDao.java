package fr.afpa.projetregistation.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.TypeMaterielEntity;

@Repository
public interface ITypeMaterielDao extends CrudRepository<TypeMaterielEntity, Integer> {

	Optional<TypeMaterielEntity> findByLibelleMateriel(String upperCase);

}
