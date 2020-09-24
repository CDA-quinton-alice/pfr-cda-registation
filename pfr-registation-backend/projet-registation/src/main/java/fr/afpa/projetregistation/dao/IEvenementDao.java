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

	/**
	 * Récupère de la base de donnée une @see List de @see EvenementEntity
	 * qui correspond à l'intervale entre les 2 dates placés en paramètre
	 * 
	 * @param dateDebut
	 * @param dateFin
	 * @return une @see List de @see EvenementEntity
	 */
	@Query(value="select * from (select * from evenement where date_fin >= :date1) a where a.date_debut<=:date2 and a.matricule = :userMat",nativeQuery = true)
	public  List<EvenementEntity> findByDate(@Param("date1") Date dateDebut, @Param("date2") Date dateFin, @Param("userMat") String userMatricule);

	
	/**
	 * Récupère de la base de donnée une @see List de @see EvenementEntity
	 * qui commence à partir de la date placé en paramètre
	 * @param dateDebut
	 * @return une @see List de @see EvenementEntity
	 */
	@Query(value="SELECT e FROM evenement e WHERE date_debut >= :date1") 
	public  List<EvenementEntity> findByDate(@Param("date1") Date dateDebut);
	
	/**
	 * Récupère de la base de donnée une @see(List) de @see(EvenementEntity)
	 * dont le type est égale à celui placé en paramètre 
	 * @param type
	 * @return une @see(List) de @see(EvenementEntity)
	 */
	public List<EvenementEntity> findByType(@Param("type2") String type);
	
}
