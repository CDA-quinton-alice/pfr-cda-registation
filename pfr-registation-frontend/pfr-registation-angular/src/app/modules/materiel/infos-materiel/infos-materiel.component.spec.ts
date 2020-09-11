import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfosMaterielComponent } from './infos-materiel.component';

describe('InfosMaterielComponent', () => {
  let component: InfosMaterielComponent;
  let fixture: ComponentFixture<InfosMaterielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfosMaterielComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfosMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
