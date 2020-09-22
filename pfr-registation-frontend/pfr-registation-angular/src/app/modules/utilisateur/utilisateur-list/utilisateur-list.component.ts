import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { IUtilisateur } from 'src/app/interfaces/iutilisateur';
import { IUtilisateurSimple } from 'src/app/interfaces/iutilisateurSimple';
import { UtilisateurService } from 'src/app/services/utilisateur-service/utilisateur.service';

@Component({
  selector: 'app-utilisateur-list',
  templateUrl: './utilisateur-list.component.html',
  styleUrls: ['./utilisateur-list.component.css']
})
export class UtilisateurListComponent implements OnInit {
  utilisateur: IUtilisateur;
  utilisateurs: IUtilisateurSimple[];
  matricule: string;
  constructor(private utilisateurService: UtilisateurService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.utilisateurService.findAll().subscribe(res => {
      this.utilisateurs = res;
      console.log(this.utilisateurs);
    });
  }

  supprimerUtilisateur(matricule: string) {
    console.log(matricule);
    this.utilisateurService.supprimerUtilisateur(matricule).subscribe(res => this.ngOnInit()
    )
  };

}
