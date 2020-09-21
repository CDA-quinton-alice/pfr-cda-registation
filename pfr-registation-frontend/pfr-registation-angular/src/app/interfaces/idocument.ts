interface IDatataBaseObj{
  tableName: string;
  idDocument: string;
}
export interface IDocument extends IDatataBaseObj{
  nomDocument?: string;
  categorieDocument?: string;
  dateAjoutDocument?: Date;
  dateDerniereModificationDocument?: Date;
  descriptionDocument?: string;
  commentairesDocument?: string;
  matriculeUtilisateur?: string;
}
export class Document implements IDocument {
  static tableName = 'document_entity';
  idDocument: string;
  constructor(documents: IDocument) {
    Object.keys(documents).forEach(doc => {
      const value = documents[doc];
      this[doc] = value;
    });
  }

  nomDocument?: string;
    categorieDocument?: string;
    dateAjoutDocument?: Date;
    dateDerniereModificationDocument?: Date;
    descriptionDocument?: string;
    commentairesDocument?: string;
    matriculeUtilisateur?: string;
    tableName: string;
}
