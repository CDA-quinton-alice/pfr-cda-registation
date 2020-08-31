package fr.afpa.projetregistation.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.entity.MaterielEntity;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.utils.Constantes;

@SpringBootTest
public class TestMaterielServiceImpl {

	@Autowired
	private IMaterielService matService;

	@Autowired
	ModelMapper modelMapper;

	private Date date = new Date();

	private MaterielDto materiel = new MaterielDto("Orion", "PistoXC", 500, "pompe2", 1, date, "POMPE");

	@Test
	@Order(1)
	/**
	 * Teste le bon ajout d'un MaterielDto par le MaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	public void testAddMateriel() throws Exception {

		assertNotNull(materiel);
		assertEquals("Orion", materiel.getMarque());
		assertEquals("PistoXC", materiel.getModele());
		assertEquals(500, materiel.getPrix());
		assertEquals("pompe2", materiel.getLocalisation());
		assertEquals(1, materiel.getEtat());
		assertEquals(date, date);
		assertEquals("POMPE", materiel.getTypeMateriel());

	}

	/**
	 * Teste la bonne récupération de tous les MaterielDto par le
	 * MaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	@Test
	@Order(3)
	public void testGetAll() throws Exception {

		List<MaterielDto> listeMat = matService.getAll(Constantes.ELEMENTS_PAGE);
		assertNotNull(listeMat);

		List<MaterielDto> liste2 = new ArrayList<MaterielDto>();
		for (int i = 0; i < 3; i++) {
			MaterielEntity mat = new MaterielEntity();
			liste2.add(this.modelMapper.map(mat, MaterielDto.class));
		}

		assertNotNull(liste2);

	}
}
