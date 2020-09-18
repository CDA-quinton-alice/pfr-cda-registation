import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MajNomDocumentRoutingModule } from './maj-nom-document-routing.module';
import { MajNomDocumentComponent } from './maj-nom-document.component';


@NgModule({
  declarations: [MajNomDocumentComponent],
  imports: [
    CommonModule,
    MajNomDocumentRoutingModule
  ]
})
export class MajNomDocumentModule { }
