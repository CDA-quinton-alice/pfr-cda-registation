import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EvenementRoutingModule } from './evenement-routing.module';
import { AgendaComponent } from './agenda/agenda.component';
import { CelluleComponent } from './cellule/cellule/cellule.component';


@NgModule({
  declarations: [AgendaComponent, CelluleComponent],
  imports: [
    CommonModule,
    EvenementRoutingModule,
  ]
})
export class EvenementModule { }
