import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { UtilisateurListComponent } from './utilisateur-list/utilisateur-list.component';

const routes: Routes = [
  {
    path: 'utilisateur', component: AccueilComponent, children: [
      { path: 'liste', component: UtilisateurListComponent }]
  }]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UtilisateurRoutingModule { }
