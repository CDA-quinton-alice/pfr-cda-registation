import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MajCategorieDocumentComponent } from './maj-categorie-document.component';

describe('MajCategorieDocumentComponent', () => {
  let component: MajCategorieDocumentComponent;
  let fixture: ComponentFixture<MajCategorieDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MajCategorieDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MajCategorieDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
