import { inject, TestBed } from '@angular/core/testing';
import { Icalendrier } from 'src/app/interfaces/icalendrier';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { EvenementService } from './evenement.service';
import { DatePipe } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';

describe('EvenementService', () => {
  let mockHttp: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [EvenementService,DatePipe,MatDialog]
    }); 

    mockHttp = TestBed.inject(HttpTestingController);
  });

  it('should be created', inject([EvenementService], (service: EvenementService) => {
    expect(service).toBeTruthy();
  }));
  
  /*
  

  it('Test findByYearMonth', () =>{
    service.findByYearMonth('RESP001',2020,10,'n')
      .subscribe((resp:Icalendrier) =>{
        expect(resp.calendrier.length).toBeGreaterThan(0);
      })
  });

  it('Test createEvenement', () =>{

  });

  it('Test updateEvenement', () =>{

  });

  it('Test deleteEvenement', () =>{

  });
  */
});
