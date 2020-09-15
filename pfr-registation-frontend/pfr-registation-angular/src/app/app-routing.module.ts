import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilMaterielComponent } from './modules/materiel/accueil-materiel/accueil-materiel.component';
import { AccueilComponent } from './modules/utilisateur/accueil/accueil.component';

import { UserFormComponent } from './user-form/user-form.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
  { path: 'utilisateur', component: AccueilComponent},
  {path: 'materiel', component:AccueilMaterielComponent},
  { path: 'userstest', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
