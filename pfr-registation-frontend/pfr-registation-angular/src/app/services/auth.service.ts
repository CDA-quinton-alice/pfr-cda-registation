import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JwtHelperService } from '@auth0/angular-jwt';

import { User } from '../models/user';
import { UserAuth } from '../models/user-auth';



@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url: string;
  subjectConnexion: Subject<number>;
  currentUser: User;


  constructor(private router: Router,
    private http: HttpClient) {
    // this.url = `${environment.backSchema}://${environment.backServer}/login`;
    this.url = "http://localhost:8080/login";
    this.subjectConnexion = new Subject<number>();
  }

  isConnected(): boolean {
    return Boolean(localStorage.getItem('isConnected'));
  }

  getCurrentUser(): User {
    const userStr = localStorage.getItem('current_user');
    return JSON.parse(userStr);
  }

  login(user: UserAuth): Observable<boolean> {
    return new Observable(
      observer => {
        this.http.post(this.url, user).subscribe(
          res => {
            localStorage.setItem('isConnected', 'true');
            localStorage.setItem('access_token', res['token']);
            const currentUser = new User();
            const helper = new JwtHelperService();

            const decodedToken = helper.decodeToken(res['token']);
            currentUser.matricule = decodedToken.sub;
            currentUser.nom = decodedToken.username;

            currentUser.responsable = decodedToken.roles; //attention boolean ??

            localStorage.setItem('current_user', JSON.stringify(currentUser));

            this.subjectConnexion.next(3);
            // this.alertService.addSuccess('bienvenu '+currentUser.nom);
            observer.next(true);
          },
          () => {
            observer.next(false);
          },
          () => {
            observer.complete();
          });
      });

  }

  logout() {
    localStorage.removeItem('isConnected');
    localStorage.removeItem('access_token');
    localStorage.removeItem('current_user');
    this.subjectConnexion.next(3);
    this.router.navigateByUrl('/login'); //rediriger vers page d'accueil
  }


}
