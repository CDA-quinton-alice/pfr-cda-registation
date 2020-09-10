import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterielRoutingModule } from './materiel-routing.module';
import { MaterielEtatComponent } from './materiel-etat/materiel-etat.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [MaterielEtatComponent],
  imports: [
    CommonModule,
    MaterielRoutingModule,
    SharedModule
  ]
})
export class MaterielModule { }
