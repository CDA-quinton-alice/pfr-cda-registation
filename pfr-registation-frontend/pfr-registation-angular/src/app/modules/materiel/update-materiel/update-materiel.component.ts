import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel.service';

@Component({
  selector: 'app-update-materiel',
  templateUrl: './update-materiel.component.html',
  styleUrls: ['./update-materiel.component.css']
})
export class UpdateMaterielComponent implements OnInit {

  materiel: Imateriel = {};
  idMat: number;

  constructor(private route: ActivatedRoute,
    private router: Router, private materielService: MaterielService) { }

  ngOnInit(): void {
  }


  getMaterielById(idMat: number) {
    this.materielService.findById(idMat).subscribe(res => {
      this.materiel = res;
    });

  }
   
   updateMateriel(){
     console.log(this.materiel);
      this.materielService.updateMateriel(this.materiel).subscribe(result => this.gotoMaterielList());
    }

  gotoMaterielList() {
      this.router.navigate(['/materiel/liste']);
    }

}
