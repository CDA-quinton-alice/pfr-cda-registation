import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import {NgbDate, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { Ievent } from 'src/app/interfaces/ievent';
import { EvenementService } from 'src/app/services/evenement/evenement.service';
import {AgendaComponent} from 'src/app/modules/evenement/agenda/agenda.component';
import { IAjoutData } from 'src/app/interfaces/i-ajout-data';
import { Inject } from '@angular/core';

@Component({
  selector: 'app-ajout-modal',
  templateUrl: './ajout-modal.component.html',
  styleUrls: ['./ajout-modal.component.css']
})

export class AjoutModalComponent implements OnInit {
  model: NgbDateStruct = undefined;
  model2: NgbDateStruct= undefined;
  IsmodelShow:boolean;
  event: Ievent = {};
  ac : AgendaComponent;
  user:string;
  
  constructor(private fb: FormBuilder, private eserv: EvenementService,
    public dialogRef: MatDialogRef<AjoutModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: IAjoutData) { }

  ngOnInit(): void {
    this.model = new NgbDate(this.data.date.getFullYear(),this.data.date.getMonth() + 1,this.data.date.getDate());

    
    this.model2 = new NgbDate(this.data.date.getFullYear(),this.data.date.getMonth() + 1,this.data.date.getDate());

    
    this.user = "RESP001";
  }


  ajouterEvenement(ac:AgendaComponent){
    if(this.event){
      let strDd = JSON.stringify(this.event.date_debut);
      let jsonDd = JSON.parse(strDd);
      this.event.date_debut = new Date(jsonDd.year+"-"+jsonDd.month+"-"+jsonDd.day);

      let strDf = JSON.stringify(this.event.date_fin);
      let jsonDf = JSON.parse(strDf);
      this.event.date_fin = new Date(jsonDf.year+"-"+jsonDf.month+"-"+jsonDf.day);

      this.event.user = this.user;
      this.eserv.createEvenement(this.event).subscribe(res=>{
        ac.updateCalendar("n",this.data.date);
        this.dialogRef.close();
      });
    } 
  }

  getFullMonth(m:number):string{
    if(m<10){
      return "0"+m;
    }else{
      return m+"";
    }
  }

}
