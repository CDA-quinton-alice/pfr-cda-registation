import { Component, OnInit } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { IUtilisateurSimple } from '../interfaces/iutilisateurSimple';
import { User } from '../models/user';
import { UserAuth } from '../models/user-auth';
import { AuthService } from '../services/auth.service';
import { UtilisateurService } from '../services/utilisateur-service/utilisateur.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  currentUser: User;
  utilisateur: IUtilisateurSimple;

  constructor(private authService: AuthService,
    private utilisateurService: UtilisateurService) { }

  ngOnInit(): void {
    this.currentUser = this.authService.getCurrentUser();
    console.log(this.currentUser.matricule);
    this.utilisateurService.findByMatricule(this.currentUser.matricule).subscribe(res => {
      this.utilisateur = res;
    });
  }



}
