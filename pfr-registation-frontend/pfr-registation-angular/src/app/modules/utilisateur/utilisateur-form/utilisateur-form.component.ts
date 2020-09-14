import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Utilisateur } from '../interfaces/utilisateur';
import { UtilisateurService } from '../services/utilisateur.service';

@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.css']
})
export class UtilisateurFormComponent implements OnInit {
  utilisateur: Utilisateur = {};
  utilisateurs: Array<Utilisateur> = [];
  constructor(private utilisateurService: UtilisateurService) { }

  ngOnInit() {
    this.utilisateurService.getAll().subscribe(res => {
      this.utilisateurs = res;
    });
  }
  ajouterUtilisateur() {
    this.utilisateurService.ajoutUtilisateur(this.utilisateur).subscribe(res => {
      console.log(res);
      this.utilisateurService.getAll().subscribe(result => {
        this.utilisateurs = result;
      });
    });
  }
}
