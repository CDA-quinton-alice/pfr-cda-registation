import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentFormComponent} from './document-form/document-form.component';

import {ListeDocumentComponent} from './liste-document/liste-document.component';


const routes: Routes = [
  {path: 'document/', component: ListeDocumentComponent},
  {path: 'document/ajout', component: DocumentFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocumentRoutingModule { }
