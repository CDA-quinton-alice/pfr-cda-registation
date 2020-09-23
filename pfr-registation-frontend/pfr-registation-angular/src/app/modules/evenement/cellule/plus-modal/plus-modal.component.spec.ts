import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlusModalComponent } from './plus-modal.component';

describe('PlusModalComponent', () => {
  let component: PlusModalComponent;
  let fixture: ComponentFixture<PlusModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlusModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlusModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
