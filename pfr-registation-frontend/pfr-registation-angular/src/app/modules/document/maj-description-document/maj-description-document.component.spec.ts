import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MajDescriptionDocumentComponent } from './maj-description-document.component';

describe('MajDescriptionDocumentComponent', () => {
  let component: MajDescriptionDocumentComponent;
  let fixture: ComponentFixture<MajDescriptionDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MajDescriptionDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MajDescriptionDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
