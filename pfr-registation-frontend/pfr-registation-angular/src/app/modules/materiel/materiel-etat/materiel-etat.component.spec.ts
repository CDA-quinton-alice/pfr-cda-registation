import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MaterielEtatComponent } from './materiel-etat.component';

describe('MaterielEtatComponent', () => {
  let component: MaterielEtatComponent;
  let fixture: ComponentFixture<MaterielEtatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MaterielEtatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MaterielEtatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
