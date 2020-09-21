import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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

const routes: Routes = [
  {path: 'document/ajouter', component: AjouterDocumentComponent},
  {path: 'document/exist-id', component: DocumentExistByIdComponent},
  {path: 'document/get-id', component: GetDocumentByIdComponent},
  {path: 'document/get-nom', component: GetDocumentByNomComponent},
  {path: 'document/liste', component: ListeDocumentComponent},
  {path: 'document/maj-categorie', component: MajCategorieDocumentComponent},
  {path: 'document/maj-commentaires', component: MajCommentairesDocumentComponent},
  {path: 'document/maj-date-ajout', component: MajDateAjoutDocumentComponent},
  {path: 'document/maj-derniere-modification', component: MajDerniereModificationDocumentComponent},
  {path: 'document/maj-description', component: MajDescriptionDocumentComponent},
  {path: 'document/maj-mattricule', component: MajMatriculeUtilisateurComponent},
  {path: 'document/maj-nom', component: MajNomDocumentComponent},
  {path: 'document/supprimer', component: SupprimerDocumentComponent},
  {path: 'document/', component: ListeDocumentComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentRoutingModule { }
