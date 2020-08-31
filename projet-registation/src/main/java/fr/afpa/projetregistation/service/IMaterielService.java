package fr.afpa.projetregistation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dto.MaterielDto;

@Service
public interface IMaterielService {

	MaterielDto create(MaterielDto materiel);

	MaterielDto getMaterielById(int pRef);

	/**
	 * Cette méthode permet de récupérer une liste de MatérielDto en appelant le
	 * MaterielDao
	 * 
	 * @return liste de MaterielDto
	 */
	List<MaterielDto> getAll(int pPageEnCours);

}
