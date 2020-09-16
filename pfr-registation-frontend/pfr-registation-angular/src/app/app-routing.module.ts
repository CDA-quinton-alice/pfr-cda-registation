import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListeMaterielComponent } from './modules/materiel/liste-materiel/liste-materiel.component';
import { AccueilComponent } from './modules/utilisateur/accueil/accueil.component';

import { UserFormComponent } from './user-form/user-form.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
  { path: 'utilisateur', component: AccueilComponent },
  { path: 'userstest', component: UserListComponent },
  { path: 'adduser', component: UserFormComponent },
  { path: 'materiel', component: ListeMaterielComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
