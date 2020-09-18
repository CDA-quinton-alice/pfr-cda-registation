import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MajMatriculeUtilisateurRoutingModule } from './maj-matricule-utilisateur-routing.module';
import { MajMatriculeUtilisateurComponent } from './maj-matricule-utilisateur.component';


@NgModule({
  declarations: [MajMatriculeUtilisateurComponent],
  imports: [
    CommonModule,
    MajMatriculeUtilisateurRoutingModule
  ]
})
export class MajMatriculeUtilisateurModule { }
