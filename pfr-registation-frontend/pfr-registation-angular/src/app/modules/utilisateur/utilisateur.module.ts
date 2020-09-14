import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UtilisateurRoutingModule } from './utilisateur-routing.module';
import { AccueilComponent } from './accueil/accueil.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [AccueilComponent],
  imports: [
    CommonModule,
    UtilisateurRoutingModule,
    SharedModule,
  ]
})
export class UtilisateurModule { }
