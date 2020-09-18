import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetDocumentByIdComponent } from './get-document-by-id.component';

describe('GetDocumentByIdComponent', () => {
  let component: GetDocumentByIdComponent;
  let fixture: ComponentFixture<GetDocumentByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetDocumentByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetDocumentByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
