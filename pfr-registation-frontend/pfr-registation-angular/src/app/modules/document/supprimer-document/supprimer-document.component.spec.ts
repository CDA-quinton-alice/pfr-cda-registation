import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupprimerDocumentComponent } from './supprimer-document.component';

describe('SupprimerDocumentComponent', () => {
  let component: SupprimerDocumentComponent;
  let fixture: ComponentFixture<SupprimerDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupprimerDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SupprimerDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
