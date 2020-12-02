import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IUtilisateur } from 'src/app/interfaces/iutilisateur';
import { UtilisateurService } from 'src/app/services/utilisateur-service/utilisateur.service';

@Component({
  selector: 'app-utilisateur-update',
  templateUrl: './utilisateur-update.component.html',
  styleUrls: ['./utilisateur-update.component.css']
})
export class UtilisateurUpdateComponent implements OnInit {

  utilisateur: IUtilisateur = {};

  constructor(private route: ActivatedRoute,
    private router: Router, 
    private utilisateurService: UtilisateurService) {}

  ngOnInit(): void {
  }

  updateUtilisateur(){
    this.utilisateurService.updateUtilisateur(this.utilisateur).subscribe(result => this.goToList());
  }

  goToList(){
    this.router.navigate(['/utilisateur/liste']);
  }
}
