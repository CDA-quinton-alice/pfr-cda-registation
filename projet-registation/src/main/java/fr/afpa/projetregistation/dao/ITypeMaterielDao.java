package fr.afpa.projetregistation.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.projetregistation.entity.TypeMaterielEntity;

public interface ITypeMaterielDao extends CrudRepository<TypeMaterielEntity, Integer> {

	Optional<TypeMaterielEntity> findByLibelleMateriel(String upperCase);

}
