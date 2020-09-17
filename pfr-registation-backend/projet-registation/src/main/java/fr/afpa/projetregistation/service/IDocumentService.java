package fr.afpa.projetregistation.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dto.DocumentDto;
import fr.afpa.projetregistation.entity.DocumentEntity;

@Service
public interface IDocumentService {

	public DocumentDto ajouterDocument(DocumentDto document);

	public void supprimerDocument(int pIdDocument);

	public void majnomDocument(String pNomDocument, int pIdDocument);

	public void majCategorieDocument(String pCategorieDocument, int pIdDocument);

	public void majDateAjoutDocument(Date pDateAjoutDocument, int pIdDocument);

	public void majDateDerniereModificationDocument(Date pDateDerniereModificationDocument, int pIdDocument);

	public void majDescriptionDocument(String pDescriptionDocument, int pIdDocument);

	public void majCommentairesDocument(String pCommentairesDocument, int pIdDocument);

	public void majMatriculeUtilisateur(String pMatriculeUtilisateur, int pIdDocument);

	public DocumentDto getDocument(int pIdDocument);

	public List<DocumentDto> getAllDocuments(int pPageEnCours);

	public int getMaxid();

	public boolean existById(int pIdDocument);

	public DocumentDto getDocumentByNom(String pNomDocument);

}
