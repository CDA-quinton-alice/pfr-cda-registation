import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListeMaterielComponent } from './modules/materiel/liste-materiel/liste-materiel.component';
import { AccueilComponent } from './modules/utilisateur/accueil/accueil.component';
import {ListeDocumentComponent} from './modules/document/liste-document/liste-document.component';

const routes: Routes = [
  { path: 'utilisateur', component: AccueilComponent },
  { path: 'materiel', component: ListeMaterielComponent },
  {path: 'document', component: ListeDocumentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
