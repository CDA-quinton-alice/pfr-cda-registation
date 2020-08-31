package fr.afpa.test.ervice.impl;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.dto.TypeMaterielDto;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.service.ITypeMaterielService;
import fr.afpa.projetregistation.utils.Constantes;

@SpringBootTest
public class TestMaterielServiceImpl {

	@Autowired
	private IMaterielService matService;

	@Autowired
	private IMaterielDao matDao;

	@Autowired
	private ITypeMaterielService typeService;

	@Test
	public void testAddMateriel() throws Exception {
		TypeMaterielDto typeDto = new TypeMaterielDto();
		typeDto.setLibelleMateriel(Constantes.STRING_TEST);
		Date date = new Date();
		MaterielDto materiel = new MaterielDto(Constantes.STRING_TEST, Constantes.STRING_TEST, Constantes.INTEGER_TEST,
				Constantes.STRING_TEST, Constantes.INTEGER_TEST, date, Constantes.STRING_TEST);

		materiel = matService.create(materiel);

		assertNotNull(materiel);
		assertEquals(Constantes.STRING_TEST, materiel.getMarque());
		assertEquals(Constantes.STRING_TEST, materiel.getModele());
		assertEquals(Constantes.INTEGER_TEST, materiel.getPrix());
		assertEquals(Constantes.STRING_TEST, materiel.getLocalisation());
		assertEquals(Constantes.INTEGER_TEST, materiel.getEtat());
		assertEquals(date, date);
		assertEquals(Constantes.STRING_TEST, materiel.getTypeMateriel());

	}

	@Test
	@Order(2)
	public void testTypeMateriel() throws Exception {

		TypeMaterielDto type = new TypeMaterielDto(1, "POMPE");

		TypeMaterielDto type2 = typeService.getTypeById(2);

		assertNotNull(type);
		assertEquals(1, type.getId());
		assertNotEquals(type, type2);

	}

	@Test
	@Order(3)
	public void testGetAll() throws Exception {

		List<MaterielDto> listeMat = matService.getAll(Constantes.ELEMENTS_PAGE);
		assertNotNull(listeMat);

	}
}
