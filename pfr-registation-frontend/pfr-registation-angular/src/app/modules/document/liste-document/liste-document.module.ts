import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListeDocumentRoutingModule } from './liste-document-routing.module';
import { ListeDocumentComponent } from './liste-document.component';


@NgModule({
  declarations: [ListeDocumentComponent],
  imports: [
    CommonModule,
    ListeDocumentRoutingModule
  ]
})
export class ListeDocumentModule { }
