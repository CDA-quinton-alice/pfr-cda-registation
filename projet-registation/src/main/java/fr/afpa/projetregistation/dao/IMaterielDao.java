package fr.afpa.projetregistation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.MaterielEntity;

@Repository
public interface IMaterielDao extends PagingAndSortingRepository<MaterielEntity, String> {
	@Override
	List<MaterielEntity> findAll();

	Optional<MaterielEntity> findByRef(int pRef);

}
