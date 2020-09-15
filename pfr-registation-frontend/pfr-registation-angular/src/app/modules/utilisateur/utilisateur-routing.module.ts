import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { UtilisateurFormComponent } from './utilisateur-form/utilisateur-form.component';
import { UtilisateurListComponent } from './utilisateur-list/utilisateur-list.component';

const routes: Routes = [
  {
    path: '', component: AccueilComponent, children: [
      { path: 'liste', component: UtilisateurListComponent },
      { path: 'add', component: UtilisateurFormComponent }
    ]
  }];
  

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UtilisateurRoutingModule { }
