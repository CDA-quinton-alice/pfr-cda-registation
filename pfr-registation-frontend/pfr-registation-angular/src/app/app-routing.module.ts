import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListeMaterielComponent } from './modules/materiel/liste-materiel/liste-materiel.component';
import { AccueilComponent } from './modules/utilisateur/accueil/accueil.component';

const routes: Routes = [
  { path: 'utilisateur', component: AccueilComponent },
  { path: 'materiel', component: ListeMaterielComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
