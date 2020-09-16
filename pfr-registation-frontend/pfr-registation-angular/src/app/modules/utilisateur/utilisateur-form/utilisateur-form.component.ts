import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Utilisateur } from '../interfaces/utilisateur';
import { UtilisateurService } from '../services/utilisateur.service';


@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.css']
})
export class UtilisateurFormComponent implements OnInit {
  utilisateur: Utilisateur;
  utilisateurs: Array<Utilisateur> = [];

  utilisateurForm = this.fb.group({
    matricule: ['', Validators.required],
    nom: ['', Validators.required],
    prenom: ['', Validators.required],
    dateDeNaissance: ['', Validators.required],
    salaire: ['', Validators.required],
    mail: ['', Validators.required],
    tel: ['', Validators.required],
    responsable: ['', Validators.required]






  });


  constructor(private utilisateurService: UtilisateurService,
    private fb: FormBuilder) {
  }

  ngOnInit() {
    this.utilisateurService.findAll().subscribe(res => {
      this.utilisateurs = res;
    });
  }
  ajouterUtilisateur() {
    this.utilisateurService.save(this.utilisateur).subscribe(res => {
      console.log(res);
      this.utilisateurService.findAll().subscribe(result => {
        this.utilisateurs = result;
      });
    });
  }

  afficherUser() {
    console.log("COUCOUCOU");

  }

}
