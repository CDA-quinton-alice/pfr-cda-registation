import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../interfaces/utilisateur';
import { UtilisateurService } from '../services/utilisateur.service';

@Component({
  selector: 'app-utilisateur-list',
  templateUrl: './utilisateur-list.component.html',
  styleUrls: ['./utilisateur-list.component.css']
})
export class UtilisateurListComponent implements OnInit {

  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor(private utilisateurService: UtilisateurService) { }

  ngOnInit(): void {
    this.utilisateurs = this.utilisateurService.getAll();
  }

}
