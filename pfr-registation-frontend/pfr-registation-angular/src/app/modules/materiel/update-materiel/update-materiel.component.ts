import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel-service/materiel.service';


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
    this.route.paramMap.subscribe(res=>{
      console.log(res.get('param1'));
      this.idMat = +res.get('param1');
      console.log(this.idMat + ' = '  + 'param1');
      this.getMaterielById(this.idMat);
    })
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
