import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {MatDatepicker} from '@angular/material/datepicker';
import {MatDialog} from '@angular/material/dialog';
import {getMatScrollStrategyAlreadyAttachedError} from '@angular/cdk/overlay/scroll/scroll-strategy';

@Component({
  selector: 'app-ajouter-document',
  templateUrl: './ajouter-document.component.html',
  styleUrls: ['./ajouter-document.component.css']
})
export class AjouterDocumentComponent implements OnInit {
  documentForm = new FormGroup({
  nomDocument: new FormControl('', Validators.required),
    categorieDocument: new FormControl('', Validators.required),
    dateAjoutDocument: new FormControl('', Validators.required),
    dateDerniereModificationDocument: new FormControl('', Validators.required),
    descriptionDocument: new FormControl('', Validators.required),
    commentairesDocument: new FormControl('', Validators.required),
    matriculeUtilisateur: new FormControl('', Validators.required),
  });

  constructor() {
  }

  ngOnInit(): void {
  }

  get idDocument() {
    return this.documentForm.get('idDocument');
  }

  get nomDocument() {
    return this.documentForm.get('nomDocument');
  }

  get categorieDocument() {
    return this.documentForm.get('categorieDocument');
  }

  get dateAjoutDocument() {
    return this.documentForm.get('dateAjoutDocument');
  }

  get dateDerniereModificationDocument() {
    return this.documentForm.get('dateDerniereModificationDocument');
  }

  get descriptionDocument() {
    return this.documentForm.get('descriptionDocument');
  }

  get commentairesDocument() {
    return this.documentForm.get('commentairesDocument');
  }

  get matriculeUtilisateur() {
    return this.documentForm.get('matriculeUtilisateur');
  }
}
