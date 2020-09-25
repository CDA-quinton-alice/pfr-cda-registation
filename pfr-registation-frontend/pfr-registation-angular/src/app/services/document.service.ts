import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {findAll} from '@angular/compiler-cli/ngcc/src/utils';
import {Observable} from 'rxjs';
import {IDocument} from '../interfaces/idocument';

@Injectable({
  providedIn: 'root'
})
export class DocumentService {
  documentsListe: Array<IDocument> = new Array<IDocument>();
  private documentsUrl: string;
  formatsDateTest2: string[] = ['dd/MM/yyyy'];
  dateNow2: Date = new Date();

  constructor(private  http: HttpClient) {
    this.documentsUrl = 'http://localhost:8080/documenttest';
  }
//   // CRUD Generique
//   // 1) Créer du crud
// ajouterDocument<T>(model: T | any, documentToCreate: T | any): Observable<T | T[]>{
//     return this.http.post<T | T[]>('${this.documentsUrl}/${model.tableName}', documentToCreate);
// }
// // 2) consulter du crud
//   readDocument<T>(model: T | any): Observable<T | T[]>{
//     return this.http.get<T | T[]>('${this.documentsUrl}/${model.tableName}');
//   }
//   // 3) maj du Crud
//   updateDocument<T>(model: T | any, documentToUpdate: T | any): Observable<T | T[]>{
//     return this.http.patch<T | T[]>('${this.documentsUrl}/${model.tableName}/{documentToUpdate.id}', documentToUpdate);
//   }
//   // 4) supprimer du crud
//   deleteDocument<T>(model: T | any, documentToDelete): Observable<T | T[]>{
//     return this.http.delete<T | T[]>('${this.documentsUrl}/${model.tableName}${documentToDelete.id}');
//   }
//   findAll<T>(model: T | any): Observable<T | T []>{
//     return this.http.get<T | T[]>('${this.documentsUrl}/');
//   }
  public findAll(): Observable<IDocument[]>{
    return this.http.get<IDocument[]>(this.documentsUrl);
    //Elle est où ta page là ?
  }
  public findById(idDocument: number): Observable<IDocument>{
    return this.http.get<IDocument>(this.documentsUrl + '/' + idDocument);
  }
  public findByNom(nomDocument: string): Observable<IDocument> {
    return this.http.get<IDocument>(this.documentsUrl + '/' + nomDocument);
  }
  public addDocument(document: IDocument) {
    return this.http.post<IDocument>(this.documentsUrl, document);
  }
  public deleteDocument(idDocument: number) {
    return this.http.delete<IDocument>(this.documentsUrl + '/' + 'delete' + idDocument);
  }
  public save(document: IDocument): Observable<any>{
    return this.http.post<IDocument>(this.documentsUrl, document);
  }
}
