import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UtilisateurModule } from './modules/utilisateur/utilisateur.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { SharedModule } from './modules/shared/shared.module';
import { MaterielModule } from './modules/materiel/materiel.module';
import { FormsModule } from '@angular/forms';
import { DocumentModule } from './modules/document/document.module';
import { AjouterDocumentModule } from './modules/document/ajouter-document/ajouter-document.module';
import { SupprimerDocumentModule } from './modules/document/supprimer-document/supprimer-document.module';
import { MajNomDocumentModule } from './modules/document/maj-nom-document/maj-nom-document.module';
import { MajCategorieDocumentModule } from './modules/document/maj-categorie-document/maj-categorie-document.module';
import { MajDateAjoutDocumentModule } from './modules/document/maj-date-ajout-document/maj-date-ajout-document.module';
import { MajDerniereModificationDocumentModule } from './modules/document/maj-derniere-modification-document/maj-derniere-modification-document.module';
import { MajDescriptionDocumentModule } from './modules/document/maj-description-document/maj-description-document.module';
import { MajCommentairesDocumentModule } from './modules/document/maj-commentaires-document/maj-commentaires-document.module';
import { MajMatriculeUtilisateurModule } from './modules/document/maj-matricule-utilisateur/maj-matricule-utilisateur.module';
import { ListeDocumentModule } from './modules/document/liste-document/liste-document.module';
import { DocumentExistByIdModule } from './modules/document/document-exist-by-id/document-exist-by-id.module';
import { GetDocumentByNomModule } from './modules/document/get-document-by-nom/get-document-by-nom.module';
import { GetDocumentByIdModule } from './modules/document/get-document-by-id/get-document-by-id.module';
import { EvenementModule } from './modules/evenement/evenement.module';
import { MaterielService } from './services/materiel-service/materiel.service';

import { JwtModule } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import { AuthInterceptor } from './interceptor/auth.interceptor';
import { LoginComponent } from './login/login.component';


export function jwtTokenGetter() {
  return localStorage.getItem('access_token');
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
  ],

  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    UtilisateurModule,
    MaterielModule,
    SharedModule,
    FormsModule,
    DocumentModule,
    AjouterDocumentModule,
    SupprimerDocumentModule,
    MajNomDocumentModule,
    MajCategorieDocumentModule,
    MajDateAjoutDocumentModule,
    MajDerniereModificationDocumentModule,
    MajDescriptionDocumentModule,
    MajCommentairesDocumentModule,
    MajMatriculeUtilisateurModule,
    ListeDocumentModule,
    DocumentExistByIdModule,
    GetDocumentByNomModule,
    GetDocumentByIdModule,
    EvenementModule,

    JwtModule.forRoot({
      config: {
        // pour injecter le token dans toutes les requetes
        tokenGetter: jwtTokenGetter,
       
        // inject le token pour tous ces chemin
        allowedDomains: [environment.backServer],

        // n'injecte pas le token pour ce chemin
        disallowedRoutes: [`${environment.backSchema}://${environment.backServer}/login`]
      }
    }),
  ],

  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
    MaterielService],
  bootstrap: [AppComponent]
})
export class AppModule { }
