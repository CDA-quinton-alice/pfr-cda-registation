import { Injectable } from '@angular/core';
import { Utilisateur } from '../interfaces/utilisateur';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
  url: string = "http://localhost:8080/utilisateurtest";

  constructor(private http: HttpClient) {

  }

  findAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(this.url);
  }
  save(utilisateur: Utilisateur) {
    return this.http.post<Utilisateur>(this.url, utilisateur);
  }
}

