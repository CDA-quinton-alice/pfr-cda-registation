import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { EvenementRoutingModule } from './evenement-routing.module';
import { AgendaComponent } from './agenda/agenda.component';
import { CelluleComponent } from './cellule/cellule/cellule.component';
import { PlusModalComponent } from './cellule/plus-modal/plus-modal.component';
import { FormsModule } from '@angular/forms';
import { NgbDate, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatIconModule } from '@angular/material/icon';
import { MatButton } from '@angular/material/button';
import { ReactiveFormsModule } from '@angular/forms';
import { AjoutModalComponent } from './cellule/ajout-modal/ajout-modal.component';
import { EditModalComponent } from './cellule/edit-modal/edit-modal.component';

@NgModule({
  declarations: [AgendaComponent, CelluleComponent, PlusModalComponent, AjoutModalComponent, EditModalComponent],
  providers:[
    DatePipe,
  ],
  imports: [
    CommonModule,
    EvenementRoutingModule,
    FormsModule,
    NgbModule,
    MatIconModule,
    ReactiveFormsModule,
  ]
})
export class EvenementModule { }
