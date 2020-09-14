import { Component, OnInit } from '@angular/core';
import { Imateriel } from 'src/app/interfaces/imateriel';

@Component({
  selector: 'app-ajouter-materiel',
  templateUrl: './ajouter-materiel.component.html',
  styleUrls: ['./ajouter-materiel.component.css']
})
export class AjouterMaterielComponent implements OnInit {

     materiels: Array<Imateriel> = []; 
     materiel: Imateriel ={};
 

  constructor() { }
  ngOnInit(): void { }

  ajouterMateriel(){
    this.materiels.push({ ...this.materiel});
    this.materiel.ref ='';
    this.materiel.marque_materiel='';
    this.materiel.date_achat= '';
   


  }
}
