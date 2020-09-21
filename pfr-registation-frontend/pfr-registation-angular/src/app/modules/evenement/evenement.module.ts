import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EvenementRoutingModule } from './evenement-routing.module';
import { AgendaComponent } from './agenda/agenda.component';
import { CelluleComponent } from './cellule/cellule/cellule.component';
import { CelluleModalComponent } from './cellule/cellule-modal/cellule-modal.component';
import { PlusModalComponent } from './cellule/plus-modal/plus-modal.component';


@NgModule({
  declarations: [AgendaComponent, CelluleComponent, CelluleModalComponent, PlusModalComponent],
  imports: [
    CommonModule,
    EvenementRoutingModule,
  ]
})
export class EvenementModule { }
