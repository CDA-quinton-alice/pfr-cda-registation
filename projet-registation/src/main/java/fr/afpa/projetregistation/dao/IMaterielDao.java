package fr.afpa.projetregistation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.MaterielEntity;

@Repository
public interface IMaterielDao extends PagingAndSortingRepository<MaterielEntity, Integer> {

	@Override
	List<MaterielEntity> findAll();

	Optional<MaterielEntity> findByRef(String pRef);

	@Query(value = "SELECT ref FROM materiel order by matricule desc LIMIT 1", nativeQuery = true)
	public int getMaxIdMat();

}
