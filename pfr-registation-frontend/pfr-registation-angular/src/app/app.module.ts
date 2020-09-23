import { BrowserModule } from '@angular/platform-browser';
import { NgModule , CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UtilisateurModule } from './modules/utilisateur/utilisateur.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from './modules/shared/shared.module';
import { MaterielModule } from './modules/materiel/materiel.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MaterielService } from './services/materiel.service';
import { DocumentModule } from './modules/document/document.module';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { EvenementModule } from './modules/evenement/evenement.module';
import { DocumentFormComponent } from './modules/document/document-form/document-form.component';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {ListeDocumentComponent} from './modules/document/liste-document/liste-document.component';
import {MatCardModule} from '@angular/material/card';




@NgModule({
  declarations: [
    AppComponent,
    ListeDocumentComponent,
    DocumentFormComponent,
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
    EvenementModule,
    ReactiveFormsModule,
    MatIconModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatCardModule,
  ],

  providers: [MaterielService],
  bootstrap: [AppComponent]
})
export class AppModule { }
