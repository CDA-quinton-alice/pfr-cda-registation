package fr.afpa.projetregistation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dao.ITypeMaterielDao;
import fr.afpa.projetregistation.dto.TypeMaterielDto;
import fr.afpa.projetregistation.entity.TypeMaterielEntity;
import fr.afpa.projetregistation.service.ITypeMaterielService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class TypeMaterielServiceImpl implements ITypeMaterielService {

	@Autowired
	ITypeMaterielDao typeMaterielDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TypeMaterielDto addType(TypeMaterielDto pType) {

		TypeMaterielEntity type = new TypeMaterielEntity();

		type = this.modelMapper.map(pType, TypeMaterielEntity.class);
		typeMaterielDao.save(type);
		pType.setId(type.getIdTypeMateriel());
		log.info("type matériel ajouté avec succès");
		return pType;
	}

	@Override
	public TypeMaterielDto getTypeById(int pId) {
		TypeMaterielDto typeDto = null;
		Optional<TypeMaterielEntity> resOp = typeMaterielDao.findById(pId);
		if (resOp.isPresent()) {
			typeDto = new TypeMaterielDto();
			TypeMaterielEntity type = resOp.get();

			typeDto = this.modelMapper.map(type, TypeMaterielDto.class);
		}
		return typeDto;
	}

	@Override
	public TypeMaterielDto getTypeByLibelle(String pLibelle) {
		TypeMaterielDto typeDto = null;
		Optional<TypeMaterielEntity> resOp = typeMaterielDao.findByLibelleMateriel(pLibelle);
		if (resOp.isPresent()) {
			typeDto = new TypeMaterielDto();
			TypeMaterielEntity type = resOp.get();

			typeDto = this.modelMapper.map(type, TypeMaterielDto.class);
		}
		return typeDto;
	}

	@Override
	public List<TypeMaterielDto> getAll(String pLibelle) {
		List<TypeMaterielEntity> list = typeMaterielDao.findByLibelleMaterielContaining(pLibelle);
		List<TypeMaterielDto> listType = new ArrayList<>();

		for (TypeMaterielEntity type : list) {
			TypeMaterielDto typeDto = modelMapper.map(type, TypeMaterielDto.class);
			listType.add(typeDto);
		}

		return listType;
	}

}
