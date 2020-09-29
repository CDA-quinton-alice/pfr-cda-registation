import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  panelOpenState = false;
  // subjectConnexion: Subject<number>;

  constructor(private authService: AuthService,private router: Router) { }

  ngOnInit(): void {
  }
  logout() {
    this.authService.logout();
  }
}
