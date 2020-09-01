package fr.afpa.projetregistation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.dto.TypeMaterielDto;

@Service
public interface ITypeMaterielService {

	public TypeMaterielDto addType(TypeMaterielDto pType);

	public List<TypeMaterielDto> getAll(int pPageEnCours);

	public TypeMaterielDto getTypeById(int pId);

	public TypeMaterielDto getTypeByLibelle(String pLibelle);

	TypeMaterielDto getTypeByMateriel(MaterielDto pMat);
}
