import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MaterielEtatComponent } from './materiel-etat/materiel-etat.component';

const routes: Routes = [
  {path: 'etat', component: MaterielEtatComponent},
  {path:'', component: MaterielEtatComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MaterielRoutingModule { }
