import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SupprimerDocumentRoutingModule } from './supprimer-document-routing.module';
import { SupprimerDocumentComponent } from './supprimer-document.component';


@NgModule({
  declarations: [SupprimerDocumentComponent],
  imports: [
    CommonModule,
    SupprimerDocumentRoutingModule
  ]
})
export class SupprimerDocumentModule { }
