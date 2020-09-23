import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Router } from '@angular/router';
import { IMaterielDelete } from 'src/app/interfaces/i-materiel-delete';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel-service/materiel.service';

@Component({
  selector: 'app-delete-modal',
  templateUrl: './delete-modal.component.html',
  styleUrls: ['./delete-modal.component.css']
})
export class DeleteModalComponent implements OnInit {

  idToDelete: number;
  materiel: Imateriel = {};
  
  constructor(private fb: FormBuilder, private materielService: MaterielService,
    private router: Router,public dialogRef: MatDialogRef<DeleteModalComponent>,  @Inject(MAT_DIALOG_DATA) public data: IMaterielDelete) { }

  ngOnInit(): void {
  }

  afficherId(){
  alert(this.idToDelete)
}
  deleteMateriel(idMat: number) {
    this.materielService.deleteMateriel(idMat).subscribe(result => this.gotoMaterielList());
  }

  gotoMaterielList() {
    this.router.navigate(['/materiel/liste']);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
