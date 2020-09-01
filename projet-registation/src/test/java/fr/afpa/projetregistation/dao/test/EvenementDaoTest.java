package fr.afpa.projetregistation.dao.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dao.IEvenementDao;
import fr.afpa.projetregistation.entity.EvenementEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EvenementDaoTest{

	@Autowired
	private IEvenementDao edao;
	
	private static List<EvenementEntity> list = new ArrayList<>();
	
	@Test
	@Order(1)
	public void testCreate() {
		log.info("Test unitaire EvenementDao CREATE");
		String d1 = "30-08-2020";
		String d2 = "01-09-2020";
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date1 = null;
		Date date2 = null;
		int diff = 0;
		
		try {
			date1 = sdf.parse(d1);
			date2 = sdf.parse(d2);
			long mse = date2.getTime()-date1.getTime();
			diff = (int)TimeUnit.SECONDS.convert(mse, TimeUnit.MILLISECONDS); 
		}catch(ParseException e) {
			log.warn("Erreur lors du parsing des dates lors du test unitaire !");
		}
		

		EvenementEntity ee = EvenementEntity.builder().type("Panne")
				.description("test1")
				.date_debut(date1)
				.date_fin(date2)
				.duree(diff).build();
		
		assertNotNull(ee);
		
		ee = edao.save(ee);
		
		assertNotNull(ee.getId());
		
		if(ee.getId()!=0) {
			Optional<EvenementEntity> optEE = edao.findById(ee.getId());
			assertTrue(optEE.isPresent());
			list.add(optEE.get());
		}
		
	}
	
	@Test
	@Order(2)
	public void testReadById() {
		log.info("Test unitaire EvenementDao READ par ID");
		String d1 = "30-08-2020";
		String d2 = "02-09-2020";
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date1 = null;
		Date date2 = null;
		int diff = 0;
		
		try {
			date1 = sdf.parse(d1);
			date2 = sdf.parse(d2);
			long mse = date2.getTime()-date1.getTime();
			diff = (int)TimeUnit.SECONDS.convert(mse, TimeUnit.MILLISECONDS); 
		}catch(ParseException e) {
			log.warn("Erreur lors du parsing des dates lors du test unitaire !");
		}
		

		EvenementEntity ee = EvenementEntity.builder().type("Autre")
				.description("test2")
				.date_debut(date1)
				.date_fin(date2)
				.duree(diff).build();
		
		assertNotNull(ee);
		
		ee = edao.save(ee);
		
		assertNotNull(ee.getId());
		
		if(ee.getId()!=0) {
			Optional<EvenementEntity> optEE = edao.findById(ee.getId());
			assertTrue(optEE.isPresent());

			list.add(optEE.get());
		}
	}
	
	@Test
	@Order(3)
	public void testReadByType() {
		List<EvenementEntity> le = null;
		le = edao.findByType("panne");
		log.debug("findbytype"+edao.findByType("panne"));
		
		assertEquals(1,le.size());
		if(le.size()>0) {
			assertEquals("test1",le.get(0).getDescription());
		}
		
		le = edao.findByType("autre");
		
		assertEquals(1,le.size());
		if(le.size()>0) {
			assertEquals("test2",le.get(0).getDescription());
		}
	}
	
	@Test
	@Order(4)
	public void testByDateIntervale() {
		
	}
	
	@Test
	@Order(10)
	public void close() {
		for(EvenementEntity ee : list) {
			assertTrue(edao.findById(ee.getId()).isPresent());
			log.debug("Evenement id : "+ee.getId());
			edao.delete(ee);
		}
	}
}