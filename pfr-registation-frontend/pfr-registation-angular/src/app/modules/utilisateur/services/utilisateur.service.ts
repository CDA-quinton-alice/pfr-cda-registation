import { Injectable } from '@angular/core';
import { Utilisateur } from '../interfaces/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {
utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor() {
    this.utilisateurs.push({ nom:'AMB', prenom:'mat'});
    this.utilisateurs.push({ nom:'AMB', prenom:'aug'});
    this.utilisateurs.push({ nom:'AMB', prenom:'cam'});
   }
  
  
  
  getAll(){
    return this.utilisateurs;
  }
    ajoutUtilisateur(utilisateur: Utilisateur){
      this.utilisateurs.push(utilisateur);
    }
  }

