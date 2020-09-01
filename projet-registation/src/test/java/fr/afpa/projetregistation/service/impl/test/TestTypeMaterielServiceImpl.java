package fr.afpa.projetregistation.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.dto.TypeMaterielDto;
import fr.afpa.projetregistation.service.ITypeMaterielService;
import fr.afpa.projetregistation.utils.Constantes;

@SpringBootTest
public class TestTypeMaterielServiceImpl {
	@Autowired
	private ITypeMaterielService typeService;

	private TypeMaterielDto type = new TypeMaterielDto(1, "POMPE");

	@Test
	@Order(1)
	/**
	 * Test le bon ajout d'un TypeMaterielDto par le TypeMaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	public void testAddTypeMateriel() throws Exception {

		typeService.addType(type);
		assertNotNull(type);

		assertEquals(1, type.getId());
		assertEquals("POMPE", type.getLibelleMateriel());

	}

	@Test
	@Order(2)
	/**
	 * Test la bonne récupération via l'id d'un TypeMaterielDto par le
	 * TypeMaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	public void testGetTypeId() throws Exception {

		TypeMaterielDto testType = typeService.getTypeById(1);
		assertNotNull(testType);

		assertEquals(1, testType.getId());
		assertEquals("POMPE", testType.getLibelleMateriel());
		assertNotEquals("Cuve", testType.getLibelleMateriel());
		assertNotEquals(2, testType.getId());

	}

	@Test
	@Order(3)
	/**
	 * Test la bonne récupération via le libelle d'un TypeMaterielDto par le
	 * TypeMaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	public void testGetTypeByLibelle() throws Exception {

		TypeMaterielDto testType = typeService.getTypeByLibelle("POMPE");
		assertNotNull(testType);

		assertEquals(1, testType.getId());
		assertEquals("POMPE", testType.getLibelleMateriel());
		assertNotEquals("Cuve", testType.getLibelleMateriel());
		assertNotEquals(2, testType.getId());

	}

	@Test
	@Order(4)
	/**
	 * Test la bonne récupération via un MaterielDto d'un TypeMaterielDto par le
	 * TypeMaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	public void testGetTypeByMateriel() throws Exception {
		Date achat = new Date();
		MaterielDto mat = new MaterielDto("Orion", "PistoXC", 500, "pompe2", 1, achat, "pompe");
		TypeMaterielDto testType = typeService.getTypeByMateriel(mat);
		assertNotNull(testType);

		assertEquals(1, testType.getId());
		assertEquals("POMPE", testType.getLibelleMateriel());
		assertNotEquals(2, testType.getId());
		assertNotEquals("Test", testType.getLibelleMateriel());

	}

	@Test
	@Order(5)
	/**
	 * Test la bonne récupération de tous les TypeMaterielDto par le
	 * TypeMaterielServiceImpl
	 * 
	 * @throws Exception
	 */
	public void testGetAll() throws Exception {

		List<TypeMaterielDto> listeType = typeService.getAll(Constantes.ELEMENTS_PAGE);
		assertNotNull(listeType);

	}

}
