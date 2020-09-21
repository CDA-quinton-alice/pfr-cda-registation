import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MajCategorieDocumentRoutingModule } from './maj-categorie-document-routing.module';
import { MajCategorieDocumentComponent } from './maj-categorie-document.component';


@NgModule({
  declarations: [MajCategorieDocumentComponent],
  imports: [
    CommonModule,
    MajCategorieDocumentRoutingModule
  ]
})
export class MajCategorieDocumentModule { }
