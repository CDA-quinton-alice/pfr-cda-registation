package fr.afpa.projetregistation.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.afpa.projetregistation.entity.EvenementEntity;

/**
 * Dao d'accès en base de donnée aux objets de type @see EvenementEntity
 * 
 * @author Samuel
 *
 */
@Repository
public interface IEvenementDao extends PagingAndSortingRepository<EvenementEntity, Integer>{

	@Query(value="SELECT e FROM evenement e WHERE date_debut >= :date1 and date_fin <= :date2")
	public  List<EvenementEntity> findByDate(@Param("date1") Date dateDebut, @Param("date2") Date dateFin);

	@Query(value="SELECT e FROM evenement e WHERE date_debut >= :date1") 
	public  List<EvenementEntity> findByDate(@Param("date1") Date dateDebut);
	
	public List<EvenementEntity> findByType(String type);
}
