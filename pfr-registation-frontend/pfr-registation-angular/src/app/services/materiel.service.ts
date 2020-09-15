import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Imateriel } from '../interfaces/imateriel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MaterielService {

  list_materiel: Array<Imateriel> = new Array<Imateriel>();

  private url: string = "http://localhost:8080/materiel";

  formatsDateTest: string[] = ['dd/MM/yyyy'];
  dateNow: Date = new Date();

  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Imateriel[]> {
    return this.http.get<Imateriel[]>(this.url);
  }

  public findById(id: number): Observable<Imateriel> {
    return this.http.get<Imateriel>(this.url + "/" + id);
  }

  public addMateriel(mat: Imateriel) {
    return this.http.post<Imateriel>(this.url, mat);
  }

  
}
