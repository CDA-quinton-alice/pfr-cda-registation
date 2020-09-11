import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { UtilisateurListComponent } from './utilisateur-list/utilisateur-list.component';

const routes: Routes = [
  {path: 'accueil', component: AccueilComponent},
  {path: 'liste', component: UtilisateurListComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UtilisateurRoutingModule { }
