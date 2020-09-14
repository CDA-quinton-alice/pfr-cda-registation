import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Utilisateur } from '../interfaces/utilisateur';

@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.css']
})
export class UtilisateurFormComponent implements OnInit {

  utilisateurForm = new FormGroup({
    id: new FormControl('', Validators.required),
    nom: new FormControl('', [Validators.pattern(/^[A-Z] [a-z] {2,10}/), Validators.required]),
    prenom: new FormControl('', [Validators.required, this.checkPrenomValidator])
  });

  checkPrenomValidator(control: FormControl) {
    const str: string = control.value;
    if (str[0] >= 'A' && str[0] <= 'Z') {
      return null;
    } else {
      return { erreur: 'prénom invalide' };
    }
  }

  constructor() { }

  ngOnInit() {

  }

  onAjoutUtilisateur() {

  }
  afficherData() {
    console.log(this.utilisateurForm.value);
    console.log(this.utilisateurForm.get("nom"));
    console.log(this.utilisateurForm.controls.nom);
    console.log(this.utilisateurForm.get("prenom"));
  }

  ajouterUtilisateur() {

  }

  get nom() {
    return this.utilisateurForm.get('nom');
  }

  get id() {
    return this.utilisateurForm.get('id');
  }

  get prenom() {
    return this.utilisateurForm.get('prenom');
  }
}
