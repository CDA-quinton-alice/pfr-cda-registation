package fr.afpa.projetregistation.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import fr.afpa.projetregistation.dao.IAdresseDao;
import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.entity.UtilisateurEntity;
import fr.afpa.projetregistation.service.IUtilisateurService;
import fr.afpa.projetregistation.utils.Constantes;

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
	ModelMapper modelMapper;

	UtilisateurDto employe = new UtilisateurDto("EMPTEST001", "pwd1", "nom1", "prenom1", dateNaissance(), 2000.0,
			"mat@gmail.com", "06.06.06.06.06", false, 1, "rue test1", "complément test", "38000", "GRENOBLE", "France");

	UtilisateurDto responsable = new UtilisateurDto("RESPTEST001", "pwd2", "nom2", "prenom2", dateNaissance(), 2000.0,
			"mat@gmail.com", "06.06.06.06.06", true, 2, "rue test2", "complément test", "69000", "LYON", "France");

	/**
	 * Permet de tester si l'utilisateur récuépéré par son nom (String) correspond
	 * bien au bon Utilisateur
	 * 
	 * @return Optional UtilisateurEntity récupéré grâce au nom placé en paramètre
	 */
	@Test
	@Order(1)
	void findByNomTest() {
		// Création de 2 Utilisateurs
		utilisateurService.create(employe);
		utilisateurService.create(responsable);

		Optional<UtilisateurEntity> employeRecup = utilisateurDao.findByNom("nom1");
		assertTrue(employeRecup.isPresent());
		assertEquals("prenom1", employeRecup.get().getPrenom());

		Optional<UtilisateurEntity> responsableRecup = utilisateurDao.findByNom("nom2");
		assertTrue(responsableRecup.isPresent());
		assertEquals("prenom2", responsableRecup.get().getPrenom());
	}

	/**
	 * Permet de retourner une liste de tous les emlpoyés (boolean responsable =
	 * false) Utilisation d'une requête native custom pour ne récupérer que les
	 * employés.
	 * Utilisation de la pagination
	 * 
	 * @param RequestPage page
	 * 
	 * @return SubList de UtilisateurEntity qui sont des employés
	 */
	@Test
	@Order(2)
	void findAllEmployesTest() {
		PageRequest page = PageRequest.of(1 - 1, Constantes.ELEMENTS_PAR_PAGE);
		Page<UtilisateurEntity> subListeEmployes = utilisateurDao.findAllEmployes(page);
		assertNotNull(subListeEmployes);
		assertNotEquals(0, subListeEmployes.getNumberOfElements());

		List<UtilisateurEntity> listeEmployes = subListeEmployes.getContent();
		assertNotEquals(0, listeEmployes.size());
		assertEquals(false, listeEmployes.get(0).isResponsable());
	}

	/**
	 * Permet de retourner une liste de tous les responsables (boolean responsable =
	 * true) Utilisation d'une requête native custom pour récupérer que les
	 * responsables Utilisation de la pagination
	 * 
	 * @return List de UtilisateurEntity qui sont des responsables
	 */
//	@Query(nativeQuery = true, value = "SELECT * FROM utilisateur WHERE responsable = 1")

	@Test
	@Order(3)
	void findAllResponsablesTest() {
		PageRequest page = PageRequest.of(1 - 1, Constantes.ELEMENTS_PAR_PAGE);
		Page<UtilisateurEntity> subListeResponsables = utilisateurDao.findAllResponsables(page);
		assertNotNull(subListeResponsables);
		assertNotEquals(0, subListeResponsables.getNumberOfElements());

		List<UtilisateurEntity> listeResponsables = subListeResponsables.getContent();
		assertNotEquals(0, listeResponsables.size());
		assertEquals(true, listeResponsables.get(0).isResponsable());
	}

	
	/**
	 * Suppression des UtilisateursDto utilisés pour les tests
	 */
	@Test
	@Order(4)
	void goodbye() {
		Optional<UtilisateurEntity> employeRecup = utilisateurDao.findById("EMPTEST001");
		Optional<UtilisateurEntity> responsableRecup = utilisateurDao.findById("RESPTEST001");
		utilisateurDao.delete(employeRecup.get());
		utilisateurDao.delete(responsableRecup.get());

		//Les adresses crées ne sont pas supprimées en bdd pour le moment
		
	}

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
