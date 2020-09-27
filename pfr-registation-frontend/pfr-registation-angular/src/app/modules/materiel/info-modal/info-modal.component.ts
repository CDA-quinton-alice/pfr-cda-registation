import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { IMaterielUtils } from 'src/app/interfaces/i-materiel-utils';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel-service/materiel.service';

@Component({
  selector: 'app-info-modal',
  templateUrl: './info-modal.component.html',
  styleUrls: ['./info-modal.component.css']
})
export class InfoModalComponent implements OnInit {

  materiel: Imateriel = {};
  
  constructor(private fb: FormBuilder, private materielService: MaterielService,
    private router: Router,public dialogRef: MatDialogRef<InfoModalComponent>,  @Inject(MAT_DIALOG_DATA) public data: IMaterielUtils) { }

  ngOnInit(): void {

   this.getMaterielById(this.data.idMaterielUtils);
   
  }

  
  getMaterielById(idMaterielUtils: number) {
    this.materielService.findById(idMaterielUtils).subscribe(res => {
      this.materiel = res;
    });
  }

  deleteMateriel() {
    this.materielService.deleteMateriel(this.data.idMaterielUtils).subscribe(result => this.gotoMaterielList());
  }

  gotoMaterielList() {
    this.onNoClick(); 
    this.router.navigate(['/materiel']);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
