import { Component, OnInit } from '@angular/core';
import {IDocument} from '../../../interfaces/idocument';
import {DocumentService} from '../../../services/document.service';

@Component({
  selector: 'app-liste-document',
  templateUrl: './liste-document.component.html',
  styleUrls: ['./liste-document.component.css']
})
export class ListeDocumentComponent implements OnInit {

  document: IDocument;
  documentList: Array<IDocument> = [];

  constructor(private documentService: DocumentService) { }

  ngOnInit(): void {
    this.documentService.findAll().subscribe(data => {
      this.documentList = data;
    });
  }

}
