import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilisateurContactComponent } from './utilisateur-contact.component';

describe('UtilisateurContactComponent', () => {
  let component: UtilisateurContactComponent;
  let fixture: ComponentFixture<UtilisateurContactComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilisateurContactComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UtilisateurContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
