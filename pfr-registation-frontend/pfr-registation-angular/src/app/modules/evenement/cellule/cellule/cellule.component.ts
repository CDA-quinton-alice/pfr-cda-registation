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
  
  constructor() {
   }
 
  ngOnInit(): void {
  }

  estDansIntervale(d1:Date,d2:Date,t:Date):boolean{
    let date1 = new Date((d1.getMonth()+1)+"/"+d1.getDate()+"/"+d1.getFullYear());
    let date2 = new Date((d2.getMonth()+1)+"/"+d2.getDate()+"/"+d2.getFullYear());
    let test = new Date((t.getMonth()+1)+"/"+t.getDate()+"/"+t.getFullYear());

    return date1<=test&&test<=date2;
  }

  getEventColor(e:Ievent):string{
    switch(e.type){
      case 'Autre':
          return "";
        break;
      case 'Révision':
        return "";
        break;
      case 'Inspection':
        return "";
        break;
      case 'Panne':
        return "";
        break;
    }
  }
}
