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

import fr.afpa.projetregistation.dao.IAdresseDao;
import fr.afpa.projetregistation.dao.IConnexionDao;
import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.entity.AdresseEntity;
import fr.afpa.projetregistation.entity.ConnexionEntity;
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
	IAdresseDao adresseDao;

	@Autowired
	IConnexionDao connexionDao;

	@Autowired
	ModelMapper modelMapper;

	AdresseEntity adresseTest = AdresseEntity.builder().numero(445).rue("rue du chat").complement("complément")
			.codePostal("38000").ville("GRENOBLE").pays("FRANCE").build();
	
	ConnexionEntity connexionTest = ConnexionEntity.builder().matricule("EMPTEST001").password("pwd1").build();
	
	UtilisateurEntity employeEntity = UtilisateurEntity.builder().matricule("EMPTEST001").nom("nom1")
			.prenom("prenom1").dateDeNaissance(dateNaissance()).salaire(2000.0).mail("mat@gmail.com").tel("06.06.06.06.06")
			.responsable(false).connexion(connexionTest).adresse(adresseTest).build();
	
	/**
	 * Initialisation d'un UtilisateurEntity pour les tests
	 */
	@Test
	@Order(1)
	void Ini() {
		adresseDao.save(adresseTest);
		connexionDao.save(connexionTest);
		utilisateurDao.save(employeEntity);
	}

	@Autowired
	/**
	 * Permet de tester si l'utilisateur récuépéré par son nom (String) correspond
	 * bien au bon Utilisateur
	 * 
	 * @return Optional UtilisateurEntity récupéré grâce au nom placé en paramètre
	 */
	@Test
	@Order(2)
	void findByNomTest() {
		Optional<UtilisateurEntity> employeRecup = utilisateurDao.findByNom("nom1");
		assertTrue(employeRecup.isPresent());
		assertEquals("prenom1", employeRecup.get().getPrenom());
	}

	/**
	 * Suppression de l'UtilisateurEntity, Adresse et Connexion de la bdd
	 */
	@Test
	@Order(3)
	void bye() {
		utilisateurDao.delete(employeEntity);
		adresseDao.delete(adresseTest);
		connexionDao.delete(connexionTest);
	}
	/**
	 * Permet de retourner une liste de tous les emlpoyés (boolean responsable =
	 * false) Utilisation d'une requête native custom pour récupérer que les
	 * employés Utilisation de la pagination
	 * 
	 * @param page
	 * 
	 * @return List de UtilisateurEntity qui sont des employés
	 */
//	@Query(nativeQuery = true, value = "SELECT * FROM utilisateur WHERE responsable = 0")
//	Page<UtilisateurEntity> findAllEmployes(PageRequest page);

	/**
	 * Permet de retourner une liste de tous les responsables (boolean responsable =
	 * true) Utilisation d'une requête native custom pour récupérer que les
	 * responsables Utilisation de la pagination
	 * 
	 * @return List de UtilisateurEntity qui sont des responsables
	 */
//	@Query(nativeQuery = true, value = "SELECT * FROM utilisateur WHERE responsable = 1")
//	Page<UtilisateurEntity> findAllResponsables(PageRequest page);

	public Date dateNaissance() {
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date dateTest = null;
		try {
			dateTest = simpleDateFormat.parse("15-01-1989");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTest;
	}
	
}
