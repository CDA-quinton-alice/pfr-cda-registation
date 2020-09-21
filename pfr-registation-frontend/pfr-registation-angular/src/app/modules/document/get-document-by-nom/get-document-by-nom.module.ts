import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GetDocumentByNomRoutingModule } from './get-document-by-nom-routing.module';
import { GetDocumentByNomComponent } from './get-document-by-nom.component';


@NgModule({
  declarations: [GetDocumentByNomComponent],
  imports: [
    CommonModule,
    GetDocumentByNomRoutingModule
  ]
})
export class GetDocumentByNomModule { }
