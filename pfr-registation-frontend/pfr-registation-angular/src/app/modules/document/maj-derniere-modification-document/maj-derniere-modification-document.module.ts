import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MajDerniereModificationDocumentRoutingModule } from './maj-derniere-modification-document-routing.module';
import { MajDerniereModificationDocumentComponent } from './maj-derniere-modification-document.component';


@NgModule({
  declarations: [MajDerniereModificationDocumentComponent],
  imports: [
    CommonModule,
    MajDerniereModificationDocumentRoutingModule
  ]
})
export class MajDerniereModificationDocumentModule { }
