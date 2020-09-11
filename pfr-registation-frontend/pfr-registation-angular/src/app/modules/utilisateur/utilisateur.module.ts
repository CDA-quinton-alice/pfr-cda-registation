import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UtilisateurRoutingModule } from './utilisateur-routing.module';
import { AccueilComponent } from './accueil/accueil.component';
import { SharedModule } from '../shared/shared.module';
import { UtilisateurListComponent } from './utilisateur-list/utilisateur-list.component';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatBadgeModule} from '@angular/material/badge';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [AccueilComponent, UtilisateurListComponent],
  imports: [
    CommonModule,
    UtilisateurRoutingModule,
    SharedModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    MatBadgeModule,

  ]
})
export class UtilisateurModule { }
