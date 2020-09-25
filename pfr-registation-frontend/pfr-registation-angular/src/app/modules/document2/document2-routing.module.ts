import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DocumentListeComponent} from './document-liste/document-liste.component';

const routes: Routes = [
  {path: 'documentListe', component: DocumentListeComponent},
  {path: '', component: DocumentListeComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]

})
export class Document2RoutingModule {
}
