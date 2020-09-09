import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterielRoutingModule } from './materiel-routing.module';
import { MaterielEtatComponent } from './materiel-etat/materiel-etat.component';


@NgModule({
  declarations: [MaterielEtatComponent],
  imports: [
    CommonModule,
    MaterielRoutingModule
  ]
})
export class MaterielModule { }
