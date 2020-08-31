package fr.afpa.projetregistation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dto.TypeMaterielDto;

@Service
public interface ITypeMaterielService {

	public TypeMaterielDto addType(TypeMaterielDto pType);

	public List<TypeMaterielDto> getAll(String pLibelle);

	public TypeMaterielDto getTypeById(int pId);

	public TypeMaterielDto getTypeByLibelle(String pLibelle);
}
