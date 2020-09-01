package fr.afpa.projetregistation.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afpa.projetregistation.dto.EvenementDto;
import fr.afpa.projetregistation.service.IEvenementService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EvenementServiceImplTest {
	
	@Autowired
	IEvenementService eserv;
	
	private static List<EvenementDto> list = new ArrayList<>();
	
	@Test
	@Order(1)
	public void testCreate() {
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

		

		EvenementDto ee = EvenementDto.builder().type("Panne")
				.description("test1")
				.date_debut(date1)
				.date_fin(date2)
				.duree(diff).build();
		
		assertNotNull(ee);
		
		ee = eserv.create(ee);
		
		assertNotNull(ee.getId());
		
		if(ee.getId()!=0) {
			EvenementDto optEE = eserv.getById(ee.getId());
			assertNotNull(optEE);
			list.add(optEE);
		}
	}
	
	@Test
	@Order(2)
	public void testUpdate() {
		EvenementDto test2 = eserv.getById(list.get(0).getId());
		test2.setType("Autre");
		eserv.update(test2);

		EvenementDto edto = eserv.getById(test2.getId());
		
		assertNotNull(edto);
		assertNotEquals("Panne", edto.getType());
		list.remove(0);
		list.add(test2);
	}
	
	@Test
	@Order(3)
	public void testReadByDateIntervale() {
		
	}
	
	@Test
	@Order(4)
	public void testReadByDate() {
		
	}
	
	@Test
	@Order(5)
	public void testReadByType() {
		
	}
	
	@Test
	@Order(6)
	public void testReadById() {
		
	}
	
	@Test
	@Order(7)
	public void testDelete() {
		
	}
	
//	@Test
//	@Order(8)
	public void testDeleteAll() {
		eserv.deleteAll();
		assertNull(eserv.getAll());
	}
}
