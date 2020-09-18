import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AjouterDocumentRoutingModule } from './ajouter-document-routing.module';
import { AjouterDocumentComponent } from './ajouter-document.component';


@NgModule({
  declarations: [AjouterDocumentComponent],
  imports: [
    CommonModule,
    AjouterDocumentRoutingModule
  ]
})
export class AjouterDocumentModule { }
