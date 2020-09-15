import { Component, OnInit } from '@angular/core';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel.service';

@Component({
  selector: 'app-infos-materiel',
  templateUrl: './infos-materiel.component.html',
  styleUrls: ['./infos-materiel.component.css']
})
export class InfosMaterielComponent implements OnInit {
  materiel: Imateriel = {};
  idMat : number;
  constructor(private materielService: MaterielService) { }

  ngOnInit(): void {
  }


  getMaterielById(idMat: number) {

    this.materielService.findById(idMat).subscribe(res => { 

      this.materiel= res;
    });

  }
}
