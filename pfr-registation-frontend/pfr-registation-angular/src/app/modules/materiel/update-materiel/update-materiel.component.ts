import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
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
  date: Date = new Date;

  typeMatList: string[] = ['POMPE', 'CUVE', 'BOUTIQUE'];


  
  // materielForm = this.fb.group({
  //   ref: [this.materiel.ref, [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
  //   marque: [this.materiel.marque,[Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
  //   modele: [this.materiel.modele,[Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
  //   prix: [this.materiel.prix, [Validators.required, Validators.min(1), Validators.max(1000000)]],
  //   etat: [this.materiel.etat, [Validators.required, Validators.min(1), Validators.max(3)]],
  //   typeMateriel: [this.materiel.typeMateriel,[Validators.required]],
  //   dateAchat: [this.materiel.dateAchat, [Validators.required]],
  //   localisation: [this.materiel.localisation,[Validators.required, Validators.minLength(3)]]
  // })

  constructor(private route: ActivatedRoute,
    private router: Router, private materielService: MaterielService,) {}

  ngOnInit(): void { 
    this.route.paramMap.subscribe(res=>{
      this.idMat = +res.get('param1');   
      this.getMaterielById(this.idMat); 
     
    })
  }

  getMaterielById(idMat: number) {
    this.materielService.findById(idMat).subscribe(res => {
      this.materiel = res;
      // this.initForm();
      
    });
  }

  // initForm(){
  //   console.log(this.materiel.ref);
  //   this.materielForm = this.fb.group({
  //     ref: [this.materiel.ref, [Validators.required, Validators.minLength(1), Validators.maxLength(20)]],
  //     marque: [this.materiel.marque,[Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
  //     modele: [this.materiel.modele,[Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
  //     prix: [this.materiel.prix, [Validators.required, Validators.min(1), Validators.max(1000000)]],
  //     etat: [this.materiel.etat, [Validators.required, Validators.min(1), Validators.max(3)]],
  //     typeMateriel: [this.materiel.typeMateriel,[Validators.required]],
  //     dateAchat: [this.materiel.dateAchat, [Validators.required]],
  //     localisation: [this.materiel.localisation,[Validators.required, Validators.minLength(3)]]
  //   })
  // }
 
   updateMateriel(){
      console.log(this.materiel.marque);
      this.materielService.updateMateriel(this.materiel).subscribe(result => this.gotoMaterielList());
    }

  gotoMaterielList() {
      this.router.navigate(['/materiel/liste']);
    }

}
