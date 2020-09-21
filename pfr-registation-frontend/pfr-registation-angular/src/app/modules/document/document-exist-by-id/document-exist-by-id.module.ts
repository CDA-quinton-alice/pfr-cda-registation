import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocumentExistByIdRoutingModule } from './document-exist-by-id-routing.module';
import { DocumentExistByIdComponent } from './document-exist-by-id.component';


@NgModule({
  declarations: [DocumentExistByIdComponent],
  imports: [
    CommonModule,
    DocumentExistByIdRoutingModule
  ]
})
export class DocumentExistByIdModule { }
