package fr.afpa.projetregistation.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class DocumentDto {

public DocumentDto(String pNomDocument, String pCategorieDocument, Date pDateAjoutDocument, Date pDateDerniereModificationDocument,
			String pDescriptionDocument, String pCommentairesDocument) {
		// TODO Auto-generated constructor stub
	}

private int idDocument;

private String nomDocument;

private String categorieDocument;

private Date dateAjoutDocument;

private Date dateDerniereModificationDocument;

private String descriptionDocument;

private String commentairesDocument;


}


