package fr.afpa.projetregistation.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dao.IPersonneDao;
import fr.afpa.projetregistation.dto.PersonneDto;
import fr.afpa.projetregistation.entity.PersonneEntity;

@Service
public class PersonneServiceImpl implements IPersonneService {

	@Autowired
	private IPersonneDao personneDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<PersonneDto> getAll() {
		List<PersonneDto> res = new ArrayList<>();
		List<PersonneEntity> pEList = personneDao.findAll();
		for (PersonneEntity personneEntity : pEList) {
			res.add(this.modelMapper.map(personneEntity, PersonneDto.class));
		}
		return res;
	}

}
