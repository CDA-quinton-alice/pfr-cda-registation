import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContentComponent } from './component/content/content.component';
import { AccueilComponent } from './modules/utilisateur/accueil/accueil.component';

const routes: Routes = [
  { path: 'utilisateur', loadChildren: './modules/utilisateur/utilisateur.module#UtilisateurModule'},
  {path: 'materiel',
 loadChildren: ()  => import('./modules/materiel/materiel.module').
  then(m  =>  m.MaterielModule)},
  { path: '', component: ContentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
