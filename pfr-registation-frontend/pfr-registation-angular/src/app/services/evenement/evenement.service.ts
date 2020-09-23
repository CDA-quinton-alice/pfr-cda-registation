import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Icalendrier } from 'src/app/interfaces/icalendrier';
import { Ievent } from 'src/app/interfaces/ievent';
import { DatePipe, formatDate } from '@angular/common';
import { map } from 'jquery';

@Injectable({
  providedIn: 'root'
})
export class EvenementService {
  calendrier: Icalendrier;
  ev:Ievent;
  private url: string = "http://localhost:8080/evenement";

  headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient,public datepipe: DatePipe) { }

  public findByYearMonth(year: number, month: number, action:string): Observable<Icalendrier> {
    if(action.length<=1){
      return this.http.get<Icalendrier>(this.url+"/"+year+"/"+month+"/"+action);
    }
  }

  public createEvenement(event:Ievent){
    console.log("service: ajout");
    return this.http.post<Ievent>(this.url+"/create",{type:event.type, description:event.description,date_debut:event.date_debut, date_fin:event.date_fin});

  }

/**  public findById(id: number): Observable<Imateriel> {
    return this.http.get<Imateriel>(this.url + "/" + id);
  }

  public addMateriel(mat: Imateriel) {
    return this.http.post<Imateriel>(this.url, mat);
  } */
}
