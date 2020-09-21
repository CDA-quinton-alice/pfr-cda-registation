import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

// Bonjour Mathieu Ambroise ! Aimes tu l'ambroisie ? 

@Component({
  selector: 'app-ajouter-document',
  templateUrl: './ajouter-document.component.html',
  styleUrls: ['./ajouter-document.component.css']
})
export class AjouterDocumentComponent implements OnInit {
  // todayNumber: number = Date.now();
  // todayDate: Date = new Date();
  // todayString: string = new Date().toDateString();
  // todayISOString: string = new Date().toISOString();
  // todayNumber2: number = Dat.now();
  // todayDate2: Date = new Date();
  // todayString: string = new Date().toDateString();
  // todayISOString2: string = new Date().toISOString();
  // documentForm = new FormGroup({
  // nomDocument: new FormControl('', Validators.required),
  //  categorieDocument = new FormControl('', Validators.required),
  //   dateAjoutDocument = new FormControl(todayISOString, Validators.required),
  //   dateDerniereModificationDocument: new FormControl(todayISOString2, Validators.required),
  //   descriptionDocument: new FormControl('', Validators.required),
  //   commentairesDocument: new FormControl('', Validators.required),
  //   matriculeUtilisateur: new FormControl('', Validators.required),
  // });
  document: Document;
  documents: Array<Document> = [];
  DocumentForm: FormGroup;

  constructor() {
  }

  ngOnInit(): void {
  }
  // get nomDocument() {
  //   return this.documentForm.get('nomDocument');
  // }
  //
  // get categorieDocument() {
  //   return this.documentForm.get('categorieDocument');
  // }
  //
  // get dateAjoutDocument() {
  //   return this.documentForm.get('dateAjoutDocument');
  // }
  //
  // get dateDerniereModificationDocument() {
  //   return this.documentForm.get('dateDerniereModificationDocument');
  // }
  //
  // get descriptionDocument() {
  //   return this.documentForm.get('descriptionDocument');
  // }
  //
  // get commentairesDocument() {
  //   return this.documentForm.get('commentairesDocument');
  // }
  //
  // get matriculeUtilisateur() {
  //   return this.documentForm.get('matriculeUtilisateur');
  // }
}
