import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {DocumentService} from '../../../services/document.service';
import {ActivatedRoute, Router} from '@angular/router';
import {IDocument} from '../../../interfaces/idocument';

// Bonjour Mathieu Ambroise ! Aimes tu l'ambroisie ?

@Component({
  selector: 'app-ajouter-document',
  templateUrl: './ajouter-document.component.html',
  styleUrls: ['./ajouter-document.component.css']
})
export class AjouterDocumentComponent {
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

  document: IDocument;
  listeDocuments: Array<IDocument> = [];

  constructor(private route: ActivatedRoute, private router: Router, private documentService: DocumentService) {
  }

  addDocument(){
    this.documentService.addDocument(this.document).subscribe(result => this.goToDocumentList());
  }

  goToDocumentList(){
    this.router.navigate(['document/liste']);
  }
}
