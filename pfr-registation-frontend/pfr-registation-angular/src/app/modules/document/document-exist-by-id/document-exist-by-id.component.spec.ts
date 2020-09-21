import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentExistByIdComponent } from './document-exist-by-id.component';

describe('DocumentExistByIdComponent', () => {
  let component: DocumentExistByIdComponent;
  let fixture: ComponentFixture<DocumentExistByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentExistByIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentExistByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
