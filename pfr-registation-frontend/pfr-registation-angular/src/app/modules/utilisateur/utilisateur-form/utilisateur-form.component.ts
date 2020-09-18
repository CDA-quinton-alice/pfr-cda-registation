import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Utilisateur } from '../interfaces/utilisateur';
import { UtilisateurService } from '../services/utilisateur.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-utilisateur-form',
  templateUrl: './utilisateur-form.component.html',
  styleUrls: ['./utilisateur-form.component.css']
})
export class UtilisateurFormComponent implements OnInit {
  utilisateur: Utilisateur = {};
  utilisateurs: Array<Utilisateur> = [];
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
    this.utilisateur = <Utilisateur> this.utilisateurForm.value;
    console.log(this.utilisateurForm.value);
    console.log(this.utilisateur);
        
    this.utilisateurService.save(this.utilisateur).subscribe(res => this.gotoUtilisateurListe());
  }

  gotoUtilisateurListe() {
    this.router.navigate(['/utilisateur/liste']);
  }
}
