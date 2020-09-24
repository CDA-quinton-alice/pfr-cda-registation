import { Component, OnInit } from '@angular/core';
import { Imateriel } from 'src/app/interfaces/imateriel';
import { MaterielService } from 'src/app/services/materiel-service/materiel.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { DeleteModalComponent } from '../delete-modal/delete-modal.component';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-liste-materiel',
  templateUrl: './liste-materiel.component.html',
  styleUrls: ['./liste-materiel.component.css']
})
export class ListeMaterielComponent implements OnInit {


  materiel: Imateriel = {};
  list_materiel: Array<Imateriel> = [];
  monType: string;
  
  constructor(private materielService: MaterielService,public dialog: MatDialog, private fb: FormBuilder ) { }

  ngOnInit(): void {

    this.materielService.findAll().subscribe(data => {
      this.list_materiel = data;
    })
  }

  getAllByType(monType: string) {

    this.materielService.findAllByType(monType).subscribe(data => {
    this.list_materiel = data;
    })
  }

  deleteModal(idModal: number){
    const dialogRef = this.dialog.open(DeleteModalComponent, {
      width: '40rem',
      height:'31rem',
      data: {idToDelete: idModal}     
    });
    console.log(idModal)
  }
}