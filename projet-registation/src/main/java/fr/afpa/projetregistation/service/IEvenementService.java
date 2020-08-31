package fr.afpa.projetregistation.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dto.EvenementDto;

/**
 * Interface pour l'accès aux fonctionnalités liés aux @see EvenementEntity
 * 
 * @author Samuel
 *
 */

@Service
public interface IEvenementService {

	public List<EvenementDto> getAll();
	
	public List<EvenementDto> getByDate(Date debut, Date fin);
	
	public List<EvenementDto> getByDate(Date debut);
	
	public List<EvenementDto> getByType(String type);
	
	public EvenementDto create(EvenementDto evenement);
	
	public EvenementDto update(EvenementDto evenement);

	public void delete(EvenementDto evenement);
	
		
}
 