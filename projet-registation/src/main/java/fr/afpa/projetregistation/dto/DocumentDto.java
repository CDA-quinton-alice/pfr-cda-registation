package fr.afpa.projetregistation.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DocumentDto {

	private int idDocument;

	private String nomDocument;

	private String categorieDocument;

	private Date dateAjoutDocument;

	private Date dateDerniereModificationDocument;

	private String descriptionDocument;

	private String commentairesDocument;

	public DocumentDto(String pNomDocument, String pCategorieDocument, Date pDateAjoutDocument,
			Date pDateDerniereModificationDocument, String pDescriptionDocument, String pCommentairesDocument) {

		this.nomDocument = pNomDocument;
		this.categorieDocument = pCategorieDocument;
		this.dateAjoutDocument = pDateAjoutDocument;
		this.dateDerniereModificationDocument = pDateDerniereModificationDocument;
		this.descriptionDocument = pDescriptionDocument;
		this.commentairesDocument = pCommentairesDocument;

	}

}
