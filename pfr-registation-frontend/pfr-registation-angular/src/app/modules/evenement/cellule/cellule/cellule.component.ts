import { Component, Input, OnInit } from '@angular/core';
import { Ievent } from 'src/app/interfaces/ievent';

@Component({
  selector: 'app-cellule',
  templateUrl: './cellule.component.html',
  styleUrls: ['./cellule.component.css']
})
export class CelluleComponent implements OnInit {

  @Input() event: Array<Ievent>;
  @Input() jour: string;
  @Input() dates: Date;
  @Input() tete: boolean;
  @Input() headColor:String;

  nbSpan: number;
  plusDisplayed: boolean = false;
  constructor() {
   }
 
  ngOnInit(): void {
    this.nbSpan=0;
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

  incSpan(){
    this.nbSpan++;
  }

  testSpan():boolean{
    return this.nbSpan>=2;
  }
  testFini(i:number):boolean{
    console.log("i: "+i+" taille : "+this.event.length+" : "+(i==this.event.length));
    return i==this.event.length;
  }

  setPlusDisplayed(){
    this.plusDisplayed = true;
  }
  
  resetSpan(){
    this.nbSpan=0;
    this.plusDisplayed = false;
  }

  isPlusDisplayed():boolean{
    return this.plusDisplayed;
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
}
