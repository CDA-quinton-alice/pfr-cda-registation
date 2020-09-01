package fr.afpa.projetregistation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dao.IEvenementDao;
import fr.afpa.projetregistation.dto.EvenementDto;
import fr.afpa.projetregistation.entity.EvenementEntity;
import fr.afpa.projetregistation.service.IEvenementService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EvenementServiceImpl implements IEvenementService{

	@Autowired
	IEvenementDao edao;
	
	
	@Override
	public List<EvenementDto> getAll() {
		log.info("Obtention de la liste des évènements : complète");
		Iterable<EvenementEntity> itE = edao.findAll();
		Iterator<EvenementEntity> it = itE.iterator();
		List<EvenementDto> list = new ArrayList<>(); 
		while(it.hasNext()) {
			EvenementEntity ee = it.next();
			
			//A MODIFIER POUR INCLURE L'UTILISATEUR
			list.add(new EvenementDto(ee.getId(),
						ee.getType(),
						ee.getDescription(),
						ee.getDate_debut(),
						ee.getDate_fin(),
						ee.getDuree()
					));
		}
		
		return list;
	}

	@Override
	public List<EvenementDto> getByDate(Date debut, Date fin) {
		log.info("Obtention de la liste des évènements : par date de début ("+debut+") et fin("+fin+")");
		Iterable<EvenementEntity> itE = edao.findByDate(debut, fin);
		Iterator<EvenementEntity> it = itE.iterator();
		List<EvenementDto> list = new ArrayList<>(); 
		while(it.hasNext()) {
			EvenementEntity ee = it.next();
			
			//A MODIFIER POUR INCLURE L'UTILISATEUR
			list.add(new EvenementDto(ee.getId(),
						ee.getType(),
						ee.getDescription(),
						ee.getDate_debut(),
						ee.getDate_fin(),
						ee.getDuree()
					));
		}
		
		return list;
	}

	@Override
	public List<EvenementDto> getByDate(Date debut) {
		log.info("Obtention de la liste des évènements : par date de début ("+debut+")");
		Iterable<EvenementEntity> itE = edao.findByDate(debut);
		Iterator<EvenementEntity> it = itE.iterator();
		List<EvenementDto> list = new ArrayList<>(); 
		while(it.hasNext()) {
			EvenementEntity ee = it.next();
			
			//A MODIFIER POUR INCLURE L'UTILISATEUR
			list.add(new EvenementDto(ee.getId(),
						ee.getType(),
						ee.getDescription(),
						ee.getDate_debut(),
						ee.getDate_fin(),
						ee.getDuree()
					));
		}
		
		return list;
	}

	@Override
	public List<EvenementDto> getByType(String type) {
		log.info("Obtention de la liste des évènements : par type d'évènement ("+type+")");
		Iterable<EvenementEntity> itE = edao.findByType(type);
		Iterator<EvenementEntity> it = itE.iterator();
		List<EvenementDto> list = new ArrayList<>(); 
		while(it.hasNext()) {
			EvenementEntity ee = it.next();
			
			//A MODIFIER POUR INCLURE L'UTILISATEUR
			list.add(new EvenementDto(ee.getId(),
						ee.getType(),
						ee.getDescription(),
						ee.getDate_debut(),
						ee.getDate_fin(),
						ee.getDuree()
					));
		}
		
		return list;
	}

	@Override
	public EvenementDto create(EvenementDto evenement) {
		log.info("Ajout d'un évènement en base de donnée : "+evenement);
		EvenementEntity ee = EvenementEntity.builder()
				.type(evenement.getType())
				.description(evenement.getDescription())
				.date_debut(evenement.getDate_debut())
				.date_fin(evenement.getDate_fin())
				.duree(evenement.getDuree()).build();
		
		ee = edao.save(ee);
		EvenementDto edto = EvenementDto.builder()
								.id(ee.getId())
								.type(ee.getType())
								.description(ee.getDescription())
								.date_debut(ee.getDate_debut())
								.date_fin(ee.getDate_fin())
								.duree(ee.getDuree()).build();
		return edto;
	}

	@Override
	public EvenementDto update(EvenementDto evenement) {
		log.info("Update d'un évènement en base de donnée"+evenement);
		EvenementEntity ee = EvenementEntity.builder()
				.type(evenement.getType())
				.description(evenement.getDescription())
				.date_debut(evenement.getDate_debut())
				.date_fin(evenement.getDate_fin())
				.duree(evenement.getDuree()).build();
		
		ee = edao.save(ee);
		EvenementDto edto = EvenementDto.builder()
								.id(ee.getId())
								.type(ee.getType())
								.description(ee.getDescription())
								.date_debut(ee.getDate_debut())
								.date_fin(ee.getDate_fin())
								.duree(ee.getDuree()).build();
		return edto;
	}

	@Override
	public void delete(EvenementDto evenement) {
		log.info("Supression d'un évènement en base de donnée"+evenement);
		EvenementEntity ee = EvenementEntity.builder()
				.type(evenement.getType())
				.description(evenement.getDescription())
				.date_debut(evenement.getDate_debut())
				.date_fin(evenement.getDate_fin())
				.duree(evenement.getDuree()).build();
		
		edao.delete(ee);
	}

}