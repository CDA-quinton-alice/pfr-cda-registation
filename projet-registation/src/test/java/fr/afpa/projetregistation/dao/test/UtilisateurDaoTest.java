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

		
		//Création du dto pour faciliter la création
		UtilisateurDto employe = new UtilisateurDto("EMPTEST001", "pwd1", "nom1", "prenom1", dateTest, 2000.0,
				"mat@gmail.com", "06.06.06.06.06", false, 1, "rue test1", "complément test", "38000", "GRENOBLE",
				"France");

		UtilisateurDto responsable = new UtilisateurDto("RESPTEST001", "pwd2", "nom2", "prenom2", dateTest, 2000.0,
				"mat@gmail.com", "06.06.06.06.06", true, 2, "rue test2", "complément test", "69000", "LYON", "France");

		utilisateurService.create(employe);
		utilisateurService.create(responsable);
		
		Optional<UtilisateurEntity> employeEntity = utilisateurDao.findByNom("nom1");
		assertTrue(employeEntity.isPresent());
		assertEquals("prenom1" , employeEntity.get().getPrenom());
		
		Optional<UtilisateurEntity> responsableEntity = utilisateurDao.findByNom("nom2");
		assertTrue(responsableEntity.isPresent());
		assertEquals("prenom2" , responsableEntity.get().getPrenom());
		
		
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
