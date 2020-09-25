import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { IMaterielUtils } from 'src/app/interfaces/i-materiel-utils';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel-service/materiel.service';

@Component({
  selector: 'app-delete-modal',
  templateUrl: './delete-modal.component.html',
  styleUrls: ['./delete-modal.component.css']
})
export class DeleteModalComponent implements OnInit {

  
  materiel: Imateriel = {};
  
  constructor(private fb: FormBuilder, private materielService: MaterielService,
    private router: Router,public dialogRef: MatDialogRef<DeleteModalComponent>,  @Inject(MAT_DIALOG_DATA) public data: IMaterielUtils) { }

  ngOnInit(): void {
  }


  deleteMateriel() {
    this.materielService.deleteMateriel(this.data.idMaterielUtils).subscribe(result => this.gotoMaterielList());
  }

  gotoMaterielList() {
    this.router.navigate(['/materiel/liste']);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
