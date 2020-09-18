import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MajDerniereModificationDocumentComponent } from './maj-derniere-modification-document.component';

describe('MajDerniereModificationDocumentComponent', () => {
  let component: MajDerniereModificationDocumentComponent;
  let fixture: ComponentFixture<MajDerniereModificationDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MajDerniereModificationDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MajDerniereModificationDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
