import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTeamStandingsListComponent } from './user-team-standings-list.component';

describe('UserTeamStandingsListComponent', () => {
  let component: UserTeamStandingsListComponent;
  let fixture: ComponentFixture<UserTeamStandingsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserTeamStandingsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserTeamStandingsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
