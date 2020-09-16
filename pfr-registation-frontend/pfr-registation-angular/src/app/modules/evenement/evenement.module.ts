import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EvenementRoutingModule } from './evenement-routing.module';
import { AgendaComponent } from './agenda/agenda.component';


@NgModule({
  declarations: [AgendaComponent],
  imports: [
    CommonModule,
    EvenementRoutingModule
  ]
})
export class EvenementModule { }
