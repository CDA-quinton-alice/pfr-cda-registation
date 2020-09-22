import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {DocumentService} from '../../../services/document.service';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {IDocument} from '../../../interfaces/idocument';


@Component({
  selector: 'app-ajouter-document',
  templateUrl: './ajouter-document.component.html',
  styleUrls: ['./ajouter-document.component.css']
})
export class AjouterDocumentComponent {
  document: IDocument;
  documentList: Array<IDocument> = [];
  date1: Date = new Date();
  date2: Date = new Date();
  todayNumber: number = Date.now();
  todayDate: Date = new Date();
  todayString: string = new Date().toDateString();
  todayISOString: string = new Date().toISOString();
  todayNumber2: number = Date.now();
  todayDate2: Date = new Date();
  todayString2: string = new Date().toDateString();
  todayISOString2: string = new Date().toISOString();
  documentForm = this.fb.group({
    nomDocument: ['', [Validators.required]],
    categorieDocument: ['', [Validators.required]],
    dateAjoutDocument: [this.date1, [Validators.required]],
    dateDerniereModificationDocument: [this.date2, [Validators.required]],
    descriptionDocument: ['', [Validators.required]],
    commentairesDocument: ['', [Validators.required]],
    matriculeUtilisateur: ['', [Validators.required]],
  })


  // documentForm = new FormGroup({
  // nomDocument: new FormControl('', Validators.required),
  //  categorieDocument = new FormControl('', Validators.required),
  //   dateAjoutDocument = new FormControl(todayISOString, Validators.required),
  //   dateDerniereModificationDocument: new FormControl(todayISOString2, Validators.required),
  //   descriptionDocument: new FormControl('', Validators.required),
  //   commentairesDocument: new FormControl('', Validators.required),
  //   matriculeUtilisateur: new FormControl('', Validators.required),
  // });

  constructor(private route: ActivatedRoute, private router: Router, private documentService: DocumentService, private fb: FormBuilder) {
  }
  addMateriel(){
    this.document = (this.documentForm.value as IDocument);
    this.documentService.addDocument(this.document).subscribe(result => this.goToDocumentList());
  }
  goToDocumentList(){
    this.router.navigate(['document/liste']);
  }
  // addDocument(){
  //   this.documentService.addDocument(this.document).subscribe(result => this.goToDocumentList());
  // }
  //
  // goToDocumentList(){
  //   this.router.navigate(['document/liste']);
  // }
}
