import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StandingslistComponent } from './standingslist.component';

describe('StandingslistComponent', () => {
  let component: StandingslistComponent;
  let fixture: ComponentFixture<StandingslistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StandingslistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StandingslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
