import { Component, Input, OnInit,Inject} from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Ievent } from 'src/app/interfaces/ievent';
import { AjoutModalComponent } from '../ajout-modal/ajout-modal.component';
import { PlusModalComponent } from '../plus-modal/plus-modal.component';

@Component({
  selector: 'app-cellule',
  templateUrl: './cellule.component.html',
  styleUrls: ['./cellule.component.css']
})
export class CelluleComponent implements OnInit {

  @Input() event: Array<Ievent>;
  eventInInterval : Array<Ievent>;
  @Input() jour: string;
  @Input() dates: Date;
  @Input() tete: boolean;
  @Input() headColor:String;

  nbSpan: number;
  plusDisplayed: boolean = false;
  constructor(public dialog: MatDialog) {
  }
 
  ngOnInit(): void {
    this.nbSpan=0;

    this.eventInInterval = new Array<Ievent>();
    if(this.event){
      for(let e of this.event){
        if(this.estDansIntervale(e.date_debut,e.date_fin,this.dates)){
          this.eventInInterval.push(e);
        }
      }
    }
  }

  ajoutModal(){
    const dialogRef = this.dialog.open(AjoutModalComponent, {
      width: '30rem',
      height:'25rem',
      data: {}
    });
  }

  editModal(){
    alert("Vous avez cliqué sur un évènement !");
  }

  estDansIntervale(d1:Date,d2:Date,t:Date):boolean{
    let date1 = new Date((d1.getMonth()+1)+"/"+d1.getDate()+"/"+d1.getFullYear());
    let date2 = new Date((d2.getMonth()+1)+"/"+d2.getDate()+"/"+d2.getFullYear());
    let test = new Date((t.getMonth()+1)+"/"+t.getDate()+"/"+t.getFullYear());
    return date1<=test&&test<=date2;
  }


  getNbSpan(){
    return this.nbSpan;
  }

  getShortType(s:string):string{
    switch(s){
      case 'Autre':
          return "A";
        break;
      case 'Révision':
        return "R";
        break;
      case 'Inspection':
        return "I";
        break;
      case 'Panne':
        return "P";
        break;
    }
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

  incSpan(){
    this.nbSpan++;
  }

  isPlusDisplayed():boolean{
    return this.plusDisplayed;
  }

  plusModal():void{
    const dialogRef = this.dialog.open(PlusModalComponent, {
      width: '250px',
      data: {eventData: this.eventInInterval, dates:this.dates}
    });
  }
  
  resetSpan(){
    this.nbSpan=0;
    this.plusDisplayed = false;
  }

  setPlusDisplayed(){
    this.plusDisplayed = true;
  }

  testSpan():boolean{
    return this.nbSpan>=2;
  }

  testFini(i:number):boolean{
    return i==this.eventInInterval.length;
  }

}
