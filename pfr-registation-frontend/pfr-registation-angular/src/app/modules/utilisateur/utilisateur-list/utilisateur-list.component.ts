import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../interfaces/utilisateur';
import { UtilisateurService } from '../services/utilisateur.service';

@Component({
  selector: 'app-utilisateur-list',
  templateUrl: './utilisateur-list.component.html',
  styleUrls: ['./utilisateur-list.component.css']
})
export class UtilisateurListComponent implements OnInit {
  utilisateur: Utilisateur = {};
  utilisateurs: Array<Utilisateur> = [];

  constructor(private utilisateurService: UtilisateurService) { }

  ngOnInit() {
    this.utilisateurService.getAll().subscribe(res => {
      this.utilisateurs = res;
    });
  }

}
