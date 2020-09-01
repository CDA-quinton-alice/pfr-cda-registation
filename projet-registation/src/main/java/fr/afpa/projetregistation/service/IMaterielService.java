package fr.afpa.projetregistation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dto.MaterielDto;

@Service
public interface IMaterielService {

	/**
	 * Méthode permettant de créer un MaterielDto à partir des informations
	 * récupérées et le modifier en MaterielEntity
	 * 
	 * @param MaterielDto
	 * @return MaterielDto
	 */
	MaterielDto create(MaterielDto materiel);

	/**
	 * Méthode permettant de récupérer un MaterielDto par son Id à savoir la
	 * référence.
	 * 
	 * @param int pRef : La référence du matériel
	 * @return MaterielDto
	 */
	MaterielDto getMaterielById(int pRef);

	/**
	 * Cette méthode permet de récupérer une liste de MatérielDto en appelant le
	 * MaterielDao
	 * 
	 * @return liste de MaterielDto
	 */
	List<MaterielDto> getAll(int pPageEnCours);

	/**
	 * Méthode permettant de réaliser la mise à jour des informations d'un
	 * MaterielDto.
	 * 
	 * @param pRef        la référence du Matériel à modifier.
	 * @param MaterielDto le MaterielDto possédant les nouvelles données.
	 * @return MaterielDto
	 */
	void updateById(int pRef, MaterielDto pMatDto);

	/**
	 * Méthode permettant de modifier l'état d'un matériel. (ex: une pompe qui
	 * fonctionnait qui devient HS)
	 * 
	 * @param pRef  Id du matériel à modifier.
	 * @param pEtat int correspondant au nouvel état du matériel. ( 1 : ok; 2 :
	 *              alerte; 3 : HS)
	 * @return MaterielDto modifié
	 */
	void updateEtatById(int pRef, int pEtat);

}
