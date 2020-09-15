package fr.afpa.projetregistation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.entity.UserTestEntity;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.service.ITypeMaterielService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class MaterielController {

	@Autowired
	IMaterielService materielService;

	@Autowired
	ITypeMaterielService typeService;

	@GetMapping("/materiel")
	public List<MaterielDto> getAll() {
		List<MaterielDto> listeMat =new ArrayList<MaterielDto>();
		listeMat=materielService.getAll(1);
		return listeMat;
	
	}
	
	@GetMapping("/materiel/{pId}")
	public MaterielDto getById(@PathVariable (value="pId") int pId) {
	
		MaterielDto mat= materielService.getMaterielById(pId);
		
		return mat;
	}
	
	@PostMapping("/materiel")
    public void addUser(@RequestBody MaterielDto pMat) {
		materielService.create(pMat);       
    }
	
}
