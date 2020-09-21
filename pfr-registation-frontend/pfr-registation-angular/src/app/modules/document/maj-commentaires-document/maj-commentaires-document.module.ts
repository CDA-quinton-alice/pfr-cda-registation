import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MajCommentairesDocumentRoutingModule } from './maj-commentaires-document-routing.module';
import { MajCommentairesDocumentComponent } from './maj-commentaires-document.component';


@NgModule({
  declarations: [MajCommentairesDocumentComponent],
  imports: [
    CommonModule,
    MajCommentairesDocumentRoutingModule
  ]
})
export class MajCommentairesDocumentModule { }
