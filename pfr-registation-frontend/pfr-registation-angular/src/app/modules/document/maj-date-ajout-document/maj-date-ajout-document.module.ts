import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MajDateAjoutDocumentRoutingModule } from './maj-date-ajout-document-routing.module';
import { MajDateAjoutDocumentComponent } from './maj-date-ajout-document.component';


@NgModule({
  declarations: [MajDateAjoutDocumentComponent],
  imports: [
    CommonModule,
    MajDateAjoutDocumentRoutingModule
  ]
})
export class MajDateAjoutDocumentModule { }
