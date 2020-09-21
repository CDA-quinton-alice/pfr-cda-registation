import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MajCommentairesDocumentComponent } from './maj-commentaires-document.component';

describe('MajCommentairesDocumentComponent', () => {
  let component: MajCommentairesDocumentComponent;
  let fixture: ComponentFixture<MajCommentairesDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MajCommentairesDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MajCommentairesDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
