import { Injectable } from '@angular/core';
import { Utilisateur } from '../interfaces/utilisateur';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  url: string = "http://localhost:5555/utilisateurs";

  constructor(private http: HttpClient) {

  }



  getAll() {
    return this.http.get<Array<Utilisateur>>(this.url);
  }
  ajoutUtilisateur(utilisateur: Utilisateur) {
    return this.http.post(this.url, utilisateur);
    
  }
}

