package fr.afpa.projetregistation.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

@SpringBootTest
public class UtilisateurServiceImplTest {

	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	IUtilisateurDao utilisateurDao;

	public Date dateTest;

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

		assertEquals(userTest.getAdresse().getNumero(), 1);
		assertEquals(userTest.getAdresse().getRue(), "rue test");
		assertEquals(userTest.getAdresse().getComplement(), "complément test");
		assertEquals(userTest.getAdresse().getCodePostal(), "59000");
		assertEquals(userTest.getAdresse().getVille(), "LILLE");
		assertEquals(userTest.getAdresse().getPays(), "France");

		utilisateurService.deleteUtilisateurByMatricule("MAT001");
	}

}
