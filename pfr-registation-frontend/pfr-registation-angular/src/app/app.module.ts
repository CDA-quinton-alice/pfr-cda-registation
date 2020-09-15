import { BrowserModule } from '@angular/platform-browser';
import { NgModule , CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UtilisateurModule } from './modules/utilisateur/utilisateur.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { SharedModule } from './modules/shared/shared.module';
import { MaterielModule } from './modules/materiel/materiel.module';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserService } from './user-service.service';
import { FormsModule } from '@angular/forms';
import { MaterielService } from './services/materiel.service';
import { ReactiveFormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    AppComponent,

    UserListComponent,
    UserFormComponent,
   
   
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
    
  ],

  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
