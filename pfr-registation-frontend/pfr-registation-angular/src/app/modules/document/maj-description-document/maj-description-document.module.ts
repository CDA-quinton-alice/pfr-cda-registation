import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MajDescriptionDocumentRoutingModule } from './maj-description-document-routing.module';
import { MajDescriptionDocumentComponent } from './maj-description-document.component';


@NgModule({
  declarations: [MajDescriptionDocumentComponent],
  imports: [
    CommonModule,
    MajDescriptionDocumentRoutingModule
  ]
})
export class MajDescriptionDocumentModule { }
