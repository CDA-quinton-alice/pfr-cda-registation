import { Component, Inject, Input, OnInit } from '@angular/core';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { IPlusData } from 'src/app/interfaces/i-plus-data';
import { Ievent } from 'src/app/interfaces/ievent';

@Component({
  selector: 'app-plus-modal',
  templateUrl: './plus-modal.component.html',
  styleUrls: ['./plus-modal.component.css']
})
export class PlusModalComponent implements OnInit {


  constructor(
    public dialogRef: MatDialogRef<PlusModalComponent>,
    @Inject(MAT_DIALOG_DATA) public data: IPlusData) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  getEventColor(e:Ievent):string{
    switch(e.type){
      case 'Autre':
          return "autre";
        break;
      case 'Révision':
        return "revision";
        break;
      case 'Inspection':
        return "inspection";
        break;
      case 'Panne':
        return "panne";
        break;
    }
  }

  estDansIntervale(d1:Date,d2:Date,t:Date):boolean{
    let date1 = new Date((d1.getMonth()+1)+"/"+d1.getDate()+"/"+d1.getFullYear());
    let date2 = new Date((d2.getMonth()+1)+"/"+d2.getDate()+"/"+d2.getFullYear());
    let test = new Date((t.getMonth()+1)+"/"+t.getDate()+"/"+t.getFullYear());
    return date1<=test&&test<=date2;
  }
}
