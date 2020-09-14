import { Component, OnInit } from '@angular/core';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel.service';

@Component({
  selector: 'app-ajouter-materiel',
  templateUrl: './ajouter-materiel.component.html',
  styleUrls: ['./ajouter-materiel.component.css']
})
export class AjouterMaterielComponent implements OnInit {

  materiel: Imateriel = {};

  list_materiel: Array<Imateriel> = [];


  constructor(private materielService: MaterielService) { }

  ngOnInit() {
    this.materielService.getAll().subscribe(res => {
      this.list_materiel = res;
    })
  }

  addMateriel() {
    this.materielService.addMateriel(this.materiel).subscribe(res => { 
      this.materielService.getAll().subscribe(result =>{
        this.list_materiel =result;
      })
    });
  }
}