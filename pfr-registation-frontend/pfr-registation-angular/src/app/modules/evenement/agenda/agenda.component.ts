import { Component, OnInit } from '@angular/core';
import { Icalendrier } from 'src/app/interfaces/icalendrier';
import { EvenementService } from 'src/app/services/evenement/evenement.service';

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.css']
})
export class AgendaComponent implements OnInit {

  year: number;
  month:number;
  action: string;
  calendrier: Icalendrier;
  constructor(private eServ:EvenementService) { }

  ngOnInit(): void {
    this.year = 2020;
    this.month = 9;
    this.action= "n";
    this.eServ.findByYearMonth( this.year, this.month, this.action).subscribe(data => {
      console.log("test");
      console.log(data);
      this.calendrier = data;
    })
  }

}
