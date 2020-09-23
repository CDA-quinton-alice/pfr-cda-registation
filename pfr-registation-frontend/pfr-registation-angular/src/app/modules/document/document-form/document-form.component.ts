import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {DocumentService} from '../../../services/document.service';
import {IDocument} from '../../../interfaces/idocument';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-document-form',
  templateUrl: './document-form.component.html',
  styleUrls: ['./document-form.component.css']
})
export class DocumentFormComponent implements OnInit {

  document: IDocument;
  documentList: Array<IDocument> = [];
  documentForm: FormGroup;
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
  constructor(private route: ActivatedRoute, private router: Router, private documentService: DocumentService, private fb: FormBuilder) {
    this.initForm();
  }
  initForm(): void{
    this.documentForm = this.fb.group({
      nomDocument: ['facture pompe n°7', [Validators.required]],
      categorieDocument: ['facture', [Validators.required]],
      dateAjoutDocument: [this.date1, [Validators.required]],
      dateDerniereModificationDocument: [this.date2, [Validators.required]],
      descriptionDocument: ['Ceci est la facture de la pompe n°7', [Validators.required]],
      commentairesDocument: ['Rien de particulier à signaler', [Validators.required]],
      matriculeUtilisateur: ['RESP001', [Validators.required]],
    });
}

ngOnInit() {
    this.documentService.findAll().subscribe(result => {
      this.documentList = result;
    });
}
ajouterDocument() {
    this.document = <IDocument> this.documentForm.value;
    console.log(this.documentForm.value);
    console.log(this.document);
    this.documentService.save(this.document).subscribe(result => this.goToDocumentList());
}
goToDocumentList(){
    this.router.navigate(['documents']);
}

}
