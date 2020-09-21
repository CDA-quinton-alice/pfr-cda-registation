import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MajNomDocumentComponent } from './maj-nom-document.component';

describe('MajNomDocumentComponent', () => {
  let component: MajNomDocumentComponent;
  let fixture: ComponentFixture<MajNomDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MajNomDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MajNomDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
