import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDocumentByNomComponent } from './get-document-by-nom.component';

describe('GetDocumentByNomComponent', () => {
  let component: GetDocumentByNomComponent;
  let fixture: ComponentFixture<GetDocumentByNomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDocumentByNomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetDocumentByNomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
