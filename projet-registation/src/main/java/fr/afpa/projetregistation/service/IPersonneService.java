package fr.afpa.projetregistation.service;

import java.util.List;

import fr.afpa.projetregistation.dto.PersonneDto;

public interface IPersonneService {
	List<PersonneDto> getAll();
}
