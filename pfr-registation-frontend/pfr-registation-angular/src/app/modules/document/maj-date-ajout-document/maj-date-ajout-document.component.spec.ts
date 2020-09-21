import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MajDateAjoutDocumentComponent } from './maj-date-ajout-document.component';

describe('MajDateAjoutDocumentComponent', () => {
  let component: MajDateAjoutDocumentComponent;
  let fixture: ComponentFixture<MajDateAjoutDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MajDateAjoutDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MajDateAjoutDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
