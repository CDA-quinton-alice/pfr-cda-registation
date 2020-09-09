import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContentComponent } from './component/content/content.component';
import { PresentationTeamComponent } from './presentation-team/presentation-team.component';
import { UtilisateurModule } from './modules/utilisateur/utilisateur.module';
import { FooterComponent } from './shared/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    PresentationTeamComponent,
    FooterComponent
  ],
 
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    UtilisateurModule   
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
