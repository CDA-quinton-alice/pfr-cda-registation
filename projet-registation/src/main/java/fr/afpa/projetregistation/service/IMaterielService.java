package fr.afpa.projetregistation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dto.MaterielDto;

@Service
public interface IMaterielService {

	List<MaterielDto> getAll();

}
