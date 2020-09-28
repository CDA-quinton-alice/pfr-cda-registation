import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuth } from '../models/user-auth';

import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

user: UserAuth;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.user=new UserAuth();
    this.user.username='';
    this.user.password = '';
  }

}
