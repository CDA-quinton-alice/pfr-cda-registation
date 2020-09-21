import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { ActivatedRoute, Router } from '@angular/router';
import { IUtilisateur } from 'src/app/interfaces/iutilisateur';
import { UtilisateurService } from 'src/app/services/utilisateur-service/utilisateur.service';


@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.css']
})
export class UtilisateurFormComponent implements OnInit {
  utilisateur: IUtilisateur = {};
  utilisateurs: Array<IUtilisateur> = [];
  utilisateurForm: FormGroup;

  constructor(private utilisateurService: UtilisateurService,
    private fb: FormBuilder, private route: ActivatedRoute,
    private router: Router) {
    this.initForm();
  }

//Vérification des inputs saisis restent à faire
  initForm(): void {
    this.utilisateurForm = this.fb.group({
      matricule: ['TEST001', Validators.required],
      nom: ['AMB', Validators.required],
      prenom: ['MAT', Validators.required],
      dateDeNaissance: ['15-01-1999', Validators.required],
      salaire: ['1', Validators.required],
      mail: ['mat@gmail.com', Validators.required],
      tel: ['0707070707', Validators.required],
      responsable: ['', Validators.required],

      password: ['aze', Validators.required],

      numero: ['2', Validators.required],
      rue: ['rue du chat', Validators.required],
      complement: ['complement', Validators.required],
      codePostal: ['59000', Validators.required],
      ville: ['LILLE', Validators.required],
      pays: ['FRANCE', Validators.required]
    });
  }

  ngOnInit() {
    this.utilisateurService.findAll().subscribe(res => {
      this.utilisateurs = res;
    });
  }
  ajouterUtilisateur() {
    this.utilisateur = <IUtilisateur> this.utilisateurForm.value;
    console.log(this.utilisateurForm.value);
    console.log(this.utilisateur);
        
    this.utilisateurService.save(this.utilisateur).subscribe(res => this.gotoUtilisateurListe());
  }

  gotoUtilisateurListe() {
    this.router.navigate(['/utilisateur/liste']);
  }
}
