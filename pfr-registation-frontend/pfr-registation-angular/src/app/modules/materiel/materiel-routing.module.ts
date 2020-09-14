import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AccueilMaterielComponent } from './accueil-materiel/accueil-materiel.component';
import { ListeMaterielComponent } from './liste-materiel/liste-materiel.component';
import { InfosMaterielComponent } from './infos-materiel/infos-materiel.component';
import { AjouterMaterielComponent } from './ajouter-materiel/ajouter-materiel.component';




const routes: Routes = [
  {path:'materiel/accueil', component:AccueilMaterielComponent},
  {path:'materiel/liste', component:ListeMaterielComponent},
  {path:'materiel/informations', component:InfosMaterielComponent},
  {path:'materiel/ajouter', component:AjouterMaterielComponent},

  {path:'', component:AccueilMaterielComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MaterielRoutingModule { }
