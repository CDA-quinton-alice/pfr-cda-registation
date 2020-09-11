import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilComponent } from './modules/utilisateur/accueil/accueil.component';

const routes: Routes = [
  { path: 'utilisateur', component: AccueilComponent},
  {path: 'materiel',
 loadChildren: ()  => import('./modules/materiel/materiel.module').
  then(m  =>  m.MaterielModule)},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
