package fr.afpa.projetregistation.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.entity.UtilisateurEntity;
import fr.afpa.projetregistation.service.IUtilisateurService;
import fr.afpa.projetregistation.utils.Securite;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UtilisateurServiceImplTest {

	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	IUtilisateurDao utilisateurDao;

	public Date dateTest;

	/**
	 * Test la création de l'utilisateur, si bien associé à un couple connexion
	 * (matricule / password) Ainsi que la bonne adresse correspondante
	 */

	@Test
	void createUtilisateurTest() {
		UtilisateurDto utilisateur = new UtilisateurDto("MAT001", "pwd2", "nom", "prenom", dateTest, 2000.0,
				"mat@gmail.com", "06.06.06.06.06", false, 1, "rue test", "complément test", "59000", "LILLE", "France");

		utilisateurService.create(utilisateur);
		Optional<UtilisateurEntity> optiUtilisateur = utilisateurDao.findById("MAT001");
		UtilisateurEntity userTest = optiUtilisateur.get();
		assertNotNull(userTest);
		assertEquals(userTest.getPrenom(), "prenom");
		assertEquals(userTest.getNom(), "nom");
		assertEquals(userTest.getDateDeNaissance(), dateTest);
		assertEquals(userTest.getSalaire(), 2000.0);
		assertEquals(userTest.getMail(), "mat@gmail.com");
		assertEquals(userTest.getTel(), "06.06.06.06.06");

		assertEquals(userTest.getConnexion().getPassword(), Securite.hashMD5("pwd2"));

		assertEquals(userTest.getAdresse().getNumero(), 1);
		assertEquals(userTest.getAdresse().getRue(), "rue test");
		assertEquals(userTest.getAdresse().getComplement(), "complément test");
		assertEquals(userTest.getAdresse().getCodePostal(), "59000");
		assertEquals(userTest.getAdresse().getVille(), "LILLE");
		assertEquals(userTest.getAdresse().getPays(), "France");

		utilisateurService.deleteUtilisateurByMatricule("MAT001");
	}

	/**
	 * Test de la suppresion d'un Utilisateur préalablement créé via matricule
	 * Récupéré via optional et test de l'optional
	 */
	@Test
	void deleteUtilisateurByMatriculeTest() {

		UtilisateurDto utilisateur = new UtilisateurDto("MAT001", "pwd2", "nom", "prenom", dateTest, 2000.0,
				"mat@gmail.com", "06.06.06.06.06", false, 1, "rue test", "complément test", "59000", "LILLE", "France");

		utilisateurService.create(utilisateur);
		Optional<UtilisateurEntity> optiUtilisateur = utilisateurDao.findById("MAT001");
		UtilisateurEntity userTest = optiUtilisateur.get();
		assertNotNull(userTest);
		assertEquals(userTest.getPrenom(), "prenom");
		assertEquals(userTest.getNom(), "nom");
		assertEquals(userTest.getDateDeNaissance(), dateTest);
		assertEquals(userTest.getSalaire(), 2000.0);
		assertEquals(userTest.getMail(), "mat@gmail.com");
		assertEquals(userTest.getTel(), "06.06.06.06.06");

		assertEquals(userTest.getAdresse().getNumero(), 1);
		assertEquals(userTest.getAdresse().getRue(), "rue test");
		assertEquals(userTest.getAdresse().getComplement(), "complément test");
		assertEquals(userTest.getAdresse().getCodePostal(), "59000");
		assertEquals(userTest.getAdresse().getVille(), "LILLE");
		assertEquals(userTest.getAdresse().getPays(), "France");

		utilisateurService.deleteUtilisateurByMatricule("MAT001");

		Optional<UtilisateurEntity> optiUtilisateur2 = utilisateurDao.findById("MAT001");
		assertFalse(optiUtilisateur2.isPresent());

	}

	/**
	 * Test de le méthode getUtilisateurByMatricule pour récupérer un UtilisateurDto par son matricule préalablement créé
	 * Attention retour de la méthode UtilisateurDto
	 * 
	 * @param pMatricule String placé en paramètre pour récupérer l'Utilisateur
	 */
	
	@Test
	void getUtilisateurByMatriculeTest() {
		UtilisateurDto utilisateur = new UtilisateurDto("MAT001", "pwd2", "nom", "prenom", dateTest, 2000.0,
				"mat@gmail.com", "06.06.06.06.06", false, 1, "rue test", "complément test", "59000", "LILLE", "France");

		utilisateurService.create(utilisateur);

		UtilisateurDto userDto = utilisateurService.getUtilisateurByMatricule("MAT001");

		assertNotNull(userDto);
		assertEquals(userDto.getPrenom(), "prenom");
		assertEquals(userDto.getNom(), "nom");
		assertEquals(userDto.getDateDeNaissance(), dateTest);
		assertEquals(userDto.getSalaire(), 2000.0);
		assertEquals(userDto.getMail(), "mat@gmail.com");
		assertEquals(userDto.getTel(), "06.06.06.06.06");

		assertEquals(userDto.getPassword(), Securite.hashMD5("pwd2"));
		assertEquals(userDto.getNumero(), 1);
		assertEquals(userDto.getRue(), "rue test");
		assertEquals(userDto.getComplement(), "complément test");
		assertEquals(userDto.getCodePostal(), "59000");
		assertEquals(userDto.getVille(), "LILLE");
		assertEquals(userDto.getPays(), "France");

		utilisateurService.deleteUtilisateurByMatricule("MAT001");

	}

}
