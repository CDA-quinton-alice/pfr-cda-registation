import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Imateriel } from '../interfaces/imateriel';

@Injectable({
  providedIn: 'root'
})
export class MaterielService {

list_materiel: Array<Imateriel>= new Array<Imateriel> ();

url:string = "http://localhost:5555/materiel";

  constructor(private http: HttpClient) { 

this.list_materiel.push({id: 1,ref: 'P002' ,marque: 'Orion' , modele:'Pisto3000' ,prix: 2000 ,etat: 1 ,type_materiel: 'POMPE' ,date_achat: '12-12-2019',localisation: 'Allée 1' });
this.list_materiel.push({id: 2,ref: 'C003' ,marque: 'Neptune' , modele:'C5000' ,prix: 2500 ,etat: 1 ,type_materiel: 'CUVE' ,date_achat: '12-12-2019',localisation: 'Allée 2' });


}
  getAll(){
    return this.http.get<Array<Imateriel>>(this.url);
  }

  addMateriel(mat: Imateriel){
    return this.http.post(this.url, mat);
  }


}
