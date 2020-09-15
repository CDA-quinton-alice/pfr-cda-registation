import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel.service';
import { InfosMaterielComponent } from '../infos-materiel/infos-materiel.component';

@Component({
  selector: 'app-ajouter-materiel',
  templateUrl: './ajouter-materiel.component.html',
  styleUrls: ['./ajouter-materiel.component.css']
})
export class AjouterMaterielComponent {

  materiel: Imateriel = {};

  list_materiel: Array<Imateriel> = [];


  constructor(private route: ActivatedRoute,
    private router: Router, private materielService: MaterielService) { }

  addMateriel() {
    console.log(this.materiel);
      this.materielService.addMateriel(this.materiel).subscribe(result => this.gotoMaterielList());
    
  }

  gotoMaterielList() {
    this.router.navigate(['/materiel/liste']);
  }
}