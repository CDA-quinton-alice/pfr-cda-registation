package fr.afpa.projetregistation.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
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

import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.entity.MaterielEntity;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.utils.Constantes;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
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
	private MaterielDto mat3 = new MaterielDto("Mars", "Cafe3000", 200, "allée 1", 1, date, "MACHINE A CAFE");

	@Test
	@Order(1)
	/**
	 * Teste le bon ajout d'un MaterielDto par le MaterielServiceImpl
	 *
	 * @throws Exception
	 */
	public void testAddMateriel() throws Exception {

		mat3 = matService.create(mat3);

		assertNotNull(mat3);
		assertEquals("Mars", mat3.getMarque());
		assertEquals("Cafe3000", mat3.getModele());
		assertEquals(200, mat3.getPrix());
		assertEquals("allée 1", mat3.getLocalisation());
		assertEquals(1, mat3.getEtat());
		assertEquals(date, date);
		assertEquals("MACHINE A CAFE", mat3.getTypeMateriel());

	}

	/**
	 * Teste la bonne récupération de tous les MaterielDto par le
	 * MaterielServiceImpl
	 *
	 * @throws Exception
	 */
	@Test
	@Order(2)
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
	 * Teste la bonne récupération de tous les MaterielDto par le
	 * MaterielServiceImpl
	 *
	 * @throws Exception
	 */
	@Test
	@Order(3)
	public void testGetAllByType() throws Exception {

		List<MaterielDto> listeMat = matService.getAllByType(2, "CUVE");
		assertNotNull(listeMat);

		for (MaterielDto materielDto : listeMat) {
			assertEquals("CUVE", materielDto.getTypeMateriel());
		}

	}

	/**
	 * Teste la bonne récupération d'un MaterielDto par le MaterielServiceImpl via
	 * la ref.
	 *
	 * @throws Exception
	 */
	@Test
	@Order(4)
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
	@Order(5)
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
	@Order(6)
	public void testUpdateEtatById() throws Exception {

		matService.updateEtatById(6, 3);
		MaterielDto matDto = matService.getMaterielById(6);

		assertNotNull(matDto);
		assertEquals("Orion", matDto.getMarque());
		assertEquals("PistoXC", matDto.getModele());
		assertEquals(500, matDto.getPrix());
		assertEquals("pompe2", matDto.getLocalisation());
		assertEquals(3, matDto.getEtat());
		assertEquals(date, date);
		assertEquals("POMPE", matDto.getTypeMateriel());

	}

	@Test
	@Order(7)
	public void testDeleteById() throws Exception {

		matService.deleteById(18);
		Optional<MaterielEntity> opRes = materielDao.findByRef(18);
		MaterielEntity matEntity = null;
		if (opRes.isPresent()) {
			matEntity = opRes.get();
		}
		assertNull(matEntity);
	}

//	@Test
//	@Order(8)
//	public void testDeleteAllByType() throws Exception {
//
//		matService.deleteAllByType(2, "MACHINE A CAFE");
//		List<MaterielDto> liste = matService.getAllByType(2, "MACHINE A CAFE");
//		assertNotNull(liste);
//
//		for (MaterielDto materielDto : liste) {
//			assertEquals("MACHINE A CAFE", materielDto.getTypeMateriel());
//		}
//
//	}
}
