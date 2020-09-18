import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageContact } from '../interfaces/messageContact';
import { UtilisateurService } from '../services/utilisateur.service';

@Component({
  selector: 'app-utilisateur-contact',
  templateUrl: './utilisateur-contact.component.html',
  styleUrls: ['./utilisateur-contact.component.css']
})
export class UtilisateurContactComponent implements OnInit {

  info: string;
  messageContact: MessageContact;

  contactForm: FormGroup;

  constructor(private utilisateurService: UtilisateurService, private route: ActivatedRoute,
    private router: Router, private fb: FormBuilder) {
    this.initForm();
  }

  initForm() {
    this.contactForm = this.fb.group({
      nom: ['AMB', Validators.required],
      prenom: ['MAT', Validators.required],
      email: ['', Validators.required],
      message: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  envoyer() {
    this.messageContact = <MessageContact>this.contactForm.value;
    console.log(this.contactForm.value);
    console.log(this.messageContact);

    this.utilisateurService.contactUs(this.messageContact).subscribe(res => 
      {
      this.messageContact= {};
      this.info = "Merci de nous avoir contacté !";
      }, 
      error => {
        console.log('erreur à afficher'+error);
        this.info = "Oh oh ! Une erreur s'est produite..."
      }
      );
  }


}
