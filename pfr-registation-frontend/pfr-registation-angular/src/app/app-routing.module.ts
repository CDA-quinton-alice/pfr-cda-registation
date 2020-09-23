import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListeDocumentComponent} from './modules/document/liste-document/liste-document.component';
import { ContentComponent } from './component/content/content.component';

const routes: Routes = [
  { path: 'utilisateur', loadChildren: './modules/utilisateur/utilisateur.module#UtilisateurModule' },
  { path: 'materiel', loadChildren: './modules/materiel/materiel.module#MaterielModule' },
  { path: 'evenement', loadChildren:'./modules/evenement/evenement.module#EvenementModule'},
  { path: 'document', component: ListeDocumentComponent},
  { path: 'accueil', component: ContentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

