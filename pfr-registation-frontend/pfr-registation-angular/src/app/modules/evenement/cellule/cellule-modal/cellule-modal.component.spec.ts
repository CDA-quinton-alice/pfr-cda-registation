import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelluleModalComponent } from './cellule-modal.component';

describe('CelluleModalComponent', () => {
  let component: CelluleModalComponent;
  let fixture: ComponentFixture<CelluleModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CelluleModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CelluleModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
