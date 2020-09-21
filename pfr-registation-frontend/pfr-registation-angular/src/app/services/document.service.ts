import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {findAll} from '@angular/compiler-cli/ngcc/src/utils';
import {Observable} from 'rxjs';
import {IDocument} from '../interfaces/idocument';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  url = 'http://localhost:8080/documents';

  constructor(
    private  http: HttpClient
  ) {}

  // 1) Créer de CRUD
  // CreerDocument(DocumentACreer: IDocument): Observable<IDocument[]>{
  //   // return this.http.post('${}')
//   }
}

