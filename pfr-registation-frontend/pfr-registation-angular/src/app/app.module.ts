import { BrowserModule } from '@angular/platform-browser';
import { NgModule , CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UtilisateurModule } from './modules/utilisateur/utilisateur.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from './modules/shared/shared.module';
import { MaterielModule } from './modules/materiel/materiel.module';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './user-service.service';
import { FormsModule } from '@angular/forms';
import { MaterielService } from './services/materiel.service';
import { DocumentModule } from './modules/document/document.module';
import { AjouterDocumentModule } from './modules/document/ajouter-document/ajouter-document.module';
import { SupprimerDocumentModule } from './modules/document/supprimer-document/supprimer-document.module';
import { MajNomDocumentModule } from './modules/document/maj-nom-document/maj-nom-document.module';
import { MajCategorieDocumentModule } from './modules/document/maj-categorie-document/maj-categorie-document.module';
import { MajDateAjoutDocumentModule } from './modules/document/maj-date-ajout-document/maj-date-ajout-document.module';
import { MajDerniereModificationDocumentModule } from './modules/document/maj-derniere-modification-document/maj-derniere-modification-document.module';
import { MajDescriptionDocumentModule } from './modules/document/maj-description-document/maj-description-document.module';
import { MajCommentairesDocumentModule } from './modules/document/maj-commentaires-document/maj-commentaires-document.module';
import { MajMatriculeUtilisateurModule } from './modules/document/maj-matricule-utilisateur/maj-matricule-utilisateur.module';
import { GetDocumentModule } from './modules/document/get-document/get-document.module';
import { ListeDocumentModule } from './modules/document/liste-document/liste-document.module';
import { DocumentExistByIdModule } from './modules/document/document-exist-by-id/document-exist-by-id.module';
import { GetDocumentByNomModule } from './modules/document/get-document-by-nom/get-document-by-nom.module';
import { GetDocumentByIdModule } from './modules/document/get-document-by-id/get-document-by-id.module';





@NgModule({
  declarations: [
    AppComponent,

    UserListComponent,
    UserFormComponent,
  ],

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    UtilisateurModule,
    MaterielModule,
    SharedModule,
    FormsModule,
    DocumentModule,
    AjouterDocumentModule,
    SupprimerDocumentModule,
    MajNomDocumentModule,
    MajCategorieDocumentModule,
    MajDateAjoutDocumentModule,
    MajDerniereModificationDocumentModule,
    MajDescriptionDocumentModule,
    MajCommentairesDocumentModule,
    MajMatriculeUtilisateurModule,
    GetDocumentModule,
    ListeDocumentModule,
    DocumentExistByIdModule,
    GetDocumentByNomModule,
    GetDocumentByIdModule,
  ],

  providers: [UserService, MaterielService],
  bootstrap: [AppComponent]
})
export class AppModule { }
