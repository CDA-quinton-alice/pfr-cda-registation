import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentListeComponent} from './document-liste/document-liste.component';
import {DocumentFormComponent} from './document-form/document-form.component';

const routes: Routes = [
  {path: 'documentListe', component: DocumentListeComponent},
  {path: 'documentForm', component: DocumentFormComponent},
  {path: '', component: DocumentListeComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class Document2RoutingModule {
}
