package fr.afpa.projetregistation.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.controller.MaterielController;
import fr.afpa.projetregistation.dao.IMaterielDao;
import fr.afpa.projetregistation.dao.ITypeMaterielDao;
import fr.afpa.projetregistation.dto.MaterielDto;
import fr.afpa.projetregistation.entity.MaterielEntity;
import fr.afpa.projetregistation.entity.TypeMaterielEntity;
import fr.afpa.projetregistation.service.IMaterielService;
import fr.afpa.projetregistation.utils.Constantes;
import lombok.extern.slf4j.Slf4j;

/**
 * Cette classe implémente l'interface IMaterielService afin de manipuler les
 * MaterielDto et MaterielEntity en vue d'appeler le MaterielDao
 * 
 * 
 * @author Aurélien
 * @version 1.0
 *
 */
@Slf4j
@Service
public class MaterielServiceImpl implements IMaterielService {

	/**
	 * Instanciation de l'interface matériel Dao.
	 */
	@Autowired
	IMaterielDao materielDao;

	/**
	 * Instanciation de l'interface typeMatériel Dao.
	 */
	@Autowired
	ITypeMaterielDao typeMaterielDao;

	/**
	 * Instanciation de l'outil modelMapper permettant de simplifier la conversion
	 * d'un dto vers une entity et inversement.
	 */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Cette méthode permet d'ajouter un nouveau matérielDto et d'appeler le Dao
	 * afin d'enregistrer cet élément en base de donnée.
	 *
	 * @see MaterielController
	 * @param MaterielDto
	 * @return MaterielDto
	 */
	@Override
	public MaterielDto create(MaterielDto pMateriel) {

		MaterielEntity matEntity = this.modelMapper.map(pMateriel, MaterielEntity.class);
		String type = pMateriel.getTypeMateriel().toUpperCase();

		/**
		 * Vérifie la présence du type de matériel en BDD.
		 */
		Optional<TypeMaterielEntity> optionalType = typeMaterielDao.findByLibelleMateriel(type.toUpperCase());
		/**
		 * Enregistre le type si non présent en BDD
		 */
		if (!optionalType.isPresent()) {
			TypeMaterielEntity typeMaterielEntity = new TypeMaterielEntity(pMateriel.getTypeMateriel().toUpperCase());
			typeMaterielDao.save(typeMaterielEntity);
			Optional<TypeMaterielEntity> optionalType2 = typeMaterielDao.findByLibelleMateriel(type.toUpperCase());
			matEntity.setTypeMaterielEntity(optionalType2.get());

		}
		/**
		 * Ajoute le type déjà existant à la nouvelle entité.
		 */
		else {
			matEntity.setTypeMaterielEntity(optionalType.get());
		}

		matEntity = materielDao.save(matEntity);
		pMateriel = this.getMaterielById(matEntity.getRef());
		log.info("ajout avec succes");
		return pMateriel;
	}

	/**
	 * Récupère un matériel par son ID. Mapping des informations.
	 * 
	 * @param pRef
	 * @return MaterielDto
	 */
	@Override
	public MaterielDto getMaterielById(int pRef) {
		Optional<MaterielEntity> opsRes = materielDao.findByRef(pRef);
		MaterielDto materiel = null;
		if (opsRes.isPresent()) {
			MaterielEntity matEntity = opsRes.get();
			materiel = this.modelMapper.map(matEntity, MaterielDto.class);
		}

		return materiel;
	}

	/**
	 * Cette méthode permet de récupérer une liste de MatérielDto en appelant le
	 * MaterielDao
	 * 
	 * @return liste de MaterielDto
	 */
	@Override
	public List<MaterielDto> getAll(int pPageEnCours) {
		List<MaterielDto> listeMateriel = new ArrayList<>();
		PageRequest page = PageRequest.of(pPageEnCours - 1, Constantes.ELEMENTS_PAR_PAGE);
		Page<MaterielEntity> listeMat = this.materielDao.findAll(page);
		for (MaterielEntity materielEntity : listeMat) {

			listeMateriel.add(this.modelMapper.map(materielEntity, MaterielDto.class));

		}
		return listeMateriel;
	}

}
