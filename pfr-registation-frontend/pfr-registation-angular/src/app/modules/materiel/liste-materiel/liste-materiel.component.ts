import { Component, OnInit } from '@angular/core';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel-service/materiel.service';


@Component({
  selector: 'app-liste-materiel',
  templateUrl: './liste-materiel.component.html',
  styleUrls: ['./liste-materiel.component.css']
})
export class ListeMaterielComponent implements OnInit {

  materiel: Imateriel = {};
  list_materiel: Array<Imateriel> = [];
  monType: string;
  constructor(private materielService: MaterielService) { }

  ngOnInit(): void {

    this.materielService.findAll().subscribe(data => {
      this.list_materiel = data;
    })
  }

  getAllByType(monType: string) {

    this.materielService.findAllByType(monType).subscribe(data => {
    this.list_materiel = data;
    })
  }
}