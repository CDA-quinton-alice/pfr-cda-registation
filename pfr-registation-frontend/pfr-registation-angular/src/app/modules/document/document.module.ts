import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentRoutingModule } from './document-routing.module';
import {SharedModule} from '../shared/shared.module';
import { AjouterDocumentModule} from './ajouter-document/ajouter-document.module';
import { DocumentExistByIdModule} from './document-exist-by-id/document-exist-by-id.module';
import { GetDocumentByNomModule} from './get-document-by-nom/get-document-by-nom.module';
import { ListeDocumentModule} from './liste-document/liste-document.module';
import { MajCategorieDocumentModule} from './maj-categorie-document/maj-categorie-document.module';
import { MajCommentairesDocumentModule} from './maj-commentaires-document/maj-commentaires-document.module';
import { MajDateAjoutDocumentModule} from './maj-date-ajout-document/maj-date-ajout-document.module';
import {MajDerniereModificationDocumentModule} from './maj-derniere-modification-document/maj-derniere-modification-document.module';
import { MajDescriptionDocumentModule} from './maj-description-document/maj-description-document.module';
import {MajMatriculeUtilisateurModule} from './maj-matricule-utilisateur/maj-matricule-utilisateur.module';
import { MajNomDocumentModule} from './maj-nom-document/maj-nom-document.module';
import {SupprimerDocumentModule} from './supprimer-document/supprimer-document.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {AjouterDocumentComponent} from './ajouter-document/ajouter-document.component';
import {DocumentExistByIdComponent} from './document-exist-by-id/document-exist-by-id.component';
import {GetDocumentByIdComponent} from './get-document-by-id/get-document-by-id.component';
import {GetDocumentByNomComponent} from './get-document-by-nom/get-document-by-nom.component';
import {ListeDocumentComponent} from './liste-document/liste-document.component';
import {MajCategorieDocumentComponent} from './maj-categorie-document/maj-categorie-document.component';
import {MajCommentairesDocumentComponent} from './maj-commentaires-document/maj-commentaires-document.component';
import {MajDateAjoutDocumentComponent} from './maj-date-ajout-document/maj-date-ajout-document.component';
import {MajDerniereModificationDocumentComponent} from './maj-derniere-modification-document/maj-derniere-modification-document.component';
import {MajDescriptionDocumentComponent} from './maj-description-document/maj-description-document.component';
import {MajMatriculeUtilisateurComponent} from './maj-matricule-utilisateur/maj-matricule-utilisateur.component';
import {MajNomDocumentComponent} from './maj-nom-document/maj-nom-document.component';
import {SupprimerDocumentComponent} from './supprimer-document/supprimer-document.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';


@NgModule({
  declarations: [AjouterDocumentComponent, DocumentExistByIdComponent, GetDocumentByIdComponent, GetDocumentByNomComponent, ListeDocumentComponent,
  MajCategorieDocumentComponent, MajCommentairesDocumentComponent, MajDateAjoutDocumentComponent, MajDerniereModificationDocumentComponent,
  MajDescriptionDocumentComponent, MajMatriculeUtilisateurComponent, MajNomDocumentComponent, SupprimerDocumentComponent],
  imports: [
    CommonModule,
    DocumentRoutingModule,
    SharedModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
  ]
})
export class DocumentModule { }
