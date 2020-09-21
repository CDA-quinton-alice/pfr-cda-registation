import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MajMatriculeUtilisateurComponent } from './maj-matricule-utilisateur.component';

describe('MajMatriculeUtilisateurComponent', () => {
  let component: MajMatriculeUtilisateurComponent;
  let fixture: ComponentFixture<MajMatriculeUtilisateurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MajMatriculeUtilisateurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MajMatriculeUtilisateurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
