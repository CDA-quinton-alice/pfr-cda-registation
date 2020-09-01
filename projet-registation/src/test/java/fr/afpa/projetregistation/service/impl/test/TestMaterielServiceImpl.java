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

import fr.afpa.projetregistation.dao.IMaterielDao;
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

	@Autowired
	IMaterielDao materielDao;

	private Date date = new Date();

	private MaterielDto mat = new MaterielDto("Orion", "PistoXC", 500, "pompe2", 1, date, "POMPE");
	private MaterielDto mat2 = new MaterielDto("Venus", "PistoXC", 500, "pompe2", 3, date, "POMPE");

	@Test
	@Order(1)
	/**
	 * Teste le bon ajout d'un MaterielDto par le MaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	public void testAddMateriel() throws Exception {

		mat = matService.create(mat);

		assertNotNull(mat);
		assertEquals("Orion", mat.getMarque());
		assertEquals("PistoXC", mat.getModele());
		assertEquals(500, mat.getPrix());
		assertEquals("pompe2", mat.getLocalisation());
		assertEquals(1, mat.getEtat());
		assertEquals(date, date);
		assertEquals("POMPE", mat.getTypeMateriel());

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

	/**
	 * Teste la bonne récupération d'un MaterielDto par le MaterielServiceImpl via
	 * la ref.
	 * 
	 * @throws Exception
	 */
	@Test
	@Order(3)
	public void testGetMaterielById() throws Exception {

		MaterielDto materiel = matService.getMaterielById(1);

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
	 * Teste la bonne mise à jour d'information d'un matériel.
	 * 
	 * @throws Exception
	 */
	@Test
	@Order(4)
	public void testUpdateById() throws Exception {

		matService.updateById(2, mat2);
		MaterielDto matDto = matService.getMaterielById(2);

		assertNotNull(matDto);
		assertEquals("Venus", matDto.getMarque());
		assertEquals("PistoXC", matDto.getModele());
		assertEquals(500, matDto.getPrix());
		assertEquals("pompe2", matDto.getLocalisation());
		assertEquals(3, matDto.getEtat());
		assertEquals(date, date);

	}

	/**
	 * Teste la bonne mise à jour de l'état d'un matériel.
	 * 
	 * @throws Exception
	 */
	@Test
	@Order(4)
	public void testUpdateEtatById() throws Exception {

		matService.updateEtatById(5, 3);
		MaterielDto matDto = matService.getMaterielById(5);

		assertNotNull(matDto);
		assertEquals("Orion", matDto.getMarque());
		assertEquals("PistoXC", matDto.getModele());
		assertEquals(500, matDto.getPrix());
		assertEquals("pompe2", matDto.getLocalisation());
		assertEquals(3, matDto.getEtat());
		assertEquals(date, date);
		assertEquals("POMPE", matDto.getTypeMateriel());

	}
}
