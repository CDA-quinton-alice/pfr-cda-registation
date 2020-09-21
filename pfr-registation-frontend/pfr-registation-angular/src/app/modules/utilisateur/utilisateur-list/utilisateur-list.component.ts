import { Component, OnInit } from '@angular/core';
import { Utilisateur } from '../interfaces/utilisateur';
import { UtilisateurService } from '../services/utilisateur.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-utilisateur-list',
  templateUrl: './utilisateur-list.component.html',
  styleUrls: ['./utilisateur-list.component.css']
})
export class UtilisateurListComponent implements OnInit {
  utilisateur: Utilisateur;
  utilisateurs: Utilisateur[];
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
