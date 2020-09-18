import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GetDocumentByIdRoutingModule } from './get-document-by-id-routing.module';
import { GetDocumentByIdComponent } from './get-document-by-id.component';


@NgModule({
  declarations: [GetDocumentByIdComponent],
  imports: [
    CommonModule,
    GetDocumentByIdRoutingModule
  ]
})
export class GetDocumentByIdModule { }
