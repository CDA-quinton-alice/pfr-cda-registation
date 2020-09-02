package fr.afpa.projetregistation.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.entity.UtilisateurEntity;
import fr.afpa.projetregistation.service.IUtilisateurService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UtilisateurDaoTest {

	@Autowired
	IUtilisateurService utilisateurService;
	
	@Autowired
	IUtilisateurDao utilisateurDao;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	/**
	 * Permet de tester si l'utilisateur récuépéré par son nom (String)
	 * correspond bien au bon Utilisateur
	 * 
	 * @return Optional UtilisateurEntity récupéré grâce au nom placé en paramètre
	 */
	@Test
	@Order(1)
	void findByNom() {
		
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date dateTest = null;
		try {
			dateTest = simpleDateFormat.parse("15-01-1989");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//Construction UtilisateurEntity simples pour les tests
		UtilisateurEntity employeEntity = UtilisateurEntity.builder()
				.matricule("EMPTEST001")
				.nom("nom1")
				.prenom("prenom1")
				.dateDeNaissance(dateTest)
				.salaire(2000.0)
				.mail("mat@gmail.com")
				.tel("06.06.06.06.06")
				.responsable(false)
				.build();
		
		UtilisateurEntity responsableEntity = UtilisateurEntity.builder()
				.matricule("RESPTEST001")
				.nom("nom2")
				.prenom("prenom2")
				.dateDeNaissance(dateTest)
				.salaire(2000.0)
				.mail("mat@gmail.com")
				.tel("06.06.06.06.06")
				.responsable(false)
				.build();
		
		utilisateurDao.save(employeEntity);
		utilisateurDao.save(responsableEntity);
		
		Optional<UtilisateurEntity> employeRecup = utilisateurDao.findByNom("nom1");
		assertTrue(employeRecup.isPresent());
		assertEquals("prenom1" , employeRecup.get().getPrenom());
		
		Optional<UtilisateurEntity> responsableRecup = utilisateurDao.findByNom("nom2");
		assertTrue(responsableRecup.isPresent());
		assertEquals("prenom2" , responsableRecup.get().getPrenom());
		
		utilisateurDao.delete(employeEntity);
		utilisateurDao.delete(responsableEntity);
	}

	/**
	 * Permet de retourner une liste de tous les emlpoyés 
	 * (boolean responsable = false)
	 * Utilisation d'une requête native custom pour récupérer que les employés
	 * Utilisation de la pagination
	 * @param page 
	 * 
	 * @return List de UtilisateurEntity qui sont des employés
	 */
//	@Query(nativeQuery = true, value = "SELECT * FROM utilisateur WHERE responsable = 0")
//	Page<UtilisateurEntity> findAllEmployes(PageRequest page);
	
	/**
	 * Permet de retourner une liste de tous les responsables 
	 * (boolean responsable = true)
	 * Utilisation d'une requête native custom pour récupérer que les responsables
	 * Utilisation de la pagination
	 * 
	 * @return List de UtilisateurEntity qui sont des responsables
	 */
//	@Query(nativeQuery = true, value = "SELECT * FROM utilisateur WHERE responsable = 1")
//	Page<UtilisateurEntity> findAllResponsables(PageRequest page);

}
