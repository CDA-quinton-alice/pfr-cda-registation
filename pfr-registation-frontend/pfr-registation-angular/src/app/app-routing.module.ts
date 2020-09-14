import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'utilisateur', loadChildren: './modules/utilisateur/utilisateur.module#UtilisateurModule'},
  {path: 'materiel', loadChildren: './modules/materiel/materiel.module#MaterielModule'
 },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
