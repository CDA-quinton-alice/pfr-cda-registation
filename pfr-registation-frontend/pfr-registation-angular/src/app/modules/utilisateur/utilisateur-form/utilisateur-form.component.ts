import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../interfaces/utilisateur';

@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.css']
})
export class UtilisateurFormComponent implements OnInit {
  utilisateur: Utilisateur = {};
  constructor() { }

  ngOnInit(): void {
  }

  onAjoutUtilisateur(){
    
  }

}
