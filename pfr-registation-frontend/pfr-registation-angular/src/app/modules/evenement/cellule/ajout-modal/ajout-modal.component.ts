import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { Ievent } from 'src/app/interfaces/ievent';
import { EvenementService } from 'src/app/services/evenement/evenement.service';


@Component({
  selector: 'app-ajout-modal',
  templateUrl: './ajout-modal.component.html',
  styleUrls: ['./ajout-modal.component.css']
})

export class AjoutModalComponent implements OnInit {
  model: NgbDateStruct;
  model2: NgbDateStruct;
  IsmodelShow:boolean;
  event: Ievent = {};

  constructor(private fb: FormBuilder, private eserv: EvenementService,
    public dialogRef: MatDialogRef<AjoutModalComponent>) { }

  ngOnInit(): void {
  }

  ajouterEvenement(){
    if(this.event){
      let strDd = JSON.stringify(this.event.date_debut);
      let jsonDd = JSON.parse(strDd);
      this.event.date_debut = new Date(jsonDd.year+"-"+jsonDd.month+"-"+jsonDd.day);

      let strDf = JSON.stringify(this.event.date_fin);
      let jsonDf = JSON.parse(strDf);
      this.event.date_fin = new Date(jsonDf.year+"-"+jsonDf.month+"-"+jsonDf.day);

      this.eserv.createEvenement(this.event).subscribe(res=>{
        this.dialogRef.close();
      });
      console.log("Component: ajout");
    }
  }
}
