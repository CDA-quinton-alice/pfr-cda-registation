import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { Ievent } from 'src/app/interfaces/ievent';
import { EvenementService } from 'src/app/services/evenement/evenement.service';


@Component({
  selector: 'app-ajout-modal',
  templateUrl: './ajout-modal.component.html',
  styleUrls: ['./ajout-modal.component.css']
})

export class AjoutModalComponent implements OnInit {
  model: NgbDateStruct;
  model2: NgbDateStruct;
  event: Ievent = {};

  constructor(private fb: FormBuilder, private eserv: EvenementService) { }

  ngOnInit(): void {
  }

  ajouterEvenement(){
    if(this.event){
      this.eserv.createEvenement(this.event);
      console.log("Component: ajout");
    }
  }
}
