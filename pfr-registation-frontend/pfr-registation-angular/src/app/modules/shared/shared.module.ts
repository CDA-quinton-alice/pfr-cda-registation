import { NgModule, ANALYZE_FOR_ENTRY_COMPONENTS } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedRoutingModule } from './shared-routing.module';
import { FondComponent } from './fond/fond.component';
import { HeaderComponent } from './header/header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';

import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatBadgeModule} from '@angular/material/badge';

import {MatButtonModule} from '@angular/material/button';


@NgModule({
  declarations: [FondComponent, HeaderComponent],
  exports: [HeaderComponent,FondComponent],

  imports: [
    CommonModule,
    SharedRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    MatBadgeModule,
   
  ]
})
export class SharedModule { }
