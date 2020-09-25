import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Document2RoutingModule } from './document2-routing.module';
import { DocumentListeComponent } from './document-liste/document-liste.component';


@NgModule({
  declarations: [DocumentListeComponent],
  exports: [
    DocumentListeComponent
  ],
  imports: [
    CommonModule,
    Document2RoutingModule
  ]
})
export class Document2Module { }
