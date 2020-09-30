import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentListeComponent} from './modules/document2/document-liste/document-liste.component';

import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  { path: 'utilisateur', loadChildren: './modules/utilisateur/utilisateur.module#UtilisateurModule' },
  { path: 'materiel', loadChildren: './modules/materiel/materiel.module#MaterielModule' },
  { path: 'evenement', loadChildren: './modules/evenement/evenement.module#EvenementModule'},
  { path: 'documentListe', loadChildren: './modules/document/document.module#DocumentModule'},
  {path: 'login', component: LoginComponent},
  {path: 'dashboard', component: DashboardComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

