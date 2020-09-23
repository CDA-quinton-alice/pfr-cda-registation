import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Imateriel } from 'src/app/interfaces/imateriel';
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


  public findAllByType(type: string): Observable<Imateriel[]> {

    return this.http.get<Imateriel[]>(this.url + "/listeMateriel/" + type);
  }

  public addMateriel(mat: Imateriel) {
    return this.http.post<Imateriel>(this.url, mat);
  }

  public deleteMateriel(id: number) {
   return this.http.post<Imateriel>(this.url + "/" + id + "/delete", id);
  }


  public updateMateriel(mat:Imateriel){
    return this.http.post<Imateriel>(this.url  + "/update",  mat);
  }
}
