import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AjouterDocumentRoutingModule } from './ajouter-document-routing.module';
import { AjouterDocumentComponent } from './ajouter-document.component';
import {ReactiveFormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDatepickerModule} from '@angular/material/datepicker';


@NgModule({
  declarations: [AjouterDocumentComponent],
  imports: [
    CommonModule,
    AjouterDocumentRoutingModule,
    ReactiveFormsModule,
    MatIconModule,
    MatFormFieldModule,
    MatDatepickerModule
  ]
})
export class AjouterDocumentModule { }
