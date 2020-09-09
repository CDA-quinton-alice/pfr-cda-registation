import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UtilisateurRoutingModule } from './utilisateur-routing.module';
import { AccueilComponent } from './accueil/accueil.component';
import { TopNavbarComponent } from 'src/app/shared/top-navbar/top-navbar.component';
import { FondComponent } from 'src/app/shared/fond/fond.component';

@NgModule({
  declarations: [AccueilComponent , TopNavbarComponent, FondComponent],
  imports: [
    CommonModule,
    UtilisateurRoutingModule
  ]
})
export class UtilisateurModule { }
