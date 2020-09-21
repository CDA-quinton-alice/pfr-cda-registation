import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Icalendrier } from 'src/app/interfaces/icalendrier';
import { EvenementService } from 'src/app/services/evenement/evenement.service';
import { Ievent } from 'src/app/interfaces/ievent';
import * as $ from "jquery";

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.css']
})
export class AgendaComponent implements OnInit {

  year: number;
  month:number;
  action: string;
  cal: Icalendrier;
  calendar: Array<Date> = new Array<Date>();
  evenements: Array<Ievent> = new Array<Ievent>();
  format = 'dd/MM/yyyy';
  local = 'fr-FR';
  numbers:Array<number>;
  titre:string;
  
  chunkSize= 7;
  groupsCalendar = this.calendar.map((x,index)=>{
    return index % this.chunkSize === 0 ? this.calendar.slice(index, index + this.chunkSize): null; 
  }).filter(x=>x);

  constructor(private eServ:EvenementService) {
    this.numbers = [0,1,2,3,4,5,6];
   }


  ngOnInit(): void {
    this.year = new Date().getFullYear();
    this.month = new Date().getMonth()+1;
    this.action= "n"; 
    this.getMonth(this.year, this.month, this.action);
  }
  getCalendrier(){
    return (this.cal&&this.cal.calendrier)?this.cal.calendrier:[];
  }

  getEvents(){
    return (this.cal&&this.cal.event)?this.cal.event:[];
  }

  formatDateCustom(cal:Array<string>){
    for(let c of cal){
      let str = c.split('-')[3]+'-'+c.split('-')[2]+'-'+c.split('-')[1];
      let d = new Date(Date.parse(str));
      this.calendar.push(d);
    }
  }
  formatEventDate(events:Array<Ievent>){
    for(let e of events){
      e.date_debut = new Date(e.date_debut);
      e.date_fin = new Date(e.date_fin);
      this.evenements.push(e);
    }
  }

  getMonth(year:number,month:number,action:string){
    this.eServ.findByYearMonth(year,month,action).subscribe(data => {
      this.calendar = new Array<Date>();
      this.evenements = new Array<Ievent>();
      this.cal = data;
      if(action=="p"){
        if(month>1){
          this.month = month-1;
          this.year = year;
        }else{
          this.month = 12;
          this.year = year-1;
        }
      }else if(action == "s"){
        if(month<12){
          this.month = month+1;
          this.year = year;
        }else{
          this.month = 1;
          this.year = year+1;
        }
      }else if(action =="n"){
        this.year = new Date().getFullYear();
        this.month = new Date().getMonth()+1;
      }
      this.formatDateCustom(this.getCalendrier());
      this.formatEventDate(this.getEvents());
      this.titre = this.formatMonth(this.month);

      this.groupsCalendar = this.calendar.map((x,index)=>{
        return index % this.chunkSize === 0 ? this.calendar.slice(index, index + this.chunkSize): null; 
      }).filter(x=>x);

    })
  }

  formatMonth(month:number):string{
    switch(month){
      case 1:
        return "Janvier";
        break;
      case 2:
        return "Février";
        break;
      case 3:
        return "Mars";
        break;
      case 4:
        return "Avril";
        break;
      case 5:
        return "Mai";
        break;
      case 6:
        return "Juin";
        break;
      case 7:
        return "Juillet";
        break;
      case 8:
        return "Août";
        break;
      case 9:
        return "Septembre";
        break;
      case 10:
        return "Octobre";
        break;
      case 11:
        return "Novembre";
        break;
      case 12:
        return "Décembre";
        break;
    }
  }
  resetCal(){
    $(".calendrier table tr").remove();
  } 
}
