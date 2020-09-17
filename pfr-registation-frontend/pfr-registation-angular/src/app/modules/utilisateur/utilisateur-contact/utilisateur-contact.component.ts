import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UtilisateurService } from '../services/utilisateur.service';

@Component({
  selector: 'app-utilisateur-contact',
  templateUrl: './utilisateur-contact.component.html',
  styleUrls: ['./utilisateur-contact.component.css']
})
export class UtilisateurContactComponent implements OnInit {

  email: string;

  contactForm = new FormGroup({
    email: new FormControl(''),
  });

  constructor(private utilisateurService: UtilisateurService ,private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
  }



  envoyer() {
    console.log(this.contactForm.get('email'));
    this.email = this.contactForm.value;
    console.log(this.email);
    
    this.utilisateurService.contactUs(this.email);

  }

  gotoUtilisateurListe() {
    this.router.navigate(['/utilisateur/liste']);
  }
}
