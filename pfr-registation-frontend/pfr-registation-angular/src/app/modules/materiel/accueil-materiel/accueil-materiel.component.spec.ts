import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccueilMaterielComponent } from './accueil-materiel.component';

describe('AccueilMaterielComponent', () => {
  let component: AccueilMaterielComponent;
  let fixture: ComponentFixture<AccueilMaterielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccueilMaterielComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccueilMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
